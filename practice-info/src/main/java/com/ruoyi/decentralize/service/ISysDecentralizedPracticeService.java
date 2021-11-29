package com.ruoyi.decentralize.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.decentralize.domain.SysDecentralizedPractice;

/**
 * 分散实习申请Service接口
 *
 * @author YuYang
 * @date 2021-10-20
 */
public interface ISysDecentralizedPracticeService
{
    /**
     * 查询分散实习申请
     *
     * @param applyId 分散实习申请ID
     * @return 分散实习申请
     */
    public SysDecentralizedPractice selectSysDecentralizedPracticeById(Long applyId);

    /**
     * 查询分散实习申请
     *
     * @param username 实习学生学号
     * @return 分散实习信息
     */
    public SysDecentralizedPractice getPracticeStudentInfo(String username);

    /**
     * 查询特定状态的人数
     *
     * @param status
     * @return 分散实习信息
     */
    public int getPracticeByStatus(String status);

    /**
     * 查询分散实习申请列表
     *
     * @param sysDecentralizedPractice 分散实习申请
     * @return 分散实习申请集合
     */
    public List<SysDecentralizedPractice> selectSysDecentralizedPracticeList(SysDecentralizedPractice sysDecentralizedPractice);

    /**
     * 新增分散实习申请
     *
     * @param sysDecentralizedPractice 分散实习申请
     * @return 结果
     */
    public int insertSysDecentralizedPractice(SysDecentralizedPractice sysDecentralizedPractice);

    /**
     * 修改分散实习申请
     *
     * @param sysDecentralizedPractice 分散实习申请
     * @return 结果
     */
    public int updateSysDecentralizedPractice(SysDecentralizedPractice sysDecentralizedPractice);

    /**
     * 批量修改分散实习申请
     *
     * @param sysDecentralizedPractice 分散实习申请
     * @return 结果
     */
    public int updateSysDecentralizedPractices(SysDecentralizedPractice sysDecentralizedPractice);

    /**
     * 获取分散实习详情
     *
     * @param locationId 地点编号
     * @return 结果
     */
    public List<SysDecentralizedPractice> getDecentralizeInfo(Long locationId);

    /**
     * 查询不同地点的实习申请
     *
     * @param sysDecentralizedPractice 分散实习申请
     * @return 结果
     */
    public List<SysDecentralizedPractice> getDecentralizeByLocation(SysDecentralizedPractice sysDecentralizedPractice);

    /**
     * 批量删除分散实习申请
     *
     * @param applyIds 需要删除的分散实习申请ID
     * @return 结果
     */
    public int deleteSysDecentralizedPracticeByIds(Long[] applyIds);

    /**
     * 删除分散实习申请信息
     *
     * @param applyId 分散实习申请ID
     * @return 结果
     */
    public int deleteSysDecentralizedPracticeById(Long applyId);

    /**
     * 删除学生分散实习申请信息
     *
     * @param userId 学生ID
     * @return 结果
     */
    public int deleteSysDecentralizedPracticeByUserId(Long userId);

}
