package com.suke.czx.modules.user.controller;

import java.util.List;
import java.util.Map;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.suke.czx.modules.user.entity.ClassEntity;
import com.suke.czx.modules.user.service.ClassService;
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
@RequestMapping("/user/class")
public class ClassController {
    @Autowired
    private ClassService classService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("user:class:list")
    public R list(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);

        List<ClassEntity> classList = classService.queryList(query);
        int total = classService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(classList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{classid}")
    @RequiresPermissions("user:class:info")
    public R info(@PathVariable("classid") Long classid){
			ClassEntity classObj = classService.queryObject(classid);

        return R.ok().put("class", classObj);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("user:class:save")
    public R save(@RequestBody ClassEntity classObj){
			classService.save(classObj);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("user:class:update")
    public R update(@RequestBody ClassEntity classObj){
			classService.update(classObj);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("user:class:delete")
    public R delete(@RequestBody Long[] classids){
			classService.deleteBatch(classids);

        return R.ok();
    }
	
}
