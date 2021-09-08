package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 实习基地信息对象 sys_base
 * 
 * @author tomorrow
 * @date 2021-08-16
 */
public class SysBase extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long baseId;

    /** 基地名称 */
    @Excel(name = "基地名称")
    private String baseName;

    public void setBaseId(Long baseId) 
    {
        this.baseId = baseId;
    }

    public Long getBaseId() 
    {
        return baseId;
    }
    public void setBaseName(String baseName) 
    {
        this.baseName = baseName;
    }

    public String getBaseName() 
    {
        return baseName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("baseId", getBaseId())
            .append("baseName", getBaseName())
            .toString();
    }
}
