package com.ruoyi.practicelog.service.impl;

import java.util.List;

import com.ruoyi.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.practicelog.mapper.SysPracticeLogMapper;
import com.ruoyi.practicelog.domain.SysPracticeLog;
import com.ruoyi.practicelog.service.ISysPracticeLogService;

/**
 * 实习日志Service业务层处理
 *
 * @author 涛哥
 * @date 2021-09-26
 */
@Service
public class SysPracticeLogServiceImpl implements ISysPracticeLogService
{
    @Autowired
    private SysPracticeLogMapper sysPracticeLogMapper;

    /**
     * 查询实习日志
     *
     * @param logId 实习日志ID
     * @return 实习日志
     */
    @Override
    public SysPracticeLog selectSysPracticeLogById(Long logId)
    {
        return sysPracticeLogMapper.selectSysPracticeLogById(logId);
    }

    /**
     * 查询实习日志列表
     *
     * @param sysPracticeLog 实习日志
     * @return 实习日志
     */
    @Override
    public List<SysPracticeLog> selectSysPracticeLogList(SysPracticeLog sysPracticeLog)
    {
        return sysPracticeLogMapper.selectSysPracticeLogList(sysPracticeLog);
    }

    /**
     * 新增实习日志
     *
     * @param sysPracticeLog 实习日志
     * @return 结果
     */
    @Override
    public int insertSysPracticeLog(SysPracticeLog sysPracticeLog)
    {
        sysPracticeLog.setLogId(StringUtils.geneId());
        sysPracticeLog.setLocationId(1L);
        SysPracticeLog isRepeatLog = sysPracticeLogMapper.isRepeatPracticalLogTimeByUName(sysPracticeLog.getUserName());
        if(isRepeatLog!=null){
            return 0;
        }
        return sysPracticeLogMapper.insertSysPracticeLog(sysPracticeLog);
    }

    /**
     * 修改实习日志
     *
     * @param sysPracticeLog 实习日志
     * @return 结果
     */
    @Override
    public int updateSysPracticeLog(SysPracticeLog sysPracticeLog)
    {
        sysPracticeLog.setLocationId(1L);
        return sysPracticeLogMapper.updateSysPracticeLog(sysPracticeLog);
    }

    /**
     * 批量删除实习日志
     *
     * @param logIds 需要删除的实习日志ID
     * @return 结果
     */
    @Override
    public int deleteSysPracticeLogByIds(Long[] logIds)
    {
        return sysPracticeLogMapper.deleteSysPracticeLogByIds(logIds);
    }

    /**
     * 删除实习日志信息
     *
     * @param logId 实习日志ID
     * @return 结果
     */
    @Override
    public int deleteSysPracticeLogById(Long logId)
    {
        return sysPracticeLogMapper.deleteSysPracticeLogById(logId);
    }
}
