package com.ruoyi.practiceScore.mapper;

import com.ruoyi.practiceScore.domain.Setting;

import java.util.List;

public interface SettingMapper {
    public List<Setting> selectSettingList();
    public int editSetting(Setting setting);
}
