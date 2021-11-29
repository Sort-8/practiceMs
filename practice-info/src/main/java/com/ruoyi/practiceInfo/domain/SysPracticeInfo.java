package com.ruoyi.practiceInfo.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.system.domain.SysBaseInfo;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 实习信息对象 sys_practice_info
 *
 * @author YuYang
 * @date 2021-09-23
 */
public class SysPracticeInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 实习信息ID */
    private Long infoId;

    /** 地点ID */
    @Excel(name = "地点ID")
    private Long locationId;

    private String locationName;

    /** 岗位名称 */
    @Excel(name = "岗位名称")
    private String postName;

    private String searchKey;

    private String searchValue;

    /** 指导老师 */
    private String teacherName;

    /** 实习人数 */
    @Excel(name = "实习人数")
    private Long number;

    /** 岗位剩余量 */
    @Excel(name = "岗位剩余量")
    private Long surplus;

    /** 实习时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "实习时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date entryTime;

    /** 结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endingTime;

    /** 状态（0启用 1停用） */
    @Excel(name = "状态", readConverterExp = "0=启用,1=停用")
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    /** 实习基地实体*/
    private SysBaseInfo baseInfo;

    /** 指导老师实体*/
    private SysUser teacher;

    /** 实习学生组*/
    private Long[] studentIds;

    private String stuStrings;

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    /** 指导老师ID */
    @Excel(name = "指导老师ID")
    private Long teacherId;

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    @Override
    public String getSearchValue() {
        return searchValue;
    }

    @Override
    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    public Date getEndingTime() {
        return endingTime;
    }

    public void setEndingTime(Date endingTime) {
        this.endingTime = endingTime;
    }

    public Long[] getStudentIds() {
        return studentIds;
    }

    public void setStudentIds(Long[] studentIds) {
        this.studentIds = studentIds;
    }

    public String getStuStrings() {
        return stuStrings;
    }

    public void setStuStrings(String stuStrings) {
        this.stuStrings = stuStrings;
    }

    public Long[] getStudentsId() {
        return studentIds;
    }

    public void setStudentsId(Long[] studentsId) {
        this.studentIds = studentsId;
    }

    public Long getSurplus() {
        return surplus;
    }

    public void setSurplus(Long surplus) {
        this.surplus = surplus;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public SysUser getTeacher() {
        return teacher;
    }

    public void setTeacher(SysUser teacher) {
        this.teacher = teacher;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public SysBaseInfo getBaseInfo() {
        return baseInfo;
    }

    public void setBaseInfo(SysBaseInfo baseInfo) {
        this.baseInfo = baseInfo;
    }

    public void setInfoId(Long infoId)
    {
        this.infoId = infoId;
    }

    public Long getInfoId()
    {
        return infoId;
    }
    public void setLocationId(Long locationId)
    {
        this.locationId = locationId;
    }

    public Long getLocationId()
    {
        return locationId;
    }
    public void setPostName(String postName)
    {
        this.postName = postName;
    }

    public String getPostName()
    {
        return postName;
    }
    public void setNumber(Long number)
    {
        this.number = number;
    }

    public Long getNumber()
    {
        return number;
    }
    public void setEntryTime(Date entryTime)
    {
        this.entryTime = entryTime;
    }

    public Date getEntryTime()
    {
        return entryTime;
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
    public void setTeacherId(Long teacherId)
    {
        this.teacherId = teacherId;
    }

    public Long getTeacherId()
    {
        return teacherId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("infoId", getInfoId())
            .append("locationId", getLocationId())
            .append("postName", getPostName())
            .append("number", getNumber())
            .append("entryTime", getEntryTime())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("teacherId", getTeacherId())
            .toString();
    }
}
