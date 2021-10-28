package com.ruoyi.practicelog.mapper;

import java.util.List;
import com.ruoyi.practicelog.domain.SysPracticeLog;

/**
 * 实习日志Mapper接口
 *
 * @author 涛哥
 * @date 2021-09-26
 */
public interface SysPracticeLogMapper
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
     * 删除实习日志
     *
     * @param logId 实习日志ID
     * @return 结果
     */
    public int deleteSysPracticeLogById(Long logId);

    /**
     * 批量删除实习日志
     *
     * @param logIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysPracticeLogByIds(Long[] logIds);

    /**
     * 是否重复添加日志信息
     *
     * @param userName
     * @return
     */
    public SysPracticeLog isRepeatPracticalLogTimeByUName(String userName);

    /**
     *获得当天填写日志人数
     * @return
     */
    public int selectTodayPracLogList();



}
