package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysBaseMapper;
import com.ruoyi.system.domain.SysBase;
import com.ruoyi.system.service.ISysBaseService;

/**
 * 实习基地信息Service业务层处理
 * 
 * @author tomorrow
 * @date 2021-08-16
 */
@Service
public class SysBaseServiceImpl implements ISysBaseService 
{
    @Autowired
    private SysBaseMapper sysBaseMapper;

    /**
     * 查询实习基地信息
     * 
     * @param baseId 实习基地信息ID
     * @return 实习基地信息
     */
    @Override
    public SysBase selectSysBaseById(Long baseId)
    {
        return sysBaseMapper.selectSysBaseById(baseId);
    }

    /**
     * 查询实习基地信息列表
     * 
     * @param sysBase 实习基地信息
     * @return 实习基地信息
     */
    @Override
    public List<SysBase> selectSysBaseList(SysBase sysBase)
    {
        return sysBaseMapper.selectSysBaseList(sysBase);
    }

    /**
     * 新增实习基地信息
     * 
     * @param sysBase 实习基地信息
     * @return 结果
     */
    @Override
    public int insertSysBase(SysBase sysBase)
    {
        return sysBaseMapper.insertSysBase(sysBase);
    }

    /**
     * 修改实习基地信息
     * 
     * @param sysBase 实习基地信息
     * @return 结果
     */
    @Override
    public int updateSysBase(SysBase sysBase)
    {
        return sysBaseMapper.updateSysBase(sysBase);
    }

    /**
     * 批量删除实习基地信息
     * 
     * @param baseIds 需要删除的实习基地信息ID
     * @return 结果
     */
    @Override
    public int deleteSysBaseByIds(Long[] baseIds)
    {
        return sysBaseMapper.deleteSysBaseByIds(baseIds);
    }

    /**
     * 删除实习基地信息信息
     * 
     * @param baseId 实习基地信息ID
     * @return 结果
     */
    @Override
    public int deleteSysBaseById(Long baseId)
    {
        return sysBaseMapper.deleteSysBaseById(baseId);
    }
}
