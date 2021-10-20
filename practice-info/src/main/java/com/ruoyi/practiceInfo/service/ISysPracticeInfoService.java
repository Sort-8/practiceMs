package com.ruoyi.practiceInfo.service;

import java.util.ArrayList;
import java.util.List;
import com.ruoyi.practiceInfo.domain.SysPracticeInfo;

/**
 * 实习信息Service接口
 *
 * @author YuYang
 * @date 2021-09-23
 */
public interface ISysPracticeInfoService
{
    /**
     * 查询实习信息
     *
     * @param infoId 实习信息ID
     * @return 实习信息
     */
    public SysPracticeInfo selectSysPracticeInfoById(Long infoId);

    /**
     * 查询该实习的实习学生学号
     *
     * @param infoId 实习信息ID
     * @return 实习信息
     */
    public Long[] selectPracticeStudentId(Long infoId);

    /**
     * 查询实习信息列表
     *
     * @param sysPracticeInfo 实习信息
     * @return 实习信息集合
     */
    public List<SysPracticeInfo> selectSysPracticeInfoList(SysPracticeInfo sysPracticeInfo);

    /**
     * 新增实习信息
     *
     * @param sysPracticeInfo 实习信息
     * @return 结果
     */
    public int insertSysPracticeInfo(SysPracticeInfo sysPracticeInfo);

    /**
     * 修改实习信息
     *
     * @param sysPracticeInfo 实习信息
     * @return 结果
     */
    public int updateSysPracticeInfo(SysPracticeInfo sysPracticeInfo);

    /**
     * 批量删除实习信息
     *
     * @param infoIds 需要删除的实习信息ID
     * @return 结果
     */
    public int deleteSysPracticeInfoByIds(Long[] infoIds);

    /**
     * 删除实习信息信息
     *
     * @param infoId 实习信息ID
     * @return 结果
     */
    public int deleteSysPracticeInfoById(Long infoId);
}
