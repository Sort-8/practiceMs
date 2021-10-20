package com.ruoyi.web.controller.system;

import java.util.List;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.system.domain.SysBaseInfo;
import com.ruoyi.system.service.ISysBaseInfoService;
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

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 基地信息管理Controller
 *
 * @author xieweiming
 * @date 2021-10-01
 */
@RestController
@RequestMapping("/system/baseInfo")
public class SysBaseInfoController extends BaseController
{
    @Autowired
    private ISysBaseInfoService sysBaseInfoService;

    /**
     * 获取所有基地信息的经纬度
     *
     * @return 所有基地信息的经纬度
     */
    @PreAuthorize("@ss.hasPermi('baseInfo:baseInfo:list')")
    @GetMapping("/selectBaseTudeAndID")
    public AjaxResult selectBaseTudeAndID()
    {
        return AjaxResult.success(sysBaseInfoService.selectBaseTudeAndID());
    }

    /**
     * 查询基地信息管理列表
     */
    @PreAuthorize("@ss.hasPermi('baseInfo:baseInfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysBaseInfo sysBaseInfo)
    {
        startPage();
        List<SysBaseInfo> list = sysBaseInfoService.selectSysBaseInfoList(sysBaseInfo);
        return getDataTable(list);
    }

    /**
     * 导出基地信息管理列表
     */
    @PreAuthorize("@ss.hasPermi('baseInfo:baseInfo:export')")
    @Log(title = "基地信息管理", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(SysBaseInfo sysBaseInfo)
    {
        List<SysBaseInfo> list = sysBaseInfoService.selectSysBaseInfoList(sysBaseInfo);
        ExcelUtil<SysBaseInfo> util = new ExcelUtil<SysBaseInfo>(SysBaseInfo.class);
        return util.exportExcel(list, "基地信息管理数据");
    }

    /**
     * 状态修改
     */
    @PreAuthorize("@ss.hasPermi('baseInfo:baseInfo:edit')")
    @Log(title = "基地信息管理", businessType = BusinessType.UPDATE)
    @PutMapping("/changeStatus")
    public AjaxResult changeStatus(@RequestBody SysBaseInfo sysBaseInfo)
    {
        sysBaseInfo.setUpdateBy(SecurityUtils.getUsername());
        return toAjax(sysBaseInfoService.updateBaseInfoStatus(sysBaseInfo));
    }

    /**
     * 获取基地信息管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('baseInfo:baseInfo:query')")
    @GetMapping(value = "/{baseId}")
    public AjaxResult getInfo(@PathVariable("baseId") Long baseId)
    {
        return AjaxResult.success(sysBaseInfoService.selectSysBaseInfoById(baseId));
    }

    /**
     * 新增基地信息管理
     */
    @PreAuthorize("@ss.hasPermi('baseInfo:baseInfo:add')")
    @Log(title = "基地信息管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysBaseInfo sysBaseInfo)
    {
        return toAjax(sysBaseInfoService.insertSysBaseInfo(sysBaseInfo));
    }

    /**
     * 修改基地信息管理
     */
    @PreAuthorize("@ss.hasPermi('baseInfo:baseInfo:edit')")
    @Log(title = "基地信息管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysBaseInfo sysBaseInfo)
    {
        return toAjax(sysBaseInfoService.updateSysBaseInfo(sysBaseInfo));
    }

    /**
     * 删除基地信息管理
     */
    @PreAuthorize("@ss.hasPermi('baseInfo:baseInfo:remove')")
    @Log(title = "基地信息管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{baseIds}")
    public AjaxResult remove(@PathVariable Long[] baseIds)
    {
        return toAjax(sysBaseInfoService.deleteSysBaseInfoByIds(baseIds));
    }
}
