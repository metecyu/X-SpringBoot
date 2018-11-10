package com.suke.czx.modules.user.controller;

import java.util.List;
import java.util.Map;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.suke.czx.modules.user.entity.TclassEntity;
import com.suke.czx.modules.user.service.TclassService;
import com.suke.czx.common.utils.PageUtils;
import com.suke.czx.common.utils.Query;
import com.suke.czx.common.utils.R;




/**
 * 班级表
 * 
 * @author czx
 * @email object_czx@163.com
 * @date 2018-11-09 16:06:21
 */
@RestController
@RequestMapping("/user/tclass")
public class TclassController {
    @Autowired
    private TclassService tclassService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("user:tclass:list")
    public R list(@RequestParam Map<String, Object> params){
        System.out.println(333333445);
        //查询列表数据
        Query query = new Query(params);

        List<TclassEntity> tclassList = tclassService.queryList(query);
        int total = tclassService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(tclassList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{classid}")
    //@RequiresPermissions("user:tclass:info")
    public R info(@PathVariable("classid") Long classid){
			TclassEntity tclass = tclassService.queryObject(classid);

        return R.ok().put("tclass", tclass);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("user:tclass:save")
    public R save(@RequestBody TclassEntity tclass){
			tclassService.save(tclass);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("user:tclass:update")
    public R update(@RequestBody TclassEntity tclass){
			tclassService.update(tclass);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("user:tclass:delete")
    public R delete(@RequestBody Long[] classids){
			tclassService.deleteBatch(classids);

        return R.ok();
    }
	
}
