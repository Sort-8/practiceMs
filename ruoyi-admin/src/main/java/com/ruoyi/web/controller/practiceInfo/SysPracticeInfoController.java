package com.ruoyi.web.controller.practiceInfo;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.practiceInfo.domain.SysPracticeInfo;
import com.ruoyi.practiceInfo.service.ISysPracticeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 实习信息Controller
 *
 * @author YuYang
 * @date 2021-09-23
 */
@RestController
@RequestMapping("/practice-info/practiceInfo")
public class SysPracticeInfoController extends BaseController
{
    @Autowired
    private ISysPracticeInfoService sysPracticeInfoService;

    /**
     * 查询实习信息列表
     */
    @PreAuthorize("@ss.hasPermi('practice-info:practiceInfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysPracticeInfo sysPracticeInfo)
    {
        startPage();
        List<SysPracticeInfo> list = sysPracticeInfoService.selectSysPracticeInfoList(sysPracticeInfo);
        return getDataTable(list);
    }

    /**
     * 导出实习信息列表
     */
    @PreAuthorize("@ss.hasPermi('practice-info:practiceInfo:export')")
    @Log(title = "实习信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(SysPracticeInfo sysPracticeInfo)
    {
        List<SysPracticeInfo> list = sysPracticeInfoService.selectSysPracticeInfoList(sysPracticeInfo);
        ExcelUtil<SysPracticeInfo> util = new ExcelUtil<SysPracticeInfo>(SysPracticeInfo.class);
        return util.exportExcel(list, "实习信息数据");
    }

    /**
     * 获取实习信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('practice-info:practiceInfo:query')")
    @GetMapping(value = "/{infoId}")
    public AjaxResult getInfo(@PathVariable("infoId") Long infoId)
    {
        return AjaxResult.success(sysPracticeInfoService.selectSysPracticeInfoById(infoId));
    }

    /**
     * 新增实习信息
     */
    @PreAuthorize("@ss.hasPermi('practice-info:practiceInfo:add')")
    @Log(title = "实习信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysPracticeInfo sysPracticeInfo)
    {
        return toAjax(sysPracticeInfoService.insertSysPracticeInfo(sysPracticeInfo));
    }

    /**
     * 修改实习信息
     */
    @PreAuthorize("@ss.hasPermi('practice-info:practiceInfo:edit')")
    @Log(title = "实习信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysPracticeInfo sysPracticeInfo)
    {
        return toAjax(sysPracticeInfoService.updateSysPracticeInfo(sysPracticeInfo));
    }

    /**
     * 修改实习信息状态
     */
    @PreAuthorize("@ss.hasPermi('practice-info:practiceInfo:edit')")
    @Log(title = "实习信息状态", businessType = BusinessType.UPDATE)
    @PostMapping("/changeStatus")
    public AjaxResult changeStatus(@RequestBody SysPracticeInfo sysPracticeInfo)
    {
        return toAjax(sysPracticeInfoService.changeStatus(sysPracticeInfo));
    }

    /**
     * 删除实习信息
     */
    @PreAuthorize("@ss.hasPermi('practice-info:practiceInfo:remove')")
    @Log(title = "实习信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{infoIds}")
    public AjaxResult remove(@PathVariable Long[] infoIds)
    {
        return toAjax(sysPracticeInfoService.deleteSysPracticeInfoByIds(infoIds));
    }
}
