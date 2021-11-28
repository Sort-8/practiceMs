package com.ruoyi.location.service.impl;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.location.domain.LocationInfo;
import com.ruoyi.location.mapper.ArchivedLocationInfoMapper;
import com.ruoyi.location.mapper.LocationInfoMapper;
import com.ruoyi.location.service.ArchivedLocationInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@DataSource(value = DataSourceType.SLAVE)
public class ArchivedLocationInfoServiceImpl implements ArchivedLocationInfoService {
    @Autowired
    private ArchivedLocationInfoMapper archivedLocationInfoMapper;

    /**
     * 查询地点信息列表
     *
     * @param locationInfo 地点信息
     * @return 地点信息
     */
    @Override
    public List<LocationInfo> selectLocationInfoList(LocationInfo locationInfo)
    {
        return archivedLocationInfoMapper.selectLocationInfoList(locationInfo);
    }
}
