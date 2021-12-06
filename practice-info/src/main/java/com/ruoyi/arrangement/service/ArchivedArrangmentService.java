package com.ruoyi.arrangement.service;

import com.ruoyi.arrangement.domain.SysPracticeArrangement;
import com.ruoyi.decentralize.domain.SysDecentralizedPractice;

import java.util.List;
import java.util.Map;

public interface ArchivedArrangmentService {

    /**
     * 查询实习安排列表
     *
     * @param sysPracticeArrangement 实习安排
     * @return 实习安排集合
     */
    public List<SysPracticeArrangement> selectSysPracticeArrangementList(SysPracticeArrangement sysPracticeArrangement);

    /**
     * 查询实习安排列表
     *
     * @param sysPracticeArrangement 实习安排
     * @return 实习安排集合
     */
    public Map selectAllPractice(SysPracticeArrangement sysPracticeArrangement);

}
