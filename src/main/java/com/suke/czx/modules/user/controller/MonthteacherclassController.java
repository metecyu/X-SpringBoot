package com.suke.czx.modules.user.controller;

import java.util.List;
import java.util.Map;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.suke.czx.modules.user.entity.MonthteacherclassEntity;
import com.suke.czx.modules.user.service.MonthteacherclassService;
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
@RequestMapping("/user/monthteacherclass")
public class MonthteacherclassController {
    @Autowired
    private MonthteacherclassService monthteacherclassService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("user:monthteacherclass:list")
    public R list(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);

        List<MonthteacherclassEntity> monthteacherclassList = monthteacherclassService.queryList(query);
        int total = monthteacherclassService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(monthteacherclassList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{mtmcid}")
    @RequiresPermissions("user:monthteacherclass:info")
    public R info(@PathVariable("mtmcid") Long mtmcid){
			MonthteacherclassEntity monthteacherclass = monthteacherclassService.queryObject(mtmcid);

        return R.ok().put("monthteacherclass", monthteacherclass);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("user:monthteacherclass:save")
    public R save(@RequestBody MonthteacherclassEntity monthteacherclass){
			monthteacherclassService.save(monthteacherclass);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("user:monthteacherclass:update")
    public R update(@RequestBody MonthteacherclassEntity monthteacherclass){
			monthteacherclassService.update(monthteacherclass);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("user:monthteacherclass:delete")
    public R delete(@RequestBody Long[] mtmcids){
			monthteacherclassService.deleteBatch(mtmcids);

        return R.ok();
    }
	
}
