package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysBase;

/**
 * 实习基地信息Mapper接口
 * 
 * @author tomorrow
 * @date 2021-08-16
 */
public interface SysBaseMapper 
{
    /**
     * 查询实习基地信息
     * 
     * @param baseId 实习基地信息ID
     * @return 实习基地信息
     */
    public SysBase selectSysBaseById(Long baseId);

    /**
     * 查询实习基地信息列表
     * 
     * @param sysBase 实习基地信息
     * @return 实习基地信息集合
     */
    public List<SysBase> selectSysBaseList(SysBase sysBase);

    /**
     * 新增实习基地信息
     * 
     * @param sysBase 实习基地信息
     * @return 结果
     */
    public int insertSysBase(SysBase sysBase);

    /**
     * 修改实习基地信息
     * 
     * @param sysBase 实习基地信息
     * @return 结果
     */
    public int updateSysBase(SysBase sysBase);

    /**
     * 删除实习基地信息
     * 
     * @param baseId 实习基地信息ID
     * @return 结果
     */
    public int deleteSysBaseById(Long baseId);

    /**
     * 批量删除实习基地信息
     * 
     * @param baseIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysBaseByIds(Long[] baseIds);
}
