package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.common.core.domain.TreeSelect;
import com.ruoyi.common.core.domain.entity.SysDept;

/**
 * 院系管理 服务层
 *
 * @author ruoyi
 */
public interface ISysDeptService
{
    /**
     * 查询院系管理数据
     *
     * @param dept 院系信息
     * @return 院系信息集合
     */
    public List<SysDept> selectDeptList(SysDept dept);

    /**
     * 构建前端所需要树结构
     *
     * @param depts 院系列表
     * @return 树结构列表
     */
    public List<SysDept> buildDeptTree(List<SysDept> depts);

    /**
     * 构建前端所需要下拉树结构
     *
     * @param depts 院系列表
     * @return 下拉树结构列表
     */
    public List<TreeSelect> buildDeptTreeSelect(List<SysDept> depts);

    /**
     * 根据角色ID查询院系树信息
     *
     * @param roleId 角色ID
     * @return 选中院系列表
     */
    public List<Integer> selectDeptListByRoleId(Long roleId);

    /**
     * 根据院系ID查询信息
     *
     * @param deptId 院系ID
     * @return 院系信息
     */
    public SysDept selectDeptById(Long deptId);

    /**
     * 根据ID查询所有子院系（正常状态）
     *
     * @param deptId 院系ID
     * @return 子院系数
     */
    public int selectNormalChildrenDeptById(Long deptId);

    /**
     * 是否存在院系子节点
     *
     * @param deptId 院系ID
     * @return 结果
     */
    public boolean hasChildByDeptId(Long deptId);

    /**
     * 查询院系是否存在用户
     *
     * @param deptId 院系ID
     * @return 结果 true 存在 false 不存在
     */
    public boolean checkDeptExistUser(Long deptId);

    /**
     * 校验院系名称是否唯一
     *
     * @param dept 院系信息
     * @return 结果
     */
    public String checkDeptNameUnique(SysDept dept);

    /**
     * 新增保存院系信息
     *
     * @param dept 院系信息
     * @return 结果
     */
    public int insertDept(SysDept dept);

    /**
     * 修改保存院系信息
     *
     * @param dept 院系信息
     * @return 结果
     */
    public int updateDept(SysDept dept);

    /**
     * 删除院系管理信息
     *
     * @param deptId 院系ID
     * @return 结果
     */
    public int deleteDeptById(Long deptId);
}
