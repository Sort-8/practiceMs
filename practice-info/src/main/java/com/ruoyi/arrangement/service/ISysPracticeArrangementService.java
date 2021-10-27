package com.ruoyi.arrangement.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.arrangement.domain.SysPracticeArrangement;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.domain.model.LoginUser;

/**
 * 实习安排Service接口
 *
 * @author YuYang
 * @date 2021-09-23
 */
public interface ISysPracticeArrangementService
{
    /**
     * 查询实习安排
     *
     * @param arrangementId 实习安排ID
     * @return 实习安排
     */
    public SysPracticeArrangement selectSysPracticeArrangementById(Long arrangementId);

    /**
     * 查询所有老师
     *
     * @return 老师实体
     */
    public SysUser getAllTeacher(SysUser teacher);

    /**
     * 查询学生实习信息
     *
     * @return 学生
     */
    public Map getPracticeInfo(LoginUser pa);

    /**
     * 查询实习安排列表
     *
     * @param sysPracticeArrangement 实习安排
     * @return 实习安排集合
     */
    public List<SysPracticeArrangement> selectSysPracticeArrangementList(SysPracticeArrangement sysPracticeArrangement);

    /**
     * 新增实习安排
     *
     * @param sysPracticeArrangement 实习安排
     * @return 结果
     */
    public int insertSysPracticeArrangement(SysPracticeArrangement sysPracticeArrangement);

    /**
     * 修改实习安排
     *
     * @param sysPracticeArrangement 实习安排
     * @return 结果
     */
    public int updateSysPracticeArrangement(SysPracticeArrangement sysPracticeArrangement);

    /**
     * 批量删除实习安排
     *
     * @param arrangementIds 需要删除的实习安排ID
     * @return 结果
     */
    public int deleteSysPracticeArrangementByIds(Long[] arrangementIds);

    /**
     * 删除实习安排信息
     *
     * @param arrangementId 实习安排ID
     * @return 结果
     */
    public int deleteSysPracticeArrangementById(Long arrangementId);

    /**
     * 删除实习安排信息
     *
     * @param infoId 实习信息ID
     * @return 结果
     */
    public int deleteSysPracticeArrangementByInfoId(Long infoId);
}
