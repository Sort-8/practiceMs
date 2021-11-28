package com.ruoyi.practicelog.mapper;

import com.ruoyi.practicelog.domain.SysPracticeLog;

import java.util.List;

public interface ArchivedPracticeLogMapper {
    /**
     * 查询实习日志列表
     *
     * @param sysPracticeLog 实习日志
     * @return 实习日志集合
     */
    public List<SysPracticeLog> selectSysPracticeLogList(SysPracticeLog sysPracticeLog);

}
