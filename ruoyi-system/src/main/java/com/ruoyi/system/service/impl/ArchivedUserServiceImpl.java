package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.system.mapper.*;
import com.ruoyi.system.service.ArchivedUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.common.core.domain.entity.SysUser;

/**
 * 用户 业务层处理
 *
 * @author ruoyi
 */
@Service
@DataSource(value = DataSourceType.SLAVE)
public class ArchivedUserServiceImpl implements ArchivedUserService {
    private static final Logger log = LoggerFactory.getLogger(SysUserServiceImpl.class);

    @Autowired
    private ArchivedUserMapper userMapper;


    /**
     * 根据条件分页查询用户列表
     *
     * @param user 用户信息
     * @return 用户信息集合信息
     */
    @Override
    @DataScope(deptAlias = "d", userAlias = "u")
    public List<SysUser> selectUserList(SysUser user) {
        if (user.getRoleId() == null) {
            user.setRoleId(6L);     //默认获取学生角色信息
        }
        return userMapper.selectUserList(user);
    }


}
