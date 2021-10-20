package com.ruoyi.web.controller.decentralize;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.decentralize.domain.SysDecentralizedPractice;
import com.ruoyi.decentralize.service.ISysDecentralizedPracticeService;
import com.ruoyi.framework.web.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
    @PreAuthorize("@ss.hasPermi('decentralize:decentralize:list')")
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
     * 修改分散实习申请
     */
    @PreAuthorize("@ss.hasPermi('decentralize:decentralize:edit')")
    @Log(title = "分散实习申请", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysDecentralizedPractice sysDecentralizedPractice)
    {
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
