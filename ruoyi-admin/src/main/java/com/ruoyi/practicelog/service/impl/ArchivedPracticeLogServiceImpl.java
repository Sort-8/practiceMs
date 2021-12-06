package com.ruoyi.practicelog.service.impl;

import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.practicelog.domain.SysPracticeLog;
import com.ruoyi.practicelog.mapper.ArchivedPracticeLogMapper;
import com.ruoyi.practicelog.service.ArchivedPracticeLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@DataSource(value = DataSourceType.SLAVE)
public class ArchivedPracticeLogServiceImpl implements ArchivedPracticeLogService {
    @Autowired
    private ArchivedPracticeLogMapper archivedPracticeLogMapper;

    /**
     * 查询实习日志列表
     *
     * @param sysPracticeLog 实习日志
     * @return 实习日志
     */
    @Override
    @DataScope(deptAlias = "d", userAlias = "u")
    public List<SysPracticeLog> selectSysPracticeLogList(SysPracticeLog sysPracticeLog)
    {
        return archivedPracticeLogMapper.selectSysPracticeLogList(sysPracticeLog);
    }
}
