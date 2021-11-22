package com.ruoyi.practiceScore.service;

import com.ruoyi.practiceScore.domain.Setting;
import org.springframework.stereotype.Service;

import java.util.List;


public interface SettingService {
    public List<Setting> getList();
    public int editSetting(Setting setting);
    public int calculate();
}

