package com.ruoyi.practiceScore.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 实习成绩对象 sys_practice_score
 * 
 * @author ruoyi
 * @date 2021-10-03
 */
public class SysPracticeScore extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 成绩ID */
    private Long scoreId;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long userId;

    /** 用户ID */
    @Excel(name = "用户昵称")
    private String nickname;

    /** 地点ID */
    @Excel(name = "地点ID")
    private Long locationId;

    /** 开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /** 结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    /** 系统参考成绩 */
    @Excel(name = "系统参考成绩")
    private BigDecimal sysScore;

    /** 实习单位评定成绩 */
    @Excel(name = "实习单位评定成绩")
    private BigDecimal companyScore;

    /** 实习指导老师评定成绩 */
    @Excel(name = "实习指导老师评定成绩")
    private BigDecimal teacherScore;

    /** 最终成绩 */
    @Excel(name = "最终成绩")
    private BigDecimal finalScore;

    /** 习鉴定表(PDF路径) */
    @Excel(name = "习鉴定表(PDF路径)")
    private String appraisal;

    /** 实习总结(PDF路径) */
    @Excel(name = "实习总结(PDF路径)")
    private String summary;

    /** 状态（0有效 1无效） */
    @Excel(name = "状态", readConverterExp = "0=有效,1=无效")
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;


    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setScoreId(Long scoreId)
    {
        this.scoreId = scoreId;
    }

    public Long getScoreId() 
    {
        return scoreId;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setLocationId(Long locationId) 
    {
        this.locationId = locationId;
    }

    public Long getLocationId() 
    {
        return locationId;
    }
    public void setStartTime(Date startTime) 
    {
        this.startTime = startTime;
    }

    public Date getStartTime() 
    {
        return startTime;
    }
    public void setEndTime(Date endTime) 
    {
        this.endTime = endTime;
    }

    public Date getEndTime() 
    {
        return endTime;
    }
    public void setSysScore(BigDecimal sysScore) 
    {
        this.sysScore = sysScore;
    }

    public BigDecimal getSysScore() 
    {
        return sysScore;
    }
    public void setCompanyScore(BigDecimal companyScore) 
    {
        this.companyScore = companyScore;
    }

    public BigDecimal getCompanyScore() 
    {
        return companyScore;
    }
    public void setTeacherScore(BigDecimal teacherScore) 
    {
        this.teacherScore = teacherScore;
    }

    public BigDecimal getTeacherScore() 
    {
        return teacherScore;
    }
    public void setFinalScore(BigDecimal finalScore) 
    {
        this.finalScore = finalScore;
    }

    public BigDecimal getFinalScore() 
    {
        return finalScore;
    }
    public void setAppraisal(String appraisal) 
    {
        this.appraisal = appraisal;
    }

    public String getAppraisal() 
    {
        return appraisal;
    }
    public void setSummary(String summary) 
    {
        this.summary = summary;
    }

    public String getSummary() 
    {
        return summary;
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
        return "SysPracticeScore{" +
                "scoreId=" + scoreId +
                ", userId=" + userId +
                ", nickname='" + nickname + '\'' +
                ", locationId=" + locationId +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", sysScore=" + sysScore +
                ", companyScore=" + companyScore +
                ", teacherScore=" + teacherScore +
                ", finalScore=" + finalScore +
                ", appraisal='" + appraisal + '\'' +
                ", summary='" + summary + '\'' +
                ", status='" + status + '\'' +
                ", delFlag='" + delFlag + '\'' +
                '}';
    }
}
