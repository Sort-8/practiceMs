package com.ruoyi.punch.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.punch.mapper.SysAttendanceMapper;
import com.ruoyi.punch.domain.SysAttendance;
import com.ruoyi.punch.service.ISysAttendanceService;

/**
 * 打卡签到Service业务层处理
 *
 * @author ruoyi
 * @date 2021-09-29
 */
@Service
public class SysAttendanceServiceImpl implements ISysAttendanceService
{
    @Autowired
    private SysAttendanceMapper sysAttendanceMapper;

    /**
     * 查询打卡签到
     *
     * @param attendanceId 打卡签到ID
     * @return 打卡签到
     */
    @Override
    public SysAttendance selectSysAttendanceById(Long attendanceId)
    {
        return sysAttendanceMapper.selectSysAttendanceById(attendanceId);
    }

    @Override
    public int[] selectNowWeekAttendanceList() {
        List<Map<String,Object>> result = sysAttendanceMapper.selectNowWeekAttendanceList();
        System.out.println(result);
        int[] data = new int[7];
        int i = 0;
        for(Map<String,Object> map : result){
            String r = StringUtils.substring(map.get("IFNULL(data").toString() , 11 , 13).replace("}" , "");
            data[i] = Integer.parseInt(r);
            i++;
        }
        return data;
    }

    /**
     * 查询打卡签到列表
     *
     * @param sysAttendance 打卡签到
     * @return 打卡签到
     */
    @Override
    @DataScope(deptAlias = "u", userAlias = "u")
    public List<SysAttendance> selectSysAttendanceList(SysAttendance sysAttendance)
    {
        return sysAttendanceMapper.selectSysAttendanceList(sysAttendance);
    }

    /**
     * 查询打卡签到列表
     *
     * @return 打卡签到
     */
    @Override
    public Map<String,Object> selectTodayPunchList()
    {
        Map<String,Object> map = new HashMap<>();
        map.put("punchCount",sysAttendanceMapper.selectTodayPunchList());
        return map;
    }

    /**
     * 新增打卡签到
     *
     * @param sysAttendance 打卡签到
     * @return 结果
     */
    @Override
    public int insertSysAttendance(SysAttendance sysAttendance)
    {
        SysAttendance repeatPunchTimeByUName = sysAttendanceMapper.isRepeatPunchTimeByUName(sysAttendance.getUserName());
        if(repeatPunchTimeByUName!=null){
            return 0;
        }
        sysAttendance.setAttendanceId(StringUtils.geneId());
        return sysAttendanceMapper.insertSysAttendance(sysAttendance);
    }

    /**
     * 修改打卡签到
     *
     * @param sysAttendance 打卡签到
     * @return 结果
     */
    @Override
    public int updateSysAttendance(SysAttendance sysAttendance)
    {
        return sysAttendanceMapper.updateSysAttendance(sysAttendance);
    }

    /**
     * 批量删除打卡签到
     *
     * @param attendanceIds 需要删除的打卡签到ID
     * @return 结果
     */
    @Override
    public int deleteSysAttendanceByIds(Long[] attendanceIds)
    {
        return sysAttendanceMapper.deleteSysAttendanceByIds(attendanceIds);
    }

    /**
     * 删除打卡签到信息
     *
     * @param attendanceId 打卡签到ID
     * @return 结果
     */
    @Override
    public int deleteSysAttendanceById(Long attendanceId)
    {
        return sysAttendanceMapper.deleteSysAttendanceById(attendanceId);
    }


    /**
     * 当天打卡状态
     *
     * @param userNname
     * @return
     */
    @Override
    public SysAttendance selectSysAttendanceByUName(String userNname)
    {
        SysAttendance repeatPunchTimeByUName = sysAttendanceMapper.isRepeatPunchTimeByUName(userNname);
        return repeatPunchTimeByUName;
    }
}
