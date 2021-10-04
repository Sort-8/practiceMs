package com.ruoyi.location.service.impl;

import java.util.ArrayList;
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
 * @date 2021-10-04
 */
@Service
public class LocationInfoServiceImpl implements ILocationInfoService
{
    @Autowired
    private LocationInfoMapper locationInfoMapper;

    /**
     * 获取所有地点信息的经纬度
     *
     * @return 所有地点信息的经纬度
     */
    @Override
    public List<List> selectLocationTude()
    {
        List<List> resList = new ArrayList<>();
        List<LocationInfo> l = locationInfoMapper.selectLocationTude();
        for (int i = 0; i < l.size(); i++) {
            LocationInfo locationInfo = l.get(i);
            String tude = locationInfo.getTude();
            String [] r = tude.split(",");
            List<String> list = new ArrayList<>();
            if(r.length>0){
                list.add(r[0]);
            }
            if(r.length>1){
                list.add(r[1]);
            }
            resList.add(list);
        }
        return resList;
    }

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
