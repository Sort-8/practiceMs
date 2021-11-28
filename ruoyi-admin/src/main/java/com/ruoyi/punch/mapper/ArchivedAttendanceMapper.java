package com.ruoyi.punch.mapper;

import com.ruoyi.punch.domain.SysAttendance;

import java.util.List;

public interface ArchivedAttendanceMapper {

    /**
     * 查询打卡签到列表
     *
     * @param sysAttendance 打卡签到
     * @return 打卡签到集合
     */
    public List<SysAttendance> selectSysAttendanceList(SysAttendance sysAttendance);

}
