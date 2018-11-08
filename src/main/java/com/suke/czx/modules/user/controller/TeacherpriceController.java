package com.suke.czx.modules.user.controller;

import java.util.List;
import java.util.Map;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.suke.czx.modules.user.entity.TeacherpriceEntity;
import com.suke.czx.modules.user.service.TeacherpriceService;
import com.suke.czx.common.utils.PageUtils;
import com.suke.czx.common.utils.Query;
import com.suke.czx.common.utils.R;




/**
 * 教师
 * 
 * @author czx
 * @email object_czx@163.com
 * @date 2018-11-08 15:55:35
 */
@RestController
@RequestMapping("/user/teacherprice")
public class TeacherpriceController {
    @Autowired
    private TeacherpriceService teacherpriceService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("user:teacherprice:list")
    public R list(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);

        List<TeacherpriceEntity> teacherpriceList = teacherpriceService.queryList(query);
        int total = teacherpriceService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(teacherpriceList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{teacherid}")
    @RequiresPermissions("user:teacherprice:info")
    public R info(@PathVariable("teacherid") Long teacherid){
			TeacherpriceEntity teacherprice = teacherpriceService.queryObject(teacherid);

        return R.ok().put("teacherprice", teacherprice);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("user:teacherprice:save")
    public R save(@RequestBody TeacherpriceEntity teacherprice){
			teacherpriceService.save(teacherprice);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("user:teacherprice:update")
    public R update(@RequestBody TeacherpriceEntity teacherprice){
			teacherpriceService.update(teacherprice);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("user:teacherprice:delete")
    public R delete(@RequestBody Long[] teacherids){
			teacherpriceService.deleteBatch(teacherids);

        return R.ok();
    }
	
}
