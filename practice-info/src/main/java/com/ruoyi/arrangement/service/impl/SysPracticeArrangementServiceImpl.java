package com.ruoyi.arrangement.service.impl;

import java.beans.PropertyDescriptor;
import java.util.*;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.core.page.PageDomain;
import com.ruoyi.common.core.page.TableSupport;
import com.ruoyi.decentralize.domain.SysDecentralizedPractice;
import com.ruoyi.decentralize.service.ISysDecentralizedPracticeService;
import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.system.service.impl.SysUserServiceImpl;
import org.apache.commons.beanutils.PropertyUtilsBean;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.arrangement.mapper.SysPracticeArrangementMapper;
import com.ruoyi.arrangement.domain.SysPracticeArrangement;
import com.ruoyi.arrangement.service.ISysPracticeArrangementService;

import javax.jws.Oneway;

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
    private ISysUserService sysUserService;

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
        map.put("student" , u.getUser());
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
     * 查询集中实习以及分散实习
     *
     * @param sysPracticeArrangement 实习安排
     * @return 实习安排
     */
    @Override
    public Map selectAllPractice(SysPracticeArrangement sysPracticeArrangement)
    {
        PageDomain pageDomain = TableSupport.buildPageRequest();
        Integer pageNum = pageDomain.getPageNum();
        Integer pageSize = pageDomain.getPageSize();
        SysDecentralizedPractice practice = new SysDecentralizedPractice();
        practice.setUserName(sysPracticeArrangement.getUserName());
        practice.setStuName(sysPracticeArrangement.getNickName());
        List<SysPracticeArrangement> list_a = new ArrayList<>();
        List<SysDecentralizedPractice> list_d = new ArrayList<>();
        if("1".equals(sysPracticeArrangement.getPracticeType())){
            list_a = sysPracticeArrangementMapper.selectSysPracticeArrangementList(sysPracticeArrangement);
        }else if("2".equals(sysPracticeArrangement.getPracticeType())){
            list_d = iSysDecentralizedPracticeService.selectSysDecentralizedPracticeList(practice);
        }else{
            list_a = sysPracticeArrangementMapper.selectSysPracticeArrangementList(sysPracticeArrangement);
            list_d = iSysDecentralizedPracticeService.selectSysDecentralizedPracticeList(practice);
        }
        List list = new ArrayList();
        Iterator<SysPracticeArrangement> it1 = list_a.iterator();
        while (it1.hasNext()) {
            list.add(it1.next());
        }
        Iterator<SysDecentralizedPractice> it2 = list_d.iterator();
        while (it2.hasNext()) {
            list.add(it2.next());
        }

        Map r = new HashMap();
        int i = 0;
        if((pageNum - 1) * pageSize > list.size()){
            for(Object obj : list){
                r.put(i++ , obj);
                if(i == list.size()){
                    break;
                }
            }
        }
        int start = (pageNum - 1)* pageSize;
        if(list.size() - (pageNum - 1)* pageSize <  pageSize){
            pageSize = list.size() - (pageNum - 1)* pageSize;
        }
        List returnResult = list.subList( start , start + pageSize);
        r.put("total",list.size());
        for(Object obj : returnResult){
            r.put(i++ , obj);
            if(i == returnResult.size()){
                break;
            }
        }
        return r;
    }

    @Override
    public Map getScreenData(SysPracticeArrangement sysPracticeArrangement) {
        Map map = new HashMap();
        map.put("focusPracticeNum",selectSysPracticeArrangementList(sysPracticeArrangement).size());
        SysDecentralizedPractice decentralizedPractice = new SysDecentralizedPractice();
        map.put("scatteredPracticeNum",iSysDecentralizedPracticeService.selectSysDecentralizedPracticeList(decentralizedPractice).size());
        SysUser user = new SysUser();
        int noPracticeNum = iSysDecentralizedPracticeService.getPracticeByStatus("1");
        int noApplyNum = sysUserService.selectNoPracticeStudent(user).size();
        map.put("unPracticeTotalNum",noApplyNum + noPracticeNum);
        map.put("noApplyNum",noApplyNum);
        map.put("noPracticeNum",noPracticeNum);
        return map;
    }

    /**
     * 查询老师指导的学生信息
     *
     * @param
     * @return
     */
    @Override
    public List<SysPracticeArrangement> selectStudentInfo(SysPracticeArrangement sysPracticeArrangement) {
        return sysPracticeArrangementMapper.selectStudentInfo(sysPracticeArrangement);
    }

    /**
     * 查询老师指导的学生信息
     *
     * @param
     * @return
     */
    @Override
    public List<SysUser> selectGuideStudent(Long teacherId) {
        return sysPracticeArrangementMapper.selectGuideStudent(teacherId);
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
