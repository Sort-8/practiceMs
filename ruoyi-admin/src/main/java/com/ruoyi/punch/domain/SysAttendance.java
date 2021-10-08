package com.ruoyi.punch.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excels;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 打卡签到对象 sys_attendance
 *
 * @author ruoyi
 * @date 2021-09-29
 */

public class SysAttendance extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 考勤ID */
    private Long attendanceId;

    /** 用户账号 */
    @Excel(name = "用户账号")
    private String userName;

    /** 打卡地点 */
    @Excel(name = "打卡地点")
    private String location;

    /** 备注 */
    @Excel(name = "备注")
    private String notes;

    /** 状态（0成功 1失败） */
    @Excel(name = "状态", readConverterExp = "0=成功,1=失败")
    private String status;

    /** 用户对象 */
    @Excels({
            @Excel(name = "用户账号", targetAttr = "userName", type = Excel.Type.EXPORT),
//            @Excel(name = "部门负责人", targetAttr = "leader", type = Excel.Type.EXPORT)
    })
    private SysUser user;

    public SysUser getUser() {
        return user;
    }

    public void setUser(SysUser user) {
        this.user = user;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /** 时间 */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @Excel(name = "时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createTime;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;
    public void setTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public Date getCreateTime()
    {
        return createTime;
    }

    public void setAttendanceId(Long attendanceId)
    {
        this.attendanceId = attendanceId;
    }

    public Long getAttendanceId()
    {
        return attendanceId;
    }
    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getUserName()
    {
        return userName;
    }
    public void setLocation(String location)
    {
        this.location = location;
    }

    public String getLocation()
    {
        return location;
    }
    public void setNotes(String notes)
    {
        this.notes = notes;
    }

    public String getNotes()
    {
        return notes;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }
    public void setDelFlag(String delFlag)
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag()
    {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("attendanceId", getAttendanceId())
            .append("userName", getUserName())
            .append("location", getLocation())
            .append("notes", getNotes())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .toString();
    }
}
