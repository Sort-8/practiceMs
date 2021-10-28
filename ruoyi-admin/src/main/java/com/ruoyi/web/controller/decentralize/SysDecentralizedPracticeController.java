package com.ruoyi.web.controller.decentralize;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.decentralize.domain.SysDecentralizedPractice;
import com.ruoyi.decentralize.service.ISysDecentralizedPracticeService;
import com.ruoyi.framework.web.service.TokenService;
import com.ruoyi.location.domain.LocationInfo;
import com.ruoyi.location.service.ILocationInfoService;
import com.ruoyi.practiceScore.domain.SysPracticeScore;
import com.ruoyi.web.controller.common.ConnectTencentCloud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 分散实习申请Controller
 *
 * @author YuYang
 * @date 2021-10-20
 */
@RestController
@RequestMapping("/decentralize/decentralize")
public class SysDecentralizedPracticeController extends BaseController
{
    @Autowired
    private ISysDecentralizedPracticeService sysDecentralizedPracticeService;

    @Autowired
    private ILocationInfoService locationInfoService;

    @Autowired
    private TokenService tokenService;

    /**
     * 查询分散实习申请列表
     */
    @PreAuthorize("@ss.hasPermi('decentralize:decentralize:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysDecentralizedPractice sysDecentralizedPractice)
    {
        startPage();
        List<SysDecentralizedPractice> list = sysDecentralizedPracticeService.selectSysDecentralizedPracticeList(sysDecentralizedPractice);
        return getDataTable(list);
    }

    /**
     * 查询分散实习学生
     */
//    @PreAuthorize("@ss.hasPermi('decentralize:decentralize:list')")
    @GetMapping("/getPracticeStudentInfo")
    public AjaxResult getPracticeStudentInfo(HttpServletRequest request)
    {
        return AjaxResult.success(sysDecentralizedPracticeService.getPracticeStudentInfo(tokenService.getLoginUser(request).getUsername()));
    }

    /**
     * 导出分散实习申请列表
     */
    @PreAuthorize("@ss.hasPermi('decentralize:decentralize:export')")
    @Log(title = "分散实习申请", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(SysDecentralizedPractice sysDecentralizedPractice)
    {
        List<SysDecentralizedPractice> list = sysDecentralizedPracticeService.selectSysDecentralizedPracticeList(sysDecentralizedPractice);
        ExcelUtil<SysDecentralizedPractice> util = new ExcelUtil<SysDecentralizedPractice>(SysDecentralizedPractice.class);
        return util.exportExcel(list, "分散实习申请数据");
    }

    /**
     * 获取分散实习申请详细信息
     */
    @PreAuthorize("@ss.hasPermi('decentralize:decentralize:query')")
    @GetMapping(value = "/{applyId}")
    public AjaxResult getInfo(@PathVariable("applyId") Long applyId)
    {
        return AjaxResult.success(sysDecentralizedPracticeService.selectSysDecentralizedPracticeById(applyId));
    }

    /**
     * 新增分散实习申请
     */
    @PreAuthorize("@ss.hasPermi('decentralize:decentralize:add')")
    @Log(title = "分散实习申请", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysDecentralizedPractice sysDecentralizedPractice)
    {
        return toAjax(sysDecentralizedPracticeService.insertSysDecentralizedPractice(sysDecentralizedPractice));
    }

    /**
     * 上传实习证明
     */
    @PostMapping("/uploadCertificate")
    public AjaxResult uploadCertificate(MultipartFile file, String companyName , String address , String tude , String contacts , String phone , String nature , String leader , String businessScope , String notes , String stuId , String nickName) throws Exception
    {
        try
        {
            //初始化腾讯云连接
            ConnectTencentCloud connectTencentCloud = new ConnectTencentCloud();
            File localFile = new File(file.getOriginalFilename());
            //将MultipartiFile转化为File
            org.apache.commons.io.FileUtils.copyInputStreamToFile(file.getInputStream(),localFile);
            //上传指定路径
            connectTencentCloud.uploadObject(localFile,"实习管理系统/实习鉴定/"+stuId+nickName+"的实习鉴定.pdf");
            // 新文件名称
            String fileName = "实习管理系统/实习鉴定/"+stuId+nickName+"的实习鉴定.pdf";
            //得到访问的URL
            String url = "https://shenwo-1302502474.cos.ap-nanjing.myqcloud.com/" + fileName;
            AjaxResult ajax = AjaxResult.success();
            ajax.put("fileName", fileName);
            ajax.put("url", url);
            if(stuId != null){
                System.out.println("ID为 " + stuId);
                LocationInfo locationInfo = new LocationInfo();
                locationInfo.setCompanyName(companyName);
                locationInfo.setAddress(address);
                locationInfo.setContacts(contacts);
                locationInfo.setLeader(leader);
                locationInfo.setPhone(phone);
                locationInfo.setNature(nature);
                locationInfo.setTude(tude);
                int id ;
                if((id = locationInfoService.insertLocationInfo(locationInfo)) > 0){
                    SysDecentralizedPractice practice = new SysDecentralizedPractice();
                    practice.setAcceptanceCertificate(url);
                    practice.setStuId(Long.parseLong(stuId));
                    practice.setBusinessScope(businessScope);
                    practice.setNotes(notes);
                    practice.setDelFlag("0");
                    practice.setLocationId((long) id);
                    practice.setStatus("0");
                    sysDecentralizedPracticeService.insertSysDecentralizedPractice(practice);
                }
            }
            System.out.println("文件上传成功："+url);
            return ajax;
        }
        catch (Exception e)
        {
            return AjaxResult.error(e.getMessage());
        }
    }

    /**
     * 修改分散实习申请
     */
    @PreAuthorize("@ss.hasPermi('decentralize:decentralize:edit')")
    @Log(title = "分散实习申请", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysDecentralizedPractice sysDecentralizedPractice , HttpServletRequest request)
    {
        SysUser u = tokenService.getLoginUser(request).getUser();
        sysDecentralizedPractice.setAuditorId(u.getUserId());
        sysDecentralizedPractice.setAuditTime(new Date());
        return toAjax(sysDecentralizedPracticeService.updateSysDecentralizedPractice(sysDecentralizedPractice));
    }

    /**
     * 删除分散实习申请
     */
    @PreAuthorize("@ss.hasPermi('decentralize:decentralize:remove')")
    @Log(title = "分散实习申请", businessType = BusinessType.DELETE)
	@DeleteMapping("/{applyIds}")
    public AjaxResult remove(@PathVariable Long[] applyIds)
    {
        return toAjax(sysDecentralizedPracticeService.deleteSysDecentralizedPracticeByIds(applyIds));
    }
}
