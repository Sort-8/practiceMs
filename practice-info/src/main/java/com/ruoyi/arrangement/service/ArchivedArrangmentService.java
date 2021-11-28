package com.ruoyi.arrangement.service;

import com.ruoyi.arrangement.domain.SysPracticeArrangement;

import java.util.List;

public interface ArchivedArrangmentService {

    /**
     * 查询实习安排列表
     *
     * @param sysPracticeArrangement 实习安排
     * @return 实习安排集合
     */
    public List<SysPracticeArrangement> selectSysPracticeArrangementList(SysPracticeArrangement sysPracticeArrangement);

}
