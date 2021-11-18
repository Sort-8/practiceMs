package com.ruoyi.web.controller.practice;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.practiceScore.domain.SysPracticeScore;
import com.ruoyi.practiceScore.service.ISysPracticeScoreService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 实习成绩Controller
 *
 * @author ruoyi
 * @date 2021-10-03
 */
@RestController
@RequestMapping("/practice-score/practiceScore")
public class SysPracticeScoreController extends BaseController
{
    @Autowired
    private ISysPracticeScoreService sysPracticeScoreService;

    /**
     * 查询实习成绩列表
     */
    @PreAuthorize("@ss.hasPermi('practice-score:practiceScore:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysPracticeScore sysPracticeScore)
    {
        startPage();
        List<SysPracticeScore> list = sysPracticeScoreService.selectSysPracticeScoreList(sysPracticeScore);
        return getDataTable(list);
    }

    /**
     * 查询实习成绩列表(自定义)
     */
    @PreAuthorize("@ss.hasPermi('practice-score:practiceScore:list')")
    @GetMapping("/list2")
    public TableDataInfo list2(SysPracticeScore sysPracticeScore)
    {
        startPage();
        List<SysPracticeScore> list = sysPracticeScoreService.selectSysPracticeScoreList(sysPracticeScore);
        return getDataTable(list);
    }

    /**
     * 导出实习成绩列表
     */
    @PreAuthorize("@ss.hasPermi('practice-score:practiceScore:export')")
    @Log(title = "实习成绩", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(SysPracticeScore sysPracticeScore)
    {
        List<SysPracticeScore> list = sysPracticeScoreService.selectSysPracticeScoreList(sysPracticeScore);
        ExcelUtil<SysPracticeScore> util = new ExcelUtil<SysPracticeScore>(SysPracticeScore.class);
        return util.exportExcel(list, "实习成绩数据");
    }

    /**
     * 获取实习成绩详细信息
     */
    @PreAuthorize("@ss.hasPermi('practice-score:practiceScore:query')")
    @GetMapping(value = "/")
    public AjaxResult getInfo(SysPracticeScore sysPracticeScore)
    {
        return AjaxResult.success(sysPracticeScoreService.selectSysPracticeScoreById(sysPracticeScore));
    }

    /**
     * 新增实习成绩
     */
    @PreAuthorize("@ss.hasPermi('practice-score:practiceScore:add')")
    @Log(title = "实习成绩", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysPracticeScore sysPracticeScore)
    {
        return toAjax(sysPracticeScoreService.insertSysPracticeScore(sysPracticeScore));
    }

    /**
     * 修改实习成绩
     */
    @PreAuthorize("@ss.hasPermi('practice-score:practiceScore:edit')")
    @Log(title = "实习成绩", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysPracticeScore sysPracticeScore)
    {
        return toAjax(sysPracticeScoreService.updateSysPracticeScore(sysPracticeScore));
    }

    /**
     * 修改实习成绩
     */
    @PreAuthorize("@ss.hasPermi('practice-score:practiceScore:edit')")
    @Log(title = "实习成绩", businessType = BusinessType.UPDATE)
    @PutMapping("/changeStatus")
    public AjaxResult changeStatus(@RequestBody SysPracticeScore sysPracticeScore)
    {
        return toAjax(sysPracticeScoreService.updateScoreStatus(sysPracticeScore));
    }


    /**
     * 删除实习成绩
     */
    @PreAuthorize("@ss.hasPermi('practice-score:practiceScore:remove')")
    @Log(title = "实习成绩", businessType = BusinessType.DELETE)
	@DeleteMapping("/{scoreIds}")
    public AjaxResult remove(@PathVariable Long[] scoreIds)
    {
        return toAjax(sysPracticeScoreService.deleteSysPracticeScoreByIds(scoreIds));
    }
}
