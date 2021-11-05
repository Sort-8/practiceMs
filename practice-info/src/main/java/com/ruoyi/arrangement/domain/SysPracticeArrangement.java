package com.ruoyi.arrangement.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.annotation.Excels;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.practiceInfo.domain.SysPracticeInfo;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 实习安排对象 sys_practice_arrangement
 *
 * @author YuYang
 * @date 2021-09-23
 */
public class SysPracticeArrangement extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 实习安排ID */
    private Long arrangementId;

    /** 岗位名称 */
    private String postName;

    /** 用户名称 */
    private String userName;

    /** 用户姓名 */
    private String nickName;

    /** 实习学生ID */
    @Excel(name = "实习学生ID")
    private Long stuId;

    /** 实习信息ID */
    @Excel(name = "实习信息ID")
    private Long infoId;

    /** 表示老师ID */
    private Long teacherId;

    /** 备注 */
    @Excel(name = "备注")
    private String notes;

    /** 实习信息对象 */
    @Excels({
            @Excel(name = "实习信息ID", targetAttr = "infoId", type = Excel.Type.EXPORT),
            @Excel(name = "岗位名称", targetAttr = "postName", type = Excel.Type.EXPORT)
    })
    private SysPracticeInfo info;

    /** 学生信息对象 */
    @Excels({
            @Excel(name = "用户名", targetAttr = "userName", type = Excel.Type.EXPORT),
            @Excel(name = "昵称", targetAttr = "nickName", type = Excel.Type.EXPORT)
    })
    private SysUser user;

    /** 状态（0同意 1拒绝） */
    @Excel(name = "状态", readConverterExp = "0=同意,1=拒绝")
    private String stuOption;

    /** 状态（0启用 1停用） */
    @Excel(name = "状态", readConverterExp = "0=启用,1=停用")
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    public String getPostName() {
        return postName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public SysPracticeInfo getInfo() {
        return info;
    }

    public void setInfo(SysPracticeInfo info) {
        this.info = info;
    }

    public SysUser getUser() {
        return user;
    }

    public void setUser(SysUser user) {
        this.user = user;
    }

    public void setArrangementId(Long arrangementId)
    {
        this.arrangementId = arrangementId;
    }

    public Long getArrangementId()
    {
        return arrangementId;
    }
    public void setStuId(Long stuId)
    {
        this.stuId = stuId;
    }

    public Long getStuId()
    {
        return stuId;
    }
    public void setInfoId(Long infoId)
    {
        this.infoId = infoId;
    }

    public Long getInfoId()
    {
        return infoId;
    }
    public void setNotes(String notes)
    {
        this.notes = notes;
    }

    public String getNotes()
    {
        return notes;
    }
    public void setStuOption(String stuOption)
    {
        this.stuOption = stuOption;
    }

    public String getStuOption()
    {
        return stuOption;
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

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("arrangementId", getArrangementId())
            .append("stuId", getStuId())
            .append("infoId", getInfoId())
            .append("notes", getNotes())
            .append("stuOption", getStuOption())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .toString();
    }
}
