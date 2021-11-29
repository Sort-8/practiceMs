package com.ruoyi.arrangement.mapper;

import java.util.List;
import java.util.Map;

import com.ruoyi.arrangement.domain.SysPracticeArrangement;
import com.ruoyi.common.core.domain.entity.SysUser;

/**
 * 实习安排Mapper接口
 *
 * @author YuYang
 * @date 2021-09-23
 */
public interface SysPracticeArrangementMapper
{
    /**
     * 查询实习安排
     *
     * @param arrangementId 实习安排ID
     * @return 实习安排
     */
    public SysPracticeArrangement selectSysPracticeArrangementById(Long arrangementId);

    /**
     * 查询实习安排
     *
     * @return 实习安排
     */
    public List<Map> getLocationStudentNum();

    /**
     * 查询所有指导老师
     *
     * @param teacher 指导老师
     * @return 指导老师
     */
    public SysUser getAllTeacher(SysUser teacher);

    /**
     * 查询实习安排列表
     *
     * @param sysPracticeArrangement 实习安排
     * @return 实习安排集合
     */
    public List<SysPracticeArrangement> selectSysPracticeArrangementList(SysPracticeArrangement sysPracticeArrangement);


    /**
     * 查询老师指导的学生信息
     *
     * @param
     * @return
     */
    public List<SysPracticeArrangement> selectStudentInfo(SysPracticeArrangement sysPracticeArrangement);

    /**
     * 查询老师指导的学生信息
     *
     * @param
     * @return
     */
    public List<SysUser> selectGuideStudent(Long teacherId);

    /**
     * 新增实习安排
     *
     * @param sysPracticeArrangement 实习安排
     * @return 结果
     */
    public int insertSysPracticeArrangement(SysPracticeArrangement sysPracticeArrangement);

    /**
     * 批量新增实习安排
     *
     * @param pas 实习安排
     * @return 结果
     */
    public int insertBatchSysPracticeArrangement(List<SysPracticeArrangement> pas);
    /**
     * 修改实习安排
     *
     * @param sysPracticeArrangement 实习安排
     * @return 结果
     */
    public int updateSysPracticeArrangement(SysPracticeArrangement sysPracticeArrangement);

    /**
     * 删除实习安排
     *
     * @param arrangementId 实习安排ID
     * @return 结果
     */
    public int deleteSysPracticeArrangementById(Long arrangementId);

    /**
     * 删除实习安排
     *
     * @param infoId 实习安排ID
     * @return 结果
     */
    public int deleteSysPracticeArrangementByInfoId(Long infoId);

    /**
     * 批量删除实习安排
     *
     * @param arrangementIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysPracticeArrangementByIds(Long[] arrangementIds);

    List<SysPracticeArrangement> selectStudentInfo(SysPracticeArrangement sysPracticeArrangement, Long teacherId);
}
