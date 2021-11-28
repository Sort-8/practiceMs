package com.ruoyi.location.mapper;

import com.ruoyi.location.domain.LocationInfo;

import java.util.List;

public interface ArchivedLocationInfoMapper {
    /**
     * 查询地点信息列表
     *
     * @param locationInfo 地点信息
     * @return 地点信息集合
     */
    public List<LocationInfo> selectLocationInfoList(LocationInfo locationInfo);

}
