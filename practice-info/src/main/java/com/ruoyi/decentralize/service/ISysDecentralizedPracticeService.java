package com.ruoyi.decentralize.service;

import java.util.List;
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
