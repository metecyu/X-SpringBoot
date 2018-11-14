package com.suke.czx.modules.user.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.suke.czx.common.annotation.SysLog;
import com.suke.czx.common.validator.ValidatorUtils;
import com.suke.czx.modules.sys.entity.SysRoleEntity;
import com.suke.czx.modules.user.entity.MonthclassEntity;
import com.suke.czx.modules.user.entity.TclassEntity;
import com.suke.czx.modules.user.entity.TermEntity;
import com.suke.czx.modules.user.service.MonthclassService;
import com.suke.czx.modules.user.service.MonthteacherclassService;
import com.suke.czx.modules.user.service.TermService;
import org.apache.commons.collections.map.HashedMap;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.suke.czx.modules.user.entity.MonthteacherEntity;
import com.suke.czx.modules.user.service.MonthteacherService;
import com.suke.czx.common.utils.PageUtils;
import com.suke.czx.common.utils.Query;
import com.suke.czx.common.utils.R;




/**
 * 班级表
 * 
 * @author czx
 * @email object_czx@163.com
 * @date 2018-11-09 15:32:07
 */
@RestController
@RequestMapping("/user/monthteacher")
public class MonthteacherController {
    @Autowired
    private MonthteacherService monthteacherService;
    @Autowired
    private MonthclassService monthclassService;
    @Autowired
    private TermService termService;
    @Autowired
    MonthteacherclassService monthteacherclassService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("user:monthteacher:list")
    public R list(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);

        List<MonthteacherEntity> monthteacherList = monthteacherService.queryListView(query);
        int total = monthteacherService.queryTotal(query);

        // 添加每个教师的课时列表
        for (MonthteacherEntity month: monthteacherList){
            List monthTeacherHourList = monthteacherclassService.queryListByMonthteacherid(month.getMonthteacherid());
            month.setMonthteacherclassEntityList(monthTeacherHourList);
        }

        PageUtils pageUtil = new PageUtils(monthteacherList, total, query.getLimit(), query.getPage());
        return R.ok().put("page", pageUtil);
    }


    /**
     * 本月选择的班级
     */
    @RequestMapping("/termClassList/{termid}")
    public R termClassList(@PathVariable("termid") Long termid){
        // 期数下拉框
        List<MonthclassEntity> termClassList = monthclassService.queryListByTermid(termid);
        return R.ok().put("termClassList",termClassList);
    }

    /**
     * 本期班级id列表
     */
    @RequestMapping("/thisTermInfo/{termid}")
    public R thisTermInfo(@PathVariable("termid") Long termid){
        TermEntity term = termService.queryObject(termid);
        //查询角色对应的菜单
        List<MonthclassEntity> termClassList = monthclassService.queryListByTermid(termid);
        List<String> idList = new ArrayList();
        for (MonthclassEntity classTmp:termClassList){
            idList.add(""+classTmp.getClassid());
        }
        term.setThisTermClassIdList(idList);
        return R.ok().put("term", term); //.put("thisTermClassIdList", idList)
    }


    /**
     * 修改角色
     */
    @SysLog("修改本期班级")
    @RequestMapping("/updateThisTermClassIdList")
    public R updateThisTermClassIdList(@RequestBody TermEntity term){
        // ValidatorUtils.validateEntity(role);

        List<String> termClassIdList = term.getThisTermClassIdList();
        // System.out.println(termClassIdList.size());
        // 删除原关联表
        List<Long> monthclassids = new ArrayList();
        List<MonthclassEntity> monthclassEntityList = monthclassService.queryListByTermid(term.getTermid());
        for (MonthclassEntity ent : monthclassEntityList){
            monthclassids.add(ent.getMonthclassid());
        }
        Long[] monthclassids2 = monthclassids.toArray(new Long[0]);
        monthclassService.deleteBatch(monthclassids2);
        // 添加关联表
        for (String classId  :termClassIdList){
            int classidLong = Integer.parseInt(classId);
            if( classidLong<1) {continue;}
            MonthclassEntity monthclass =new MonthclassEntity();
            monthclass.setClassid(classidLong);
            monthclass.setTermid(term.getTermid().intValue());
            monthclass.setIseff(1);
            monthclassService.save(monthclass);
        }


        return R.ok();
    }




}
