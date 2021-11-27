package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 基地信息管理对象 sys_base_info
 *
 * @author xieweiming
 * @date 2021-10-01
 */
public class SysBaseInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 基地ID */
    @Excel(name = "基地ID")
    private Long baseId;

    /** 单位名称 */
    @Excel(name = "单位名称")
    private String companyName;

    /** 基地名称 */
    @Excel(name = "基地名称")
    private String baseName;

    /** 基地单位性质 */
    @Excel(name = "基地单位性质")
    private String baseNature;

    /** 基地法定代表（负责人） */
    @Excel(name = "基地法定代表（负责人）")
    private String baseLeader;

    /** 基地联系人 */
    @Excel(name = "基地联系人")
    private String baseContacts;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String basePhone;

    /** 传真 */
    @Excel(name = "传真")
    private String baseFax;

    /** 基地单位地址 */
    @Excel(name = "基地单位地址")
    private String baseAddress;

    /** 基地经纬度 */
    @Excel(name = "基地经纬度")
    private String tude;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String baseEmail;

    /** 学校基地负责人 */
    @Excel(name = "学校基地负责人")
    private String schoolLeader;

    /** 学校基地负责人电话 */
    @Excel(name = "学校基地负责人电话")
    private String schoolPhone;

    /** 基地情况简介 */
    @Excel(name = "基地情况简介")
    private String baseIntroduction;

    /** 实习环境 */
    @Excel(name = "实习环境")
    private String practiceEnvironment;

/*    *//** 基地状态（0正常 1停用） *//*
    @Excel(name = "基地状态")
    private String status;*/

    /** 基地申请表存放地址（PDF） */
    @Excel(name = "基地申请表存放地址")
    private String appliForm;

    /** 搜索字段 */
    private String searchKey;

    /** 删除标志（0代表存在 2代表删除） */
    @Excel(name = "删除标志")
    private String delFlag;

    public void setBaseId(Long baseId)
    {
        this.baseId = baseId;
    }

    public Long getBaseId()
    {
        return baseId;
    }
    public void setCompanyName(String companyName)
    {
        this.companyName = companyName;
    }

    public String getCompanyName()
    {
        return companyName;
    }
    public void setBaseName(String baseName)
    {
        this.baseName = baseName;
    }

    public String getBaseName()
    {
        return baseName;
    }
    public void setBaseNature(String baseNature)
    {
        this.baseNature = baseNature;
    }

    public String getBaseNature()
    {
        return baseNature;
    }
    public void setBaseLeader(String baseLeader)
    {
        this.baseLeader = baseLeader;
    }

    public String getBaseLeader()
    {
        return baseLeader;
    }
    public void setBaseContacts(String baseContacts)
    {
        this.baseContacts = baseContacts;
    }

    public String getBaseContacts()
    {
        return baseContacts;
    }
    public void setBasePhone(String basePhone)
    {
        this.basePhone = basePhone;
    }

    public String getBasePhone()
    {
        return basePhone;
    }
    public void setBaseFax(String baseFax)
    {
        this.baseFax = baseFax;
    }

    public String getBaseFax()
    {
        return baseFax;
    }
    public void setBaseAddress(String baseAddress)
    {
        this.baseAddress = baseAddress;
    }

    public String getBaseAddress()
    {
        return baseAddress;
    }
    public void setBaseEmail(String baseEmail)
    {
        this.baseEmail = baseEmail;
    }

    public String getBaseEmail()
    {
        return baseEmail;
    }
    public void setSchoolLeader(String schoolLeader)
    {
        this.schoolLeader = schoolLeader;
    }

    public String getSchoolLeader()
    {
        return schoolLeader;
    }
    public void setSchoolPhone(String schoolPhone)
    {
        this.schoolPhone = schoolPhone;
    }

    public String getSchoolPhone()
    {
        return schoolPhone;
    }
    public void setBaseIntroduction(String baseIntroduction)
    {
        this.baseIntroduction = baseIntroduction;
    }

    public String getBaseIntroduction()
    {
        return baseIntroduction;
    }
    public void setPracticeEnvironment(String practiceEnvironment)
    {
        this.practiceEnvironment = practiceEnvironment;
    }

    public String getPracticeEnvironment()
    {
        return practiceEnvironment;
    }
    /*public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }*/

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setDelFlag(String delFlag)
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag()
    {
        return delFlag;
    }

    public void setTude(String tude)
    {
        this.tude = tude;
    }

    public String getTude()
    {
        return tude;
    }

    public void setAppliForm(String appliForm)
    {
        this.appliForm = appliForm;
    }

    public String getAppliForm()
    {
        return appliForm;
    }
    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("baseId", getBaseId())
            .append("companyName", getCompanyName())
            .append("baseName", getBaseName())
            .append("baseNature", getBaseNature())
            .append("baseLeader", getBaseLeader())
            .append("baseContacts", getBaseContacts())
            .append("basePhone", getBasePhone())
            .append("baseFax", getBaseFax())
            .append("baseAddress", getBaseAddress())
            .append("tude", getTude())
            .append("baseEmail", getBaseEmail())
            .append("schoolLeader", getSchoolLeader())
            .append("schoolPhone", getSchoolPhone())
            .append("baseIntroduction", getBaseIntroduction())
            .append("practiceEnvironment", getPracticeEnvironment())
            /*.append("status", getStatus())*/
            .append("searchKey", getSearchKey())
            .append("appliForm", getAppliForm())
            .append("delFlag", getDelFlag())
            .toString();
    }
}
