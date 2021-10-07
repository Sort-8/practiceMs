package com.ruoyi.practiceInfo.service.impl;

import java.util.List;

import com.ruoyi.practiceInfo.domain.SysPracticeInfo;
import com.ruoyi.practiceInfo.mapper.SysPracticeInfoMapper;
import com.ruoyi.practiceInfo.service.ISysPracticeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 实习信息Service业务层处理
 * 
 * @author YuYang
 * @date 2021-09-23
 */
@Service
public class SysPracticeInfoServiceImpl implements ISysPracticeInfoService
{
    @Autowired
    private SysPracticeInfoMapper sysPracticeInfoMapper;

    /**
     * 查询实习信息
     * 
     * @param infoId 实习信息ID
     * @return 实习信息
     */
    @Override
    public SysPracticeInfo selectSysPracticeInfoById(Long infoId)
    {
        return sysPracticeInfoMapper.selectSysPracticeInfoById(infoId);
    }

    /**
     * 查询实习信息列表
     * 
     * @param sysPracticeInfo 实习信息
     * @return 实习信息
     */
    @Override
    public List<SysPracticeInfo> selectSysPracticeInfoList(SysPracticeInfo sysPracticeInfo)
    {
        return sysPracticeInfoMapper.selectSysPracticeInfoList(sysPracticeInfo);
    }

    /**
     * 新增实习信息
     * 
     * @param sysPracticeInfo 实习信息
     * @return 结果
     */
    @Override
    public int insertSysPracticeInfo(SysPracticeInfo sysPracticeInfo)
    {
        return sysPracticeInfoMapper.insertSysPracticeInfo(sysPracticeInfo);
    }

    /**
     * 修改实习信息
     * 
     * @param sysPracticeInfo 实习信息
     * @return 结果
     */
    @Override
    public int updateSysPracticeInfo(SysPracticeInfo sysPracticeInfo)
    {
        return sysPracticeInfoMapper.updateSysPracticeInfo(sysPracticeInfo);
    }

    /**
     * 批量删除实习信息
     * 
     * @param infoIds 需要删除的实习信息ID
     * @return 结果
     */
    @Override
    public int deleteSysPracticeInfoByIds(Long[] infoIds)
    {
        return sysPracticeInfoMapper.deleteSysPracticeInfoByIds(infoIds);
    }

    /**
     * 删除实习信息信息
     * 
     * @param infoId 实习信息ID
     * @return 结果
     */
    @Override
    public int deleteSysPracticeInfoById(Long infoId)
    {
        return sysPracticeInfoMapper.deleteSysPracticeInfoById(infoId);
    }
}
