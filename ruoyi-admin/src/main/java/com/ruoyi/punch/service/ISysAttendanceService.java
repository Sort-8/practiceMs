package com.ruoyi.punch.service;

import java.util.List;
import com.ruoyi.punch.domain.SysAttendance;

/**
 * 打卡签到Service接口
 *
 * @author ruoyi
 * @date 2021-09-29
 */
public interface ISysAttendanceService
{
    /**
     * 查询打卡签到
     *
     * @param attendanceId 打卡签到ID
     * @return 打卡签到
     */
    public SysAttendance selectSysAttendanceById(Long attendanceId);

    /**
     * 查询打卡签到列表
     *
     * @param sysAttendance 打卡签到
     * @return 打卡签到集合
     */
    public List<SysAttendance> selectSysAttendanceList(SysAttendance sysAttendance);

    /**
     * 新增打卡签到
     *
     * @param sysAttendance 打卡签到
     * @return 结果
     */
    public int insertSysAttendance(SysAttendance sysAttendance);

    /**
     * 修改打卡签到
     *
     * @param sysAttendance 打卡签到
     * @return 结果
     */
    public int updateSysAttendance(SysAttendance sysAttendance);

    /**
     * 批量删除打卡签到
     *
     * @param attendanceIds 需要删除的打卡签到ID
     * @return 结果
     */
    public int deleteSysAttendanceByIds(Long[] attendanceIds);

    /**
     * 删除打卡签到信息
     *
     * @param attendanceId 打卡签到ID
     * @return 结果
     */
    public int deleteSysAttendanceById(Long attendanceId);


    /**
     * 当天打卡状态
     * @param userName
     * @return
     */
    public SysAttendance selectSysAttendanceByUName(String userName);

}
