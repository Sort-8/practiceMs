package com.ruoyi.practicelog.service;

import java.util.List;
import com.ruoyi.practicelog.domain.SysPracticeLog;

/**
 * 实习日志Service接口
 * 
 * @author 涛哥
 * @date 2021-09-26
 */
public interface ISysPracticeLogService 
{
    /**
     * 查询实习日志
     * 
     * @param logId 实习日志ID
     * @return 实习日志
     */
    public SysPracticeLog selectSysPracticeLogById(Long logId);

    /**
     * 查询实习日志列表
     * 
     * @param sysPracticeLog 实习日志
     * @return 实习日志集合
     */
    public List<SysPracticeLog> selectSysPracticeLogList(SysPracticeLog sysPracticeLog);

    /**
     * 新增实习日志
     * 
     * @param sysPracticeLog 实习日志
     * @return 结果
     */
    public int insertSysPracticeLog(SysPracticeLog sysPracticeLog);

    /**
     * 修改实习日志
     * 
     * @param sysPracticeLog 实习日志
     * @return 结果
     */
    public int updateSysPracticeLog(SysPracticeLog sysPracticeLog);

    /**
     * 批量删除实习日志
     * 
     * @param logIds 需要删除的实习日志ID
     * @return 结果
     */
    public int deleteSysPracticeLogByIds(Long[] logIds);

    /**
     * 删除实习日志信息
     * 
     * @param logId 实习日志ID
     * @return 结果
     */
    public int deleteSysPracticeLogById(Long logId);
}
