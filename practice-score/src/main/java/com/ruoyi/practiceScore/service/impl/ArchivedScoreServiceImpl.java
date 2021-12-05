package com.ruoyi.practiceScore.service.impl;

import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.practiceScore.domain.SysPracticeScore;
import com.ruoyi.practiceScore.mapper.ArchivedScoreMapper;
import com.ruoyi.practiceScore.service.ArchivedScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@DataSource(value = DataSourceType.SLAVE)
public class ArchivedScoreServiceImpl implements ArchivedScoreService {
    @Autowired
    private ArchivedScoreMapper archivedScoreMapper;

    @Override
    /**
     * 查询实习成绩列表
     *
     * @param sysPracticeScore 实习成绩
     * @return 实习成绩
     */
    @DataScope(deptAlias = "d", userAlias = "su")
    public List<SysPracticeScore> selectSysPracticeScoreList(SysPracticeScore sysPracticeScore)
    {
        return archivedScoreMapper.selectSysPracticeScoreList(sysPracticeScore);
    }
}
