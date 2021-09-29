package com.ruoyi.location.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.location.mapper.LocationInfoMapper;
import com.ruoyi.location.domain.LocationInfo;
import com.ruoyi.location.service.ILocationInfoService;

/**
 * 地点信息Service业务层处理
 *
 * @author ph
 * @date 2021-09-28
 */
@Service
public class LocationInfoServiceImpl implements ILocationInfoService
{
    @Autowired
    private LocationInfoMapper locationInfoMapper;

    /**
     * 查询地点信息
     *
     * @param locationId 地点信息ID
     * @return 地点信息
     */
    @Override
    public LocationInfo selectLocationInfoById(Long locationId)
    {
        return locationInfoMapper.selectLocationInfoById(locationId);
    }

    /**
     * 查询地点信息列表
     *
     * @param locationInfo 地点信息
     * @return 地点信息
     */
    @Override
    public List<LocationInfo> selectLocationInfoList(LocationInfo locationInfo)
    {
        return locationInfoMapper.selectLocationInfoList(locationInfo);
    }

    /**
     * 新增地点信息
     *
     * @param locationInfo 地点信息
     * @return 结果
     */
    @Override
    public int insertLocationInfo(LocationInfo locationInfo)
    {
        return locationInfoMapper.insertLocationInfo(locationInfo);
    }

    /**
     * 修改地点信息
     *
     * @param locationInfo 地点信息
     * @return 结果
     */
    @Override
    public int updateLocationInfo(LocationInfo locationInfo)
    {
        return locationInfoMapper.updateLocationInfo(locationInfo);
    }

    /**
     * 批量删除地点信息
     *
     * @param locationIds 需要删除的地点信息ID
     * @return 结果
     */
    @Override
    public int deleteLocationInfoByIds(Long[] locationIds)
    {
        return locationInfoMapper.deleteLocationInfoByIds(locationIds);
    }

    /**
     * 删除地点信息信息
     *
     * @param locationId 地点信息ID
     * @return 结果
     */
    @Override
    public int deleteLocationInfoById(Long locationId)
    {
        return locationInfoMapper.deleteLocationInfoById(locationId);
    }

    @Override
    public int updateLocationStatus(LocationInfo locationInfo) {
        return locationInfoMapper.updateLocationStatus(locationInfo);
    }
}
