package com.ruoyi.arrangement.service.impl;

import com.ruoyi.arrangement.domain.SysPracticeArrangement;
import com.ruoyi.arrangement.mapper.ArchivedArrangementMapper;
import com.ruoyi.arrangement.service.ArchivedArrangmentService;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.core.page.PageDomain;
import com.ruoyi.common.core.page.TableSupport;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.decentralize.domain.SysDecentralizedPractice;
import com.ruoyi.system.mapper.ArchivedUserMapper;
import com.ruoyi.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@DataSource(value = DataSourceType.SLAVE)
public class ArchivedArrangmentServiceImpl implements ArchivedArrangmentService {
    @Autowired
    private ArchivedArrangementMapper archivedArrangementMapper;

    @Override
    public List<SysPracticeArrangement> selectSysPracticeArrangementList(SysPracticeArrangement sysPracticeArrangement) {
        return archivedArrangementMapper.selectSysPracticeArrangementList(sysPracticeArrangement);
    }

    /**
     * 查询集中实习以及分散实习
     *
     * @param sysPracticeArrangement 实习安排
     * @return 实习安排
     */
    @Override
    public Map selectAllPractice(SysPracticeArrangement sysPracticeArrangement)
    {
        return null;
    }
}
