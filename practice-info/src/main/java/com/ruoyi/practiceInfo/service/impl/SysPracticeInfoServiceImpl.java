package com.ruoyi.practiceInfo.service.impl;

import java.util.*;
import java.util.stream.Collectors;

import com.ruoyi.arrangement.domain.SysPracticeArrangement;
import com.ruoyi.arrangement.mapper.SysPracticeArrangementMapper;
import com.ruoyi.arrangement.service.ISysPracticeArrangementService;
import com.ruoyi.arrangement.service.impl.SysPracticeArrangementServiceImpl;
import com.ruoyi.practiceInfo.domain.SysPracticeInfo;
import com.ruoyi.practiceInfo.mapper.SysPracticeInfoMapper;
import com.ruoyi.practiceInfo.service.ISysPracticeInfoService;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 实习信息Service业务层处理
 *
 * @author YuYang
 * @date 2021-09-23
 */
@Service
public class SysPracticeInfoServiceImpl implements ISysPracticeInfoService
{
    @Autowired
    private SysPracticeInfoMapper sysPracticeInfoMapper;

    @Autowired
    private ISysPracticeArrangementService sysPracticeArrangementService;

    /**
     * 查询实习信息
     *
     * @param infoId 实习信息ID
     * @return 实习信息
     */
    @Override
    public SysPracticeInfo selectSysPracticeInfoById(Long infoId)
    {
        SysPracticeInfo practiceInfo = sysPracticeInfoMapper.selectSysPracticeInfoById(infoId);
        practiceInfo.setStudentsId(selectPracticeStudentId(infoId));
        return practiceInfo;

    }

    @Override
    public Long[] selectPracticeStudentId(Long infoId) {
        return sysPracticeInfoMapper.selectPracticeStudentId(infoId);
    }

    /**
     * 查询实习信息列表
     *
     * @param sysPracticeInfo 实习信息
     * @return 实习信息
     */
    @Override
    public List<SysPracticeInfo> selectSysPracticeInfoList(SysPracticeInfo sysPracticeInfo)
    {
        return sysPracticeInfoMapper.selectSysPracticeInfoList(sysPracticeInfo);
    }

    /**
     * 新增实习信息
     *
     * @param sysPracticeInfo 实习信息
     * @return 结果
     */
    @Override
    public int insertSysPracticeInfo(SysPracticeInfo sysPracticeInfo)
    {
        return sysPracticeInfoMapper.insertSysPracticeInfo(sysPracticeInfo);
    }

    /**
     * 修改实习信息
     *
     * @param sysPracticeInfo 实习信息
     * @return 结果
     */
    @Override
    public int updateSysPracticeInfo(SysPracticeInfo sysPracticeInfo)
    {
        if(sysPracticeInfo.getTeacherId() == null){
            Long[] studentIds = stringToLong(sysPracticeInfo.getStuStrings().split(","));
            Long infoId = sysPracticeInfo.getInfoId();
            List<SysPracticeArrangement> list = new ArrayList<>();
            SysPracticeArrangement arrangement = null;
            for (int i = 0; i < studentIds.length; i++) {
                arrangement = new SysPracticeArrangement();
                arrangement.setStuId(studentIds[i]);
                arrangement.setInfoId(infoId);
                list.add(arrangement);
            }
            sysPracticeArrangementService.deleteSysPracticeArrangementByInfoId(infoId);
            if(sysPracticeInfoMapper.insertBatchSysPracticeArrangement(list) == 0){
                return 0;
            }
        }
        return sysPracticeInfoMapper.updateSysPracticeInfo(sysPracticeInfo);
    }

    public static Long[] stringToLong(String[] args) {
        String[] strAry = args;
        Long[] longAry= new Long[strAry.length];
        for(int i = 0, len = strAry.length; i < len; i++){
            longAry[i] = new Long(strAry[i]);//这里最好用object,当然JDK 1.5以上直接用数字也可以
        }
        return longAry;
    }

    /**
     * 批量删除实习信息
     *
     * @param infoIds 需要删除的实习信息ID
     * @return 结果
     */
    @Override
    public int deleteSysPracticeInfoByIds(Long[] infoIds)
    {
        return sysPracticeInfoMapper.deleteSysPracticeInfoByIds(infoIds);
    }

    /**
     * 删除实习信息信息
     *
     * @param infoId 实习信息ID
     * @return 结果
     */
    @Override
    public int deleteSysPracticeInfoById(Long infoId)
    {
        return sysPracticeInfoMapper.deleteSysPracticeInfoById(infoId);
    }
}
