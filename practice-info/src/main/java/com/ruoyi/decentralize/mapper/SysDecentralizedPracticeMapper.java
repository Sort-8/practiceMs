package com.ruoyi.decentralize.mapper;

import java.util.List;
import com.ruoyi.decentralize.domain.SysDecentralizedPractice;

/**
 * 分散实习申请Mapper接口
 * 
 * @author YuYang
 * @date 2021-10-20
 */
public interface SysDecentralizedPracticeMapper 
{
    /**
     * 查询分散实习申请
     * 
     * @param applyId 分散实习申请ID
     * @return 分散实习申请
     */
    public SysDecentralizedPractice selectSysDecentralizedPracticeById(Long applyId);

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
     * 删除分散实习申请
     * 
     * @param applyId 分散实习申请ID
     * @return 结果
     */
    public int deleteSysDecentralizedPracticeById(Long applyId);

    /**
     * 批量删除分散实习申请
     * 
     * @param applyIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysDecentralizedPracticeByIds(Long[] applyIds);
}
