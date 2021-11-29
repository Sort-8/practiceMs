package com.ruoyi.decentralize.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.location.domain.LocationInfo;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 分散实习申请对象 sys_decentralized_practice
 *
 * @author YuYang
 * @date 2021-10-20
 */
public class SysDecentralizedPractice extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 分散实习申请ID */
    private Long applyId;

    /** 分散实习申请ID */
    private String[] applyIds;

    private String searchKey;

    private String searchValue;

    /** 实习学生ID */
    @Excel(name = "实习学生ID")
    private Long stuId;

    /** 实习学生ID */
    @Excel(name = "实习学生姓名")
    private String stuName;

    /** 实习学生学号 */
    private String userName;

    /** 实习学生实体 */
    private SysUser student;

    /** 待审批人数 */
    private int awaitingApprovalNum;

    /** 单位名称*/
    private String companyName;

    /** 总人数 */
    private int totalNum;

    /** 实习单位经营（或业务）范围 */
    @Excel(name = "实习单位经营", readConverterExp = "或=业务")
    private String businessScope;

    /** 实习单位接收实习证明（PDF格式） */
    @Excel(name = "实习单位接收实习证明", readConverterExp = "P=DF格式")
    private String acceptanceCertificate;

    /** 备注 */
    @Excel(name = "备注")
    private String notes;

    /** 审核人ID */
    @Excel(name = "审核人ID")
    private Long auditorId;

    /** 审核人实体 */
    private SysUser auditor;

    /** 审核人实体 */
    private LocationInfo location;

    /** 审核人ID */
    @Excel(name = "审核人姓名")
    private String auditorName;

    /** 标识符 */
    private String flag;

    /** 审核时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "审核时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date auditTime;

    /** 状态（0未审核，1审核通过，-1审核未通过） */
    @Excel(name = "状态", readConverterExp = "0=未审核，1审核通过，-1审核未通过")
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    /** 实习地点ID */
    @Excel(name = "实习地点ID")
    private Long locationId;

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String[] getApplyIds() {
        return applyIds;
    }

    public void setApplyIds(String[] applyIds) {
        this.applyIds = applyIds;
    }

    public LocationInfo getLocation() {
        return location;
    }

    public void setLocation(LocationInfo location) {
        this.location = location;
    }

    public String getFlag() {
        return flag;
    }

    public int getAwaitingApprovalNum() {
        return awaitingApprovalNum;
    }

    public void setAwaitingApprovalNum(int awaitingApprovalNum) {
        this.awaitingApprovalNum = awaitingApprovalNum;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public SysUser getStudent() {
        return student;
    }

    public void setStudent(SysUser student) {
        this.student = student;
    }

    public SysUser getAuditor() {
        return auditor;
    }

    public void setAuditor(SysUser auditor) {
        this.auditor = auditor;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getAuditorName() {
        return auditorName;
    }

    public void setAuditorName(String auditorName) {
        this.auditorName = auditorName;
    }

    public void setApplyId(Long applyId)
    {
        this.applyId = applyId;
    }

    public Long getApplyId()
    {
        return applyId;
    }
    public void setStuId(Long stuId)
    {
        this.stuId = stuId;
    }

    public Long getStuId()
    {
        return stuId;
    }
    public void setBusinessScope(String businessScope)
    {
        this.businessScope = businessScope;
    }

    public String getBusinessScope()
    {
        return businessScope;
    }
    public void setAcceptanceCertificate(String acceptanceCertificate)
    {
        this.acceptanceCertificate = acceptanceCertificate;
    }

    public String getAcceptanceCertificate()
    {
        return acceptanceCertificate;
    }
    public void setNotes(String notes)
    {
        this.notes = notes;
    }

    public String getNotes()
    {
        return notes;
    }
    public void setAuditorId(Long auditorId)
    {
        this.auditorId = auditorId;
    }

    public Long getAuditorId()
    {
        return auditorId;
    }
    public void setAuditTime(Date auditTime)
    {
        this.auditTime = auditTime;
    }

    public Date getAuditTime()
    {
        return auditTime;
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
    public void setLocationId(Long locationId)
    {
        this.locationId = locationId;
    }

    public Long getLocationId()
    {
        return locationId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("applyId", getApplyId())
            .append("stuId", getStuId())
            .append("businessScope", getBusinessScope())
            .append("acceptanceCertificate", getAcceptanceCertificate())
            .append("notes", getNotes())
            .append("auditorId", getAuditorId())
            .append("auditTime", getAuditTime())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("locationId", getLocationId())
            .toString();
    }
}
