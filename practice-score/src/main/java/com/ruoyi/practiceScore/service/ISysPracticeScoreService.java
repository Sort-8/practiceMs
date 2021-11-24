package com.ruoyi.practiceScore.service;

import java.util.List;

import com.ruoyi.practiceScore.domain.Setting;
import com.ruoyi.practiceScore.domain.SysPracticeScore;

/**
 * 实习成绩Service接口
 * 
 * @author ruoyi
 * @date 2021-10-03
 */
public interface ISysPracticeScoreService
{
    /**
     * 查询设定信息
     *
     * @return 实习成绩
     */
    public List<Setting> getList();

    /**
     * 查询设定信息
     * @param setting 修改后的设定集
     * @return 实习成绩
     */
    public int editSetting(Setting setting);

    /**
     * 查询设定信息
     * @param scoreIds 需要计算的成绩组
     * @return 实习成绩
     */
    public int calculate(Long[] scoreIds);
    /**
     * 查询实习成绩
     * 
     * @param scoreId 实习成绩ID
     * @return 实习成绩
     */
    public SysPracticeScore selectSysPracticeScoreById(SysPracticeScore sysPracticeScore);

    /**
     * 查询实习成绩列表
     *
     * @param sysPracticeScore 实习成绩
     * @return 实习成绩集合
     */
    public List<SysPracticeScore> selectSysPracticeScoreList(SysPracticeScore sysPracticeScore);

    /**
     * 查询实习成绩列表
     *
     * @param sysPracticeScore 实习成绩
     * @return 实习成绩自定义集合
     */
    public List<SysPracticeScore> selectSysPracticeScoreList2(SysPracticeScore sysPracticeScore);

    /**
     * 新增实习成绩
     * 
     * @param sysPracticeScore 实习成绩
     * @return 结果
     */
    public int insertSysPracticeScore(SysPracticeScore sysPracticeScore);

    /**
     * 修改实习成绩
     * 
     * @param sysPracticeScore 实习成绩
     * @return 结果
     */
    public int updateSysPracticeScore(SysPracticeScore sysPracticeScore);

    /**
     * 修改实习成绩的状态
     *
     * @param sysPracticeScore 实习成绩
     * @return 结果
     */
    public int updateScoreStatus(SysPracticeScore sysPracticeScore);


    /**
     * 修改实习鉴定的路径
     *
     * @param sysPracticeScore 实习成绩
     * @return 结果
     */
    public int updateScoreAppraisal(SysPracticeScore sysPracticeScore);

    /**
     * 修改实习鉴定的路径
     *
     * @param sysPracticeScore 实习成绩
     * @return 结果
     */
    public int updateScoreSummary(SysPracticeScore sysPracticeScore);

    /**
     * 批量删除实习成绩
     * 
     * @param scoreIds 需要删除的实习成绩ID
     * @return 结果
     */
    public int deleteSysPracticeScoreByIds(Long[] scoreIds);

    /**
     * 删除实习成绩信息
     * 
     * @param scoreId 实习成绩ID
     * @return 结果
     */
    public int deleteSysPracticeScoreById(Long scoreId);
}
