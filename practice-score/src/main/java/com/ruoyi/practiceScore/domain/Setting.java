package com.ruoyi.practiceScore.domain;

import com.ruoyi.common.core.domain.BaseEntity;


public class Setting extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private int set_id;

    private float systemWeight;

    private float teacherWeight;

    private float companyWeight;

    private float punchWeight;

    private float logWeight;


    public Setting(int set_id, float systemWeight, float teacherWeight, float companyWeight, float punchWeight, float logWeight) {
        this.set_id = set_id;
        this.systemWeight = systemWeight;
        this.teacherWeight = teacherWeight;
        this.companyWeight = companyWeight;
        this.punchWeight = punchWeight;
        this.logWeight = logWeight;
    }

    @Override
    public String toString() {
        return "Setting{" +
                "set_id=" + set_id +
                ", systemWeight=" + systemWeight +
                ", teacherWeight=" + teacherWeight +
                ", companyWeight=" + companyWeight +
                ", punchWeight=" + punchWeight +
                ", logWeight=" + logWeight +
                '}';
    }

    public int getSet_id() {
        return set_id;
    }

    public void setSet_id(int set_id) {
        this.set_id = set_id;
    }

    public float getSystemWeight() {
        return systemWeight;
    }

    public void setSystemWeight(float systemWeight) {
        this.systemWeight = systemWeight;
    }

    public float getTeacherWeight() {
        return teacherWeight;
    }

    public void setTeacherWeight(float teacherWeight) {
        this.teacherWeight = teacherWeight;
    }

    public float getCompanyWeight() {
        return companyWeight;
    }

    public void setCompanyWeight(float companyWeight) {
        this.companyWeight = companyWeight;
    }

    public float getPunchWeight() {
        return punchWeight;
    }

    public void setPunchWeight(float punchWeight) {
        this.punchWeight = punchWeight;
    }

    public float getLogWeight() {
        return logWeight;
    }

    public void setLogWeight(float logWeight) {
        this.logWeight = logWeight;
    }
}
