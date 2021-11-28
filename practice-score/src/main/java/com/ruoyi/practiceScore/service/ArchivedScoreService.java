package com.ruoyi.practiceScore.service;

import com.ruoyi.practiceScore.domain.SysPracticeScore;

import java.util.List;

public interface ArchivedScoreService {

    /**
     * 查询实习成绩列表
     *
     * @param sysPracticeScore 实习成绩
     * @return 实习成绩集合
     */
    public List<SysPracticeScore> selectSysPracticeScoreList(SysPracticeScore sysPracticeScore);

}
