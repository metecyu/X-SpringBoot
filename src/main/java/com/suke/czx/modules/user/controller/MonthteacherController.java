package com.suke.czx.modules.user.controller;

import java.util.List;
import java.util.Map;
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

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("user:monthteacher:list")
    public R list(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);

        List<MonthteacherEntity> monthteacherList = monthteacherService.queryList(query);
        int total = monthteacherService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(monthteacherList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{monthteacherid}")
    @RequiresPermissions("user:monthteacher:info")
    public R info(@PathVariable("monthteacherid") Long monthteacherid){
			MonthteacherEntity monthteacher = monthteacherService.queryObject(monthteacherid);

        return R.ok().put("monthteacher", monthteacher);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("user:monthteacher:save")
    public R save(@RequestBody MonthteacherEntity monthteacher){
			monthteacherService.save(monthteacher);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("user:monthteacher:update")
    public R update(@RequestBody MonthteacherEntity monthteacher){
			monthteacherService.update(monthteacher);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("user:monthteacher:delete")
    public R delete(@RequestBody Long[] monthteacherids){
			monthteacherService.deleteBatch(monthteacherids);

        return R.ok();
    }
	
}
