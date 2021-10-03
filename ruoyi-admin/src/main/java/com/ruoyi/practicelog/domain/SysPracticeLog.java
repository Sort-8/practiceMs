package com.ruoyi.practicelog.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excels;
import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.core.domain.entity.SysUser;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 实习日志对象 sys_practice_log
 *
 * @author 涛哥
 * @date 2021-09-26
 */
public class SysPracticeLog extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 日志ID */
    private Long logId;

    /** 用户姓名 */
    @Excel(name = "用户姓名")
    private String userName;

    /** 地点信息 */
    @Excel(name = "地点信息")
    private Long locationid;

    /** 时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date time;

    /** 日志内容 */
    @Excel(name = "日志内容")
    private String logContents;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    /** 用户对象 */
    @Excels({
            @Excel(name = "用户账号", targetAttr = "userName", type = Excel.Type.EXPORT),
//            @Excel(name = "部门负责人", targetAttr = "leader", type = Excel.Type.EXPORT)
    })
    private SysUser user;

    public Long getLocationid() {
        return locationid;
    }

    public void setLocationid(Long locationid) {
        this.locationid = locationid;
    }

    public SysUser getUser() {
        return user;
    }

    public void setUser(SysUser user) {
        this.user = user;
    }

    public void setLogId(Long logId)
    {
        this.logId = logId;
    }

    public Long getLogId()
    {
        return logId;
    }
    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getUserName()
    {
        return userName;
    }
    public void setLocationId(Long locationid)
    {
        this.locationid = locationid;
    }

    public Long getLocationId()
    {
        return locationid;
    }
    public void setTime(Date time)
    {
        this.time = time;
    }

    public Date getTime()
    {
        return time;
    }
    public void setLogContents(String logContents)
    {
        this.logContents = logContents;
    }

    public String getLogContents()
    {
        return logContents;
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
            .append("logId", getLogId())
            .append("userName", getUserName())
            .append("locationName", getLocationId())
            .append("time", getTime())
            .append("logContents", getLogContents())
            .append("delFlag", getDelFlag())
            .toString();
    }
}
