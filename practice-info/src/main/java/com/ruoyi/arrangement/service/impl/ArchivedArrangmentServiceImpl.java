package com.ruoyi.arrangement.service.impl;

import com.ruoyi.arrangement.domain.SysPracticeArrangement;
import com.ruoyi.arrangement.mapper.ArchivedArrangementMapper;
import com.ruoyi.arrangement.service.ArchivedArrangmentService;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.system.mapper.ArchivedUserMapper;
import com.ruoyi.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@DataSource(value = DataSourceType.SLAVE)
public class ArchivedArrangmentServiceImpl implements ArchivedArrangmentService {
    @Autowired
    private ArchivedArrangementMapper archivedArrangementMapper;

    @Override
    public List<SysPracticeArrangement> selectSysPracticeArrangementList(SysPracticeArrangement sysPracticeArrangement) {
        return archivedArrangementMapper.selectSysPracticeArrangementList(sysPracticeArrangement);
    }
}
