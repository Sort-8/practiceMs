package com.ruoyi.practiceScore.service.impl;

import java.util.List;

import com.ruoyi.practiceScore.domain.SysPracticeScore;
import com.ruoyi.practiceScore.mapper.SysPracticeScoreMapper;
import com.ruoyi.practiceScore.service.ISysPracticeScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 实习成绩Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-10-03
 */
@Service
public class SysPracticeScoreServiceImpl implements ISysPracticeScoreService
{
    @Autowired
    private SysPracticeScoreMapper sysPracticeScoreMapper;

    /**
     * 查询实习成绩
     * 
     * @param scoreId 实习成绩ID
     * @return 实习成绩
     */
    @Override
    public SysPracticeScore selectSysPracticeScoreById(Long scoreId)
    {
        return sysPracticeScoreMapper.selectSysPracticeScoreById(scoreId);
    }

    /**
     * 查询实习成绩列表
     * 
     * @param sysPracticeScore 实习成绩
     * @return 实习成绩
     */
    @Override
    public List<SysPracticeScore> selectSysPracticeScoreList(SysPracticeScore sysPracticeScore)
    {
        return sysPracticeScoreMapper.selectSysPracticeScoreList(sysPracticeScore);
    }

    /**
     * 查询实习成绩列表2
     *
     * @param sysPracticeScore 实习成绩
     * @return 实习成绩
     */
    @Override
    public List<SysPracticeScore> selectSysPracticeScoreList2(SysPracticeScore sysPracticeScore) {
        return sysPracticeScoreMapper.selectSysPracticeScoreList(sysPracticeScore);
    }

    /**
     * 新增实习成绩
     * 
     * @param sysPracticeScore 实习成绩
     * @return 结果
     */
    @Override
    public int insertSysPracticeScore(SysPracticeScore sysPracticeScore)
    {
        return sysPracticeScoreMapper.insertSysPracticeScore(sysPracticeScore);
    }

    /**
     * 修改实习成绩
     * 
     * @param sysPracticeScore 实习成绩
     * @return 结果
     */
    @Override
    public int updateSysPracticeScore(SysPracticeScore sysPracticeScore)
    {
        return sysPracticeScoreMapper.updateSysPracticeScore(sysPracticeScore);
    }

    /**
     * 批量删除实习成绩
     * 
     * @param scoreIds 需要删除的实习成绩ID
     * @return 结果
     */
    @Override
    public int deleteSysPracticeScoreByIds(Long[] scoreIds)
    {
        return sysPracticeScoreMapper.deleteSysPracticeScoreByIds(scoreIds);
    }

    /**
     * 删除实习成绩信息
     * 
     * @param scoreId 实习成绩ID
     * @return 结果
     */
    @Override
    public int deleteSysPracticeScoreById(Long scoreId)
    {
        return sysPracticeScoreMapper.deleteSysPracticeScoreById(scoreId);
    }
}
