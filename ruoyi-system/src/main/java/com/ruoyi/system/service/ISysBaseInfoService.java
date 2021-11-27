package com.ruoyi.system.service;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.system.domain.SysBaseInfo;

import java.util.List;


/**
 * 基地信息管理Service接口
 *
 * @author xieweiming
 * @date 2021-10-01
 */
public interface ISysBaseInfoService
{

    /**
     * 获取所有基地信息的经纬度
     *
     * @return 所有基地信息的经纬度
     */
    public List<SysBaseInfo> selectBaseTudeAndID();

    /**
     * 查询基地信息管理
     *
     * @param baseId 基地信息管理ID
     * @return 基地信息管理
     */
    public SysBaseInfo selectSysBaseInfoById(Long baseId);

    /**
     * 查询基地信息管理列表
     *
     * @param sysBaseInfo 基地信息管理
     * @return 基地信息管理集合
     */
    public List<SysBaseInfo> selectSysBaseInfoList(SysBaseInfo sysBaseInfo);

    /**
     * 新增基地信息管理
     *
     * @param sysBaseInfo 基地信息管理
     * @return 结果
     */
    public int insertSysBaseInfo(SysBaseInfo sysBaseInfo);

    /**
     * 修改基地信息管理
     *
     * @param sysBaseInfo 基地信息管理
     * @return 结果
     */
    public int updateSysBaseInfo(SysBaseInfo sysBaseInfo);

    /**
     * 修改基地信息状态
     *
     * @param sysBaseInfo 基地信息管理
     * @return 结果
     */
    //public int updateBaseInfoStatus(SysBaseInfo sysBaseInfo);

    /**
     * 批量删除基地信息管理
     *
     * @param baseIds 需要删除的基地信息管理ID
     * @return 结果
     */
    public int deleteSysBaseInfoByIds(Long[] baseIds);

    /**
     * 删除基地信息管理信息
     *
     * @param baseId 基地信息管理ID
     * @return 结果
     */
    public int deleteSysBaseInfoById(Long baseId);
}
