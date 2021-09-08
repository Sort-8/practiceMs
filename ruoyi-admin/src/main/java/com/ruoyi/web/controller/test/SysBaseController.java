package com.ruoyi.web.controller.test;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.SysBase;
import com.ruoyi.system.service.ISysBaseService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 实习基地信息Controller
 * 
 * @author tomorrow
 * @date 2021-08-16
 */
@RestController
@RequestMapping("/system/base")
public class SysBaseController extends BaseController
{
    @Autowired
    private ISysBaseService sysBaseService;

    /**
     * 查询实习基地信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:base:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysBase sysBase)
    {
        startPage();
        List<SysBase> list = sysBaseService.selectSysBaseList(sysBase);
        return getDataTable(list);
    }

    /**
     * 导出实习基地信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:base:export')")
    @Log(title = "实习基地信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(SysBase sysBase)
    {
        List<SysBase> list = sysBaseService.selectSysBaseList(sysBase);
        ExcelUtil<SysBase> util = new ExcelUtil<SysBase>(SysBase.class);
        return util.exportExcel(list, "实习基地信息数据");
    }

    /**
     * 获取实习基地信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:base:query')")
    @GetMapping(value = "/{baseId}")
    public AjaxResult getInfo(@PathVariable("baseId") Long baseId)
    {
        return AjaxResult.success(sysBaseService.selectSysBaseById(baseId));
    }

    /**
     * 新增实习基地信息
     */
    @PreAuthorize("@ss.hasPermi('system:base:add')")
    @Log(title = "实习基地信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysBase sysBase)
    {
        return toAjax(sysBaseService.insertSysBase(sysBase));
    }

    /**
     * 修改实习基地信息
     */
    @PreAuthorize("@ss.hasPermi('system:base:edit')")
    @Log(title = "实习基地信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysBase sysBase)
    {
        return toAjax(sysBaseService.updateSysBase(sysBase));
    }

    /**
     * 删除实习基地信息
     */
    @PreAuthorize("@ss.hasPermi('system:base:remove')")
    @Log(title = "实习基地信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{baseIds}")
    public AjaxResult remove(@PathVariable Long[] baseIds)
    {
        return toAjax(sysBaseService.deleteSysBaseByIds(baseIds));
    }
}
