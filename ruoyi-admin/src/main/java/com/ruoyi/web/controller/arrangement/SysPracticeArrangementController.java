package com.ruoyi.web.controller.arrangement;

import com.ruoyi.arrangement.domain.SysPracticeArrangement;
import com.ruoyi.arrangement.service.ArchivedArrangmentService;
import com.ruoyi.arrangement.service.ISysPracticeArrangementService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 实习安排Controller
 *
 * @author YuYang
 * @date 2021-09-23
 */
@RestController
@RequestMapping("/arrangement/arrangement")
public class SysPracticeArrangementController extends BaseController
{
    @Autowired
    private ISysPracticeArrangementService sysPracticeArrangementService;

    @Autowired
    private ArchivedArrangmentService archivedArrangmentService;

    @Autowired
    private TokenService tokenService;

    /**
     * 查询实习安排列表
     */
    @PreAuthorize("@ss.hasPermi('arrangement:arrangement:list')")
    @PostMapping("/list")
    public TableDataInfo list(SysPracticeArrangement sysPracticeArrangement)
    {
        startPage();
        List<SysPracticeArrangement> list = sysPracticeArrangementService.selectSysPracticeArrangementList(sysPracticeArrangement);
        return getDataTable(list);
    }

    /**
     * 查询实习安排列表
     */
    @PostMapping("/getScreenData")
    public AjaxResult getScreenData(SysPracticeArrangement sysPracticeArrangement)
    {
        Map map = sysPracticeArrangementService.getScreenData(sysPracticeArrangement);
        return AjaxResult.success(map);
    }

    /**
     * 查询各实习点人数
     */
    @PostMapping("/getLocationStudentNum")
    public AjaxResult getLocationStudentNum(SysPracticeArrangement sysPracticeArrangement)
    {
        List<ArrayList> map = sysPracticeArrangementService.getLocationStudentNum(sysPracticeArrangement);
        return AjaxResult.success(map);
    }

    /**
     * 查询实习安排列表
     */
    @PreAuthorize("@ss.hasPermi('arrangement:arrangement:list')")
    @PostMapping("/selectAllPractice")
    public TableDataInfo selectAllPractice(SysPracticeArrangement sysPracticeArrangement)
    {
        Map m = sysPracticeArrangementService.selectAllPractice(sysPracticeArrangement);
        return getDataObj(m);
    }

    /**
     * 老师指导的学生信息列表
     */
    @GetMapping("/stuInfoList")
    public TableDataInfo stuInfoList(SysPracticeArrangement sysPracticeArrangement)
    {
        startPage();
        List<SysPracticeArrangement> list = sysPracticeArrangementService.selectStudentInfo(sysPracticeArrangement);
        return getDataTable(list);
    }

    /**
     * 查询学生实习情况
     */
    @GetMapping("/getPracticeInfo")
    public AjaxResult getPracticeInfo(HttpServletRequest request)
    {
        SysPracticeArrangement pa = new SysPracticeArrangement();
        pa.setStuId(tokenService.getLoginUser(request).getUser().getUserId());
        pa.setUserName(tokenService.getLoginUser(request).getUsername());
        return AjaxResult.success(sysPracticeArrangementService.getPracticeInfo(tokenService.getLoginUser(request)));
    }

    /**
     * 导出实习安排列表
     */
    @PreAuthorize("@ss.hasPermi('arrangement:arrangement:export')")
    @Log(title = "实习安排", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(SysPracticeArrangement sysPracticeArrangement)
    {
        List<SysPracticeArrangement> list = sysPracticeArrangementService.selectSysPracticeArrangementList(sysPracticeArrangement);
        ExcelUtil<SysPracticeArrangement> util = new ExcelUtil<SysPracticeArrangement>(SysPracticeArrangement.class);
        return util.exportExcel(list, "实习安排数据");
    }

    /**
     * 获取实习安排详细信息
     */
    @PreAuthorize("@ss.hasPermi('arrangement:arrangement:query')")
    @GetMapping(value = "/{arrangementId}")
    public AjaxResult getInfo(@PathVariable("arrangementId") Long arrangementId)
    {
        return AjaxResult.success(sysPracticeArrangementService.selectSysPracticeArrangementById(arrangementId));
    }



    /**
     * 获取实习指导老师
     */
    @PreAuthorize("@ss.hasPermi('arrangement:arrangement:query')")
    @RequestMapping(value = "/getAllTeacher")
    public AjaxResult getAllTeacher(SysUser teacher)
    {
        return AjaxResult.success(sysPracticeArrangementService.getAllTeacher(teacher));
    }

    /**
     * 新增实习安排
     */
    @PreAuthorize("@ss.hasPermi('arrangement:arrangement:add')")
    @Log(title = "实习安排", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysPracticeArrangement sysPracticeArrangement)
    {
        return toAjax(sysPracticeArrangementService.insertSysPracticeArrangement(sysPracticeArrangement));
    }

    /**
     * 修改实习安排
     */
    @PreAuthorize("@ss.hasPermi('arrangement:arrangement:edit')")
    @Log(title = "实习安排", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysPracticeArrangement sysPracticeArrangement)
    {
        return toAjax(sysPracticeArrangementService.updateSysPracticeArrangement(sysPracticeArrangement));
    }

    /**
     * 删除实习安排
     */
    @PreAuthorize("@ss.hasPermi('arrangement:arrangement:remove')")
    @Log(title = "实习安排", businessType = BusinessType.DELETE)
	@DeleteMapping("/{arrangementIds}")
    public AjaxResult remove(@PathVariable Long[] arrangementIds)
    {
        return toAjax(sysPracticeArrangementService.deleteSysPracticeArrangementByIds(arrangementIds));
    }


    @GetMapping("/exportArchived")
    public AjaxResult exportArchived(SysPracticeArrangement sysPracticeArrangement)
    {
        List<SysPracticeArrangement> list = archivedArrangmentService.selectSysPracticeArrangementList(sysPracticeArrangement);
        ExcelUtil<SysPracticeArrangement> util = new ExcelUtil<SysPracticeArrangement>(SysPracticeArrangement.class);
        return util.exportExcel(list, "实习安排数据");
    }
}
