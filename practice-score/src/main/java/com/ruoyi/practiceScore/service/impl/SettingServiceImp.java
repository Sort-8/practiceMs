package com.ruoyi.practiceScore.service.impl;

import com.ruoyi.practiceScore.domain.Setting;
import com.ruoyi.practiceScore.mapper.SettingMapper;

import com.ruoyi.practiceScore.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SettingServiceImp implements SettingService {

    @Autowired
    private SettingMapper settingMapper;

    @Override
    public List<Setting> getList() {
        return settingMapper.selectSettingList();
    }

    @Override
    public int editSetting(Setting setting) {
        return 0;
    }

    @Override
    public int calculate() {
        return 0;
    }
}
