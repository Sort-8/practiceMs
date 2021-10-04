package com.ruoyi.location.mapper;

import java.util.List;
import com.ruoyi.location.domain.LocationInfo;

/**
 * 地点信息Mapper接口
 *
 * @author ph
 * @date 2021-09-28
 */
public interface LocationInfoMapper
{
    /**
     * 获取所有地点信息的经纬度
     *
     * @return 所有地点信息的经纬度
     */
    public LocationInfo selectLocationTude();

    /**
     * 查询地点信息
     *
     * @param locationId 地点信息ID
     * @return 地点信息
     */
    public LocationInfo selectLocationInfoById(Long locationId);

    /**
     * 查询地点信息列表
     *
     * @param locationInfo 地点信息
     * @return 地点信息集合
     */
    public List<LocationInfo> selectLocationInfoList(LocationInfo locationInfo);

    /**
     * 新增地点信息
     *
     * @param locationInfo 地点信息
     * @return 结果
     */
    public int insertLocationInfo(LocationInfo locationInfo);

    /**
     * 修改地点信息
     *
     * @param locationInfo 地点信息
     * @return 结果
     */
    public int updateLocationInfo(LocationInfo locationInfo);

    /**
     * 删除地点信息
     *
     * @param locationId 地点信息ID
     * @return 结果
     */
    public int deleteLocationInfoById(Long locationId);

    /**
     * 批量删除地点信息
     *
     * @param locationIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteLocationInfoByIds(Long[] locationIds);

    /**
     * 地点信息状态修改
     *
     * @param locationInfo 地点信息
     * @return 结果
     */
    public int updateLocationStatus(LocationInfo locationInfo);
}
