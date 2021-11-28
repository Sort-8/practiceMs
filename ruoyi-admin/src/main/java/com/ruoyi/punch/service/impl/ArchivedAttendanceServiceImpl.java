package com.ruoyi.punch.service.impl;

import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.punch.domain.SysAttendance;
import com.ruoyi.punch.mapper.ArchivedAttendanceMapper;
import com.ruoyi.punch.service.ArchivedAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@DataSource(value = DataSourceType.SLAVE)
public class ArchivedAttendanceServiceImpl implements ArchivedAttendanceService {
    @Autowired
    private ArchivedAttendanceMapper archivedAttendanceMapper;

    @Override
    @DataScope(deptAlias = "u", userAlias = "u")
    public List<SysAttendance> selectSysAttendanceList(SysAttendance sysAttendance)
    {
        return archivedAttendanceMapper.selectSysAttendanceList(sysAttendance);
    }
}
