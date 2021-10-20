package com.ruoyi.decentralize.service.impl;

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
        return sysDecentralizedPracticeMapper.insertSysDecentralizedPractice(sysDecentralizedPractice);
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
}
