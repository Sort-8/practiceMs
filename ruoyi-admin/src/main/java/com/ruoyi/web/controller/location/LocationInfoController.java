package com.ruoyi.web.controller.location;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.location.domain.LocationInfo;
import com.ruoyi.location.service.ILocationInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 地点信息Controller
 *
 * @author ph
 * @date 2021-09-28
 */
@RestController
@RequestMapping("/location/info")
public class LocationInfoController extends BaseController
{
    @Autowired
    private ILocationInfoService locationInfoService;

    /**
     * 获取所有地点信息的经纬度
     *
     * @return 所有地点信息的经纬度
     */
    @PreAuthorize("@ss.hasPermi('location:info:list')")
    @GetMapping("/selectLocationTude")
    public AjaxResult selectLocationTude()
    {
        return AjaxResult.success(locationInfoService.selectLocationTude());
    }

    /**
     * 查询地点信息列表
     */
    @PreAuthorize("@ss.hasPermi('location:info:list')")
    @GetMapping("/list")
    public TableDataInfo list(LocationInfo locationInfo)
    {
        startPage();
        List<LocationInfo> list = locationInfoService.selectLocationInfoList(locationInfo);
        return getDataTable(list);
    }

    /**
     * 导出地点信息列表
     */
    @PreAuthorize("@ss.hasPermi('location:info:export')")
    @Log(title = "地点信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(LocationInfo locationInfo)
    {
        List<LocationInfo> list = locationInfoService.selectLocationInfoList(locationInfo);
        ExcelUtil<LocationInfo> util = new ExcelUtil<LocationInfo>(LocationInfo.class);
        return util.exportExcel(list, "地点信息数据");
    }

    /**
     * 获取地点信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('location:info:query')")
    @GetMapping(value = "/{locationId}")
    public AjaxResult getInfo(@PathVariable("locationId") Long locationId)
    {
        return AjaxResult.success(locationInfoService.selectLocationInfoById(locationId));
    }

    /**
     * 新增地点信息
     */
    @PreAuthorize("@ss.hasPermi('location:info:add')")
    @Log(title = "地点信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LocationInfo locationInfo)
    {
        return toAjax(locationInfoService.insertLocationInfo(locationInfo));
    }

    /**
     * 修改地点信息
     */
    @PreAuthorize("@ss.hasPermi('location:info:edit')")
    @Log(title = "地点信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LocationInfo locationInfo)
    {
        return toAjax(locationInfoService.updateLocationInfo(locationInfo));
    }

    /**
     * 删除地点信息
     */
    @PreAuthorize("@ss.hasPermi('location:info:remove')")
    @Log(title = "地点信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{locationIds}")
    public AjaxResult remove(@PathVariable Long[] locationIds)
    {
        return toAjax(locationInfoService.deleteLocationInfoByIds(locationIds));
    }

}
