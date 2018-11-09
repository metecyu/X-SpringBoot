package com.suke.czx.modules.user.controller;

import java.util.List;
import java.util.Map;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.suke.czx.modules.user.entity.MonthclassEntity;
import com.suke.czx.modules.user.service.MonthclassService;
import com.suke.czx.common.utils.PageUtils;
import com.suke.czx.common.utils.Query;
import com.suke.czx.common.utils.R;




/**
 * 月度班级表
 * 
 * @author czx
 * @email object_czx@163.com
 * @date 2018-11-09 15:32:07
 */
@RestController
@RequestMapping("/user/monthclass")
public class MonthclassController {
    @Autowired
    private MonthclassService monthclassService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("user:monthclass:list")
    public R list(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);

        List<MonthclassEntity> monthclassList = monthclassService.queryList(query);
        int total = monthclassService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(monthclassList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{monthclassid}")
    @RequiresPermissions("user:monthclass:info")
    public R info(@PathVariable("monthclassid") Long monthclassid){
			MonthclassEntity monthclass = monthclassService.queryObject(monthclassid);

        return R.ok().put("monthclass", monthclass);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("user:monthclass:save")
    public R save(@RequestBody MonthclassEntity monthclass){
			monthclassService.save(monthclass);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("user:monthclass:update")
    public R update(@RequestBody MonthclassEntity monthclass){
			monthclassService.update(monthclass);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("user:monthclass:delete")
    public R delete(@RequestBody Long[] monthclassids){
			monthclassService.deleteBatch(monthclassids);

        return R.ok();
    }
	
}
