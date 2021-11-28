package com.ruoyi.system.service;

import com.ruoyi.common.core.domain.entity.SysUser;

import java.util.List;

/**
 * 用户 业务层
 *
 * @author tomorrow
 */
public interface ArchivedUserService
{


    /**
     * 根据条件分页查询用户列表
     *
     * @param user 用户信息
     * @return 用户信息集合信息
     */
    public List<SysUser> selectUserList(SysUser user);


}
