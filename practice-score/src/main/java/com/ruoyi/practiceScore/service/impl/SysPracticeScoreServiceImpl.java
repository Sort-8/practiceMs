package com.ruoyi.practiceScore.service.impl;

import java.math.BigDecimal;
import java.util.List;

import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.practiceScore.domain.Calculate;
import com.ruoyi.practiceScore.domain.Setting;
import com.ruoyi.practiceScore.domain.SysPracticeScore;
import com.ruoyi.practiceScore.mapper.SettingMapper;
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

    @Autowired
    private SettingMapper settingMapper;

    @Override
    public List<Setting> getList() {
        return settingMapper.selectSettingList();
    }

    @Override
    public int editSetting(Setting setting) {
        return settingMapper.editSetting(setting);
    }

    @Override
    public int calculate(Long[] scoreIds) {

        int punchDay,logDay;
        List<Setting> list = getList();
        Setting setting =list.get(0);
        for (int i = 0 ;i<scoreIds.length;i++){
            Calculate c1 = sysPracticeScoreMapper.getPunchDayByScoreId(scoreIds[i]);
            Calculate c2 = sysPracticeScoreMapper.getLogDayByScoreId(scoreIds[i]);
            punchDay = c1.getPunchDay();
            logDay = c2.getLogDay();
            SysPracticeScore sysPracticeScore = new SysPracticeScore();
            sysPracticeScore.setScoreId(scoreIds[i]);
            sysPracticeScore = selectSysPracticeScoreById(sysPracticeScore);
            sysPracticeScore.setSysScore(getsysPracticeScore(punchDay,logDay,setting));
            sysPracticeScore.setFinalScore(getFinalScore(sysPracticeScore,setting));
            updateSysPracticeScore(sysPracticeScore);
        }
        return 1;
    }

    public BigDecimal getFinalScore(SysPracticeScore sysPracticeScore,Setting setting){
        BigDecimal system,teacher,company,a,b,c;
        system = new BigDecimal(Float.toString(setting.getSystemWeight()));
        teacher =new BigDecimal(Float.toString(setting.getTeacherWeight()));
        company =new BigDecimal(Float.toString(setting.getCompanyWeight()));
        if(sysPracticeScore.getSysScore()==null){
            sysPracticeScore.setSysScore(BigDecimal.ZERO);
        }
        if(sysPracticeScore.getTeacherScore()==null){
            sysPracticeScore.setTeacherScore(BigDecimal.ZERO);
        }
        if(sysPracticeScore.getCompanyScore()==null){
            sysPracticeScore.setCompanyScore(BigDecimal.ZERO);
        }
        a = sysPracticeScore.getSysScore().multiply(system);
        b = sysPracticeScore.getTeacherScore().multiply(teacher);
        c = sysPracticeScore.getCompanyScore().multiply(company);
        return a.add(b).add(c);
    }

    public BigDecimal getsysPracticeScore(int punchDay,int logDay,Setting setting){
        String a,b;
        a = Float.toString(punchDay*2*setting.getPunchWeight());
        b = Float.toString(logDay*2*setting.getLogWeight());
        BigDecimal s1,s2;
        s1 = new BigDecimal(a);
        s2 = new BigDecimal(b);
        return s1.add(s2);
    }
    /**
     * 查询实习成绩
     *
     * @param scoreId 实习成绩ID
     * @return 实习成绩
     */
    @Override
    public SysPracticeScore selectSysPracticeScoreById(SysPracticeScore sysPracticeScore)
    {
        return sysPracticeScoreMapper.selectSysPracticeScoreById(sysPracticeScore);
    }

    /**
     * 查询实习成绩列表
     *
     * @param sysPracticeScore 实习成绩
     * @return 实习成绩
     */
    @Override
    @DataScope(userAlias = "su",deptAlias = "su")
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
     * 修改实习成绩状态
     *
     * @param sysPracticeScore 实习成绩
     * @return 结果
     */
    @Override
    public int updateScoreStatus(SysPracticeScore sysPracticeScore) {
        return sysPracticeScoreMapper.updateScoreSatus(sysPracticeScore);
    }

    /**
     * 更改实习鉴定的路径
     * */
    @Override
    public int updateScoreAppraisal(SysPracticeScore sysPracticeScore) {
        return sysPracticeScoreMapper.updateScoreAppraisal(sysPracticeScore);
    }


    /**
     * 更改实习总结的路径
     * */
    @Override
    public int updateScoreSummary(SysPracticeScore sysPracticeScore) {
        return sysPracticeScoreMapper.updateScoreSummary(sysPracticeScore);
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
