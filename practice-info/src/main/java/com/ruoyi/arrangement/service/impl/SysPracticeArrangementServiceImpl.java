package com.ruoyi.arrangement.service.impl;

import java.beans.PropertyDescriptor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.decentralize.domain.SysDecentralizedPractice;
import com.ruoyi.decentralize.service.ISysDecentralizedPracticeService;
import org.apache.commons.beanutils.PropertyUtilsBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.arrangement.mapper.SysPracticeArrangementMapper;
import com.ruoyi.arrangement.domain.SysPracticeArrangement;
import com.ruoyi.arrangement.service.ISysPracticeArrangementService;

/**
 * 实习安排Service业务层处理
 *
 * @author YuYang
 * @date 2021-09-23
 */
@Service
public class SysPracticeArrangementServiceImpl implements ISysPracticeArrangementService
{
    @Autowired
    private SysPracticeArrangementMapper sysPracticeArrangementMapper;

    @Autowired
    private ISysDecentralizedPracticeService iSysDecentralizedPracticeService;

    /**
     * 查询实习安排
     *
     * @param arrangementId 实习安排ID
     * @return 实习安排
     */
    @Override
    public SysPracticeArrangement selectSysPracticeArrangementById(Long arrangementId)
    {
        return sysPracticeArrangementMapper.selectSysPracticeArrangementById(arrangementId);
    }

    /**
     * 查询实习安排
     *
     * @param teacher 指导老师
     * @return 指导老师
     */
    @Override
    public SysUser getAllTeacher(SysUser teacher) {
        return sysPracticeArrangementMapper.getAllTeacher(teacher);
    }

    @Override
    public Map getPracticeInfo(LoginUser u) {
        SysPracticeArrangement pa = new SysPracticeArrangement();
        pa.setStuId(u.getUser().getUserId());
        pa.setUserName(u.getUsername());
        List<SysPracticeArrangement> list = selectSysPracticeArrangementList(pa);
        if(list.size() > 0){
            return beanToMap(list.get(0));
        }else{
            SysDecentralizedPractice dp = iSysDecentralizedPracticeService.getPracticeStudentInfo(pa.getUserName());
            if(dp != null){
                return beanToMap(dp);
            }
        }
        Map<String , Object> map = new HashMap<>();
        map.put("user" , u.getUser());
        return map;
    }

    public static Map<String, Object> beanToMap(Object obj) {
        Map<String, Object> params = new HashMap<String, Object>(0);
        try {
            PropertyUtilsBean propertyUtilsBean = new PropertyUtilsBean();
            PropertyDescriptor[] descriptors = propertyUtilsBean.getPropertyDescriptors(obj);
            for (int i = 0; i < descriptors.length; i++) {
                String name = descriptors[i].getName();
                if (!"class".equals(name)) {
                    params.put(name, propertyUtilsBean.getNestedProperty(obj, name));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return params;
    }

    /**
     * 查询实习安排列表
     *
     * @param sysPracticeArrangement 实习安排
     * @return 实习安排
     */
    @Override
    public List<SysPracticeArrangement> selectSysPracticeArrangementList(SysPracticeArrangement sysPracticeArrangement)
    {
        return sysPracticeArrangementMapper.selectSysPracticeArrangementList(sysPracticeArrangement);
    }

    /**
     * 新增实习安排
     *
     * @param sysPracticeArrangement 实习安排
     * @return 结果
     */
    @Override
    public int insertSysPracticeArrangement(SysPracticeArrangement sysPracticeArrangement)
    {
        return sysPracticeArrangementMapper.insertSysPracticeArrangement(sysPracticeArrangement);
    }

    /**
     * 修改实习安排
     *
     * @param sysPracticeArrangement 实习安排
     * @return 结果
     */
    @Override
    public int updateSysPracticeArrangement(SysPracticeArrangement sysPracticeArrangement)
    {
        return sysPracticeArrangementMapper.updateSysPracticeArrangement(sysPracticeArrangement);
    }

    /**
     * 批量删除实习安排
     *
     * @param arrangementIds 需要删除的实习安排ID
     * @return 结果
     */
    @Override
    public int deleteSysPracticeArrangementByIds(Long[] arrangementIds)
    {
        return sysPracticeArrangementMapper.deleteSysPracticeArrangementByIds(arrangementIds);
    }

    /**
     * 删除实习安排信息
     *
     * @param arrangementId 实习安排ID
     * @return 结果
     */
    @Override
    public int deleteSysPracticeArrangementById(Long arrangementId)
    {
        return sysPracticeArrangementMapper.deleteSysPracticeArrangementById(arrangementId);
    }

    /**
     * 删除实习安排信息
     *
     * @param infoId 实习安排ID
     * @return 结果
     */
    @Override
    public int deleteSysPracticeArrangementByInfoId(Long infoId)
    {
        return sysPracticeArrangementMapper.deleteSysPracticeArrangementByInfoId(infoId);
    }
}
