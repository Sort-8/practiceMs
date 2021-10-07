package com.ruoyi.system.service.impl;

import java.util.List;


import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.system.mapper.SysBaseInfoMapper;
import com.ruoyi.system.service.ISysBaseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.domain.SysBaseInfo;


/**
 * 基地信息管理Service业务层处理
 * 
 * @author xieweiming
 * @date 2021-10-01
 */
@Service
public class SysBaseInfoServiceImpl implements ISysBaseInfoService
{
    @Autowired
    private SysBaseInfoMapper sysBaseInfoMapper;

    /**
     * 获取所有基地信息的经纬度
     *
     * @return 所有基地信息的经纬度
     */
    @Override
    public List<SysBaseInfo> selectBaseTude()
    {
        return sysBaseInfoMapper.selectBaseTude();
    }

    /**
     * 查询基地信息管理
     * 
     * @param baseId 基地信息管理ID
     * @return 基地信息管理
     */
    @Override
    public SysBaseInfo selectSysBaseInfoById(Long baseId)
    {
        return sysBaseInfoMapper.selectSysBaseInfoById(baseId);
    }

    /**
     * 查询基地信息管理列表
     * 
     * @param sysBaseInfo 基地信息管理
     * @return 基地信息管理
     */
    @Override
    public List<SysBaseInfo> selectSysBaseInfoList(SysBaseInfo sysBaseInfo)
    {
        return sysBaseInfoMapper.selectSysBaseInfoList(sysBaseInfo);
    }

    /**
     * 新增基地信息管理
     * 
     * @param sysBaseInfo 基地信息管理
     * @return 结果
     */
    @Override
    public int insertSysBaseInfo(SysBaseInfo sysBaseInfo)
    {
        return sysBaseInfoMapper.insertSysBaseInfo(sysBaseInfo);
    }

    /**
     * 修改基地信息管理
     * 
     * @param sysBaseInfo 基地信息管理
     * @return 结果
     */
    @Override
    public int updateSysBaseInfo(SysBaseInfo sysBaseInfo)
    {
        return sysBaseInfoMapper.updateSysBaseInfo(sysBaseInfo);
    }

    /**
     * 修改基地信息状态
     *
     * @param sysBaseInfo 基地信息
     * @return 结果
     */
    @Override
    public int updateBaseInfoStatus(SysBaseInfo sysBaseInfo)
    {
        return sysBaseInfoMapper.updateSysBaseInfo(sysBaseInfo);
    }

    /**
     * 批量删除基地信息管理
     * 
     * @param baseIds 需要删除的基地信息管理ID
     * @return 结果
     */
    @Override
    public int deleteSysBaseInfoByIds(Long[] baseIds)
    {
        return sysBaseInfoMapper.deleteSysBaseInfoByIds(baseIds);
    }

    /**
     * 删除基地信息管理信息
     * 
     * @param baseId 基地信息管理ID
     * @return 结果
     */
    @Override
    public int deleteSysBaseInfoById(Long baseId)
    {
        return sysBaseInfoMapper.deleteSysBaseInfoById(baseId);
    }
}
