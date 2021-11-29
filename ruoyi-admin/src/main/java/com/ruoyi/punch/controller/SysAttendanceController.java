package com.ruoyi.punch.controller;

import java.util.List;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.ServletUtils;
import com.ruoyi.framework.web.service.TokenService;
import com.ruoyi.punch.service.ArchivedAttendanceService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.punch.domain.SysAttendance;
import com.ruoyi.punch.service.ISysAttendanceService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 打卡签到Controller
 *
 * @author ruoyi
 * @date 2021-09-29
 */
@RestController
@RequestMapping("/punch/punch")
public class SysAttendanceController extends BaseController
{
    @Autowired
    private ISysAttendanceService sysAttendanceService;

    @Autowired
    private ArchivedAttendanceService archivedAttendanceService;

    @Autowired
    private TokenService tokenService;

    /**
     * 查询打卡签到列表
     */
    @PreAuthorize("@ss.hasPermi('punch:punch:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysAttendance sysAttendance)
    {
        startPage();
        List<SysAttendance> list = sysAttendanceService.selectSysAttendanceList(sysAttendance);
        return getDataTable(list);
    }

    /**
     * 导出打卡签到列表
     */
    @PreAuthorize("@ss.hasPermi('punch:punch:export')")
    @Log(title = "打卡签到", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(SysAttendance sysAttendance)
    {
        List<SysAttendance> list = sysAttendanceService.selectSysAttendanceList(sysAttendance);
        ExcelUtil<SysAttendance> util = new ExcelUtil<SysAttendance>(SysAttendance.class);
        return util.exportExcel(list, "打卡签到数据");
    }

    /**
     * 获取打卡签到详细信息
     */
    @PreAuthorize("@ss.hasPermi('punch:punch:query')")
    @GetMapping(value = "/{attendanceId}")
    public AjaxResult getInfo(@PathVariable("attendanceId") Long attendanceId)
    {
        return AjaxResult.success(sysAttendanceService.selectSysAttendanceById(attendanceId));
    }

    /**
     * 新增打卡签到
     */
//    @PreAuthorize("@ss.hasPermi('punch:punch:add')")
    @Log(title = "打卡签到", businessType = BusinessType.INSERT)
    @GetMapping(value = "/addPunch")
    public AjaxResult add(@RequestParam String address)
    {
        SysAttendance sysAttendance = new SysAttendance();
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        SysUser user = loginUser.getUser();
        sysAttendance.setUserName(user.getUserName());
        sysAttendance.setLocation(address);
        return toAjax(sysAttendanceService.insertSysAttendance(sysAttendance));
    }

    /**
     * 修改打卡签到
     */
    @PreAuthorize("@ss.hasPermi('punch:punch:edit')")
    @Log(title = "打卡签到", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysAttendance sysAttendance)
    {
        return toAjax(sysAttendanceService.updateSysAttendance(sysAttendance));
    }

    /**
     * 删除打卡签到
     */
    @PreAuthorize("@ss.hasPermi('punch:punch:remove')")
    @Log(title = "打卡签到", businessType = BusinessType.DELETE)
	@DeleteMapping("/{attendanceIds}")
    public AjaxResult remove(@PathVariable Long[] attendanceIds)
    {
        return toAjax(sysAttendanceService.deleteSysAttendanceByIds(attendanceIds));
    }

    /**
     * 小程序获得用户打卡列表
     */
    @PreAuthorize("@ss.hasPermi('punch:punch:list')")
    @GetMapping("/listDetail")
    public AjaxResult list()
    {
        SysAttendance sysAttendance = new SysAttendance();
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        SysUser user = loginUser.getUser();
        sysAttendance.setUserName(user.getUserName());
        List<SysAttendance> list = sysAttendanceService.selectSysAttendanceList(sysAttendance);
        return AjaxResult.success(list);
    }

    /**
     * 获得当天所有打卡人数
     */
    @GetMapping("/getTodayPunchList")
    public AjaxResult getTodayPunchList()
    {
//        List<SysAttendance> list = sysAttendanceService.selectTodayPunchList();
        return AjaxResult.success(sysAttendanceService.selectTodayPunchList());
    }

    /**
     * 小程序获得当前用户当天是否打卡
     */
//    @PreAuthorize("@ss.hasPermi('punch:punch:repeat')")
    @GetMapping("/getTodayPunch")
    public AjaxResult getTodayPunch()
    {
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        SysUser user = loginUser.getUser();
        SysAttendance sysAttendance = sysAttendanceService.selectSysAttendanceByUName(user.getUserName());
        return AjaxResult.success(sysAttendance);
    }

    @GetMapping("/selectNowWeekAttendanceList")
    public AjaxResult selectNowWeekAttendanceList()
    {
        int[] data = sysAttendanceService.selectNowWeekAttendanceList();
        return AjaxResult.success(data);
    }


    /**
     * 导出归档数据
     */
    @GetMapping("/exportArchived")
    public AjaxResult exportArchived(SysAttendance sysAttendance)
    {
        List<SysAttendance> list = archivedAttendanceService.selectSysAttendanceList(sysAttendance);
        ExcelUtil<SysAttendance> util = new ExcelUtil<SysAttendance>(SysAttendance.class);
        return util.exportExcel(list, "打卡签到数据");
    }

}
