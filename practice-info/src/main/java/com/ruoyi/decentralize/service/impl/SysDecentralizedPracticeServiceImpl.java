package com.ruoyi.decentralize.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.decentralize.mapper.SysDecentralizedPracticeMapper;
import com.ruoyi.decentralize.domain.SysDecentralizedPractice;
import com.ruoyi.decentralize.service.ISysDecentralizedPracticeService;

/**
 * 分散实习申请Service业务层处理
 *
 * @author YuYang
 * @date 2021-10-20
 */
@Service
public class SysDecentralizedPracticeServiceImpl implements ISysDecentralizedPracticeService
{
    @Autowired
    private SysDecentralizedPracticeMapper sysDecentralizedPracticeMapper;

    /**
     * 查询分散实习申请
     *
     * @param applyId 分散实习申请ID
     * @return 分散实习申请
     */
    @Override
    public SysDecentralizedPractice selectSysDecentralizedPracticeById(Long applyId)
    {
        return sysDecentralizedPracticeMapper.selectSysDecentralizedPracticeById(applyId);
    }

    /**
     * 查询分散实习学生状况
     *
     * @param username 学生学号
     * @return 分散实习申请
     */
    @Override
    public SysDecentralizedPractice getPracticeStudentInfo(String username)
    {
        return sysDecentralizedPracticeMapper.getPracticeStudentInfo(username);
    }

    @Override
    public int getPracticeByStatus(String status) {
        return sysDecentralizedPracticeMapper.getPracticeByStatus(status);
    }

    /**
     * 查询分散实习申请列表
     *
     * @param sysDecentralizedPractice 分散实习申请
     * @return 分散实习申请
     */
    @Override
    public List<SysDecentralizedPractice> selectSysDecentralizedPracticeList(SysDecentralizedPractice sysDecentralizedPractice)
    {
        return sysDecentralizedPracticeMapper.selectSysDecentralizedPracticeList(sysDecentralizedPractice);
    }

    /**
     * 新增分散实习申请
     *
     * @param sysDecentralizedPractice 分散实习申请
     * @return 结果
     */
    @Override
    public int insertSysDecentralizedPractice(SysDecentralizedPractice sysDecentralizedPractice)
    {
        if("reset".equals(sysDecentralizedPractice.getFlag())){
            if(deleteSysDecentralizedPracticeByUserId(sysDecentralizedPractice.getStuId()) > 0){
                return sysDecentralizedPracticeMapper.insertSysDecentralizedPractice(sysDecentralizedPractice);
            }
        }else{
            return sysDecentralizedPracticeMapper.insertSysDecentralizedPractice(sysDecentralizedPractice);
        }
        return 0;
    }

    /**
     * 修改分散实习申请
     *
     * @param sysDecentralizedPractice 分散实习申请
     * @return 结果
     */
    @Override
    public int updateSysDecentralizedPractice(SysDecentralizedPractice sysDecentralizedPractice)
    {
        return sysDecentralizedPracticeMapper.updateSysDecentralizedPractice(sysDecentralizedPractice);
    }

    @Override
    public int updateSysDecentralizedPractices(SysDecentralizedPractice sysDecentralizedPractice) {
        if(sysDecentralizedPractice.getApplyIds() != null){
            for(String id : sysDecentralizedPractice.getApplyIds()){
                SysDecentralizedPractice practice = sysDecentralizedPractice;
                practice.setApplyId(Long.parseLong(id));
                if(updateSysDecentralizedPractice(practice) == 0){
                    return 0;
                }
            }
        }
        return 1;
    }

    @Override
    public List<SysDecentralizedPractice> getDecentralizeInfo(Long locationId) {

        return sysDecentralizedPracticeMapper.getDecentralizeInfo(locationId);
    }

    @Override
    public List<SysDecentralizedPractice> getDecentralizeByLocation(SysDecentralizedPractice sysDecentralizedPractice) {
        List<SysDecentralizedPractice> result = new ArrayList<>();
        List<SysDecentralizedPractice> decentralizedPractices = sysDecentralizedPracticeMapper.selectSysDecentralizedPracticeList(sysDecentralizedPractice);
        List<SysDecentralizedPractice> locations = sysDecentralizedPracticeMapper.getDecentralizeByLocation(sysDecentralizedPractice);
        for(SysDecentralizedPractice location : locations){
            int awaitingApprovalNum = 0;
            int total = 0;
            for(SysDecentralizedPractice practice : decentralizedPractices){
                if(practice.getLocationId().equals(location.getLocationId())){
                    total++;
                    if(!"1".equals(practice.getStatus())){
                        awaitingApprovalNum++;
                    }
                }
            }
            location.setAwaitingApprovalNum(awaitingApprovalNum);
            location.setTotalNum(total);
            result.add(location);
        }
        return result;
    }


    /**
     * 批量删除分散实习申请
     *
     * @param applyIds 需要删除的分散实习申请ID
     * @return 结果
     */
    @Override
    public int deleteSysDecentralizedPracticeByIds(Long[] applyIds)
    {
        return sysDecentralizedPracticeMapper.deleteSysDecentralizedPracticeByIds(applyIds);
    }

    /**
     * 删除分散实习申请信息
     *
     * @param applyId 分散实习申请ID
     * @return 结果
     */
    @Override
    public int deleteSysDecentralizedPracticeById(Long applyId)
    {
        return sysDecentralizedPracticeMapper.deleteSysDecentralizedPracticeById(applyId);
    }

    @Override
    public int deleteSysDecentralizedPracticeByUserId(Long userId) {
        return sysDecentralizedPracticeMapper.deleteSysDecentralizedPracticeByUserId(userId);
    }
}
