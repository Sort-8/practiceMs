package com.ruoyi.practicelog.controller;

import java.util.Date;
import java.util.List;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.ServletUtils;
import com.ruoyi.framework.web.service.TokenService;
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
import com.ruoyi.practicelog.domain.SysPracticeLog;
import com.ruoyi.practicelog.service.ISysPracticeLogService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 实习日志Controller
 *
 * @author 涛哥
 * @date 2021-09-26
 */
@RestController
@RequestMapping("/practicelog/practicelog")
public class SysPracticeLogController extends BaseController
{
    @Autowired
    private ISysPracticeLogService sysPracticeLogService;

    @Autowired
    private TokenService tokenService;

    /**
     * 查询实习日志列表
     */
    @PreAuthorize("@ss.hasPermi('practicelog:practicelog:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysPracticeLog sysPracticeLog)
    {
        startPage();
        List<SysPracticeLog> list = sysPracticeLogService.selectSysPracticeLogList(sysPracticeLog);
        return getDataTable(list);
    }

    /**
     * 导出实习日志列表
     */
    @PreAuthorize("@ss.hasPermi('practicelog:practicelog:export')")
    @Log(title = "实习日志", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(SysPracticeLog sysPracticeLog)
    {
        List<SysPracticeLog> list = sysPracticeLogService.selectSysPracticeLogList(sysPracticeLog);
        ExcelUtil<SysPracticeLog> util = new ExcelUtil<SysPracticeLog>(SysPracticeLog.class);
        return util.exportExcel(list, "实习日志数据");
    }

    /**
     * 获取实习日志详细信息
     */
    @PreAuthorize("@ss.hasPermi('practicelog:practicelog:query')")
    @GetMapping(value = "/{logId}")
    public AjaxResult getInfo(@PathVariable("logId") Long logId)
    {
        return AjaxResult.success(sysPracticeLogService.selectSysPracticeLogById(logId));
    }

    /**
     * 新增实习日志
     */
    @PreAuthorize("@ss.hasPermi('practicelog:practicelog:add')")
    @Log(title = "实习日志", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysPracticeLog sysPracticeLog)
    {
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        SysUser user = loginUser.getUser();
        sysPracticeLog.setUserName(user.getUserName());
        sysPracticeLog.setTime(new Date());
        return toAjax(sysPracticeLogService.insertSysPracticeLog(sysPracticeLog));
    }

    /**
     * 修改实习日志
     */
    @PreAuthorize("@ss.hasPermi('practicelog:practicelog:edit')")
    @Log(title = "实习日志", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysPracticeLog sysPracticeLog)
    {
        return toAjax(sysPracticeLogService.updateSysPracticeLog(sysPracticeLog));
    }

    /**
     * 删除实习日志
     */
    @PreAuthorize("@ss.hasPermi('practicelog:practicelog:remove')")
    @Log(title = "实习日志", businessType = BusinessType.DELETE)
	@DeleteMapping("/{logIds}")
    public AjaxResult remove(@PathVariable Long[] logIds)
    {
        return toAjax(sysPracticeLogService.deleteSysPracticeLogByIds(logIds));
    }
}
