package com.suke.czx.modules.user.controller;

import java.util.List;
import java.util.Map;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.suke.czx.modules.user.entity.TermEntity;
import com.suke.czx.modules.user.service.TermService;
import com.suke.czx.common.utils.PageUtils;
import com.suke.czx.common.utils.Query;
import com.suke.czx.common.utils.R;




/**
 * 期数表
 * 
 * @author czx
 * @email object_czx@163.com
 * @date 2018-11-08 15:55:35
 */
@RestController
@RequestMapping("/user/term")
public class TermController {
    @Autowired
    private TermService termService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("user:term:list")
    public R list(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);

        List<TermEntity> termList = termService.queryList(query);
        int total = termService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(termList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{termid}")
    @RequiresPermissions("user:term:info")
    public R info(@PathVariable("termid") Long termid){
			TermEntity term = termService.queryObject(termid);

        return R.ok().put("term", term);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("user:term:save")
    public R save(@RequestBody TermEntity term){
			termService.save(term);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("user:term:update")
    public R update(@RequestBody TermEntity term){
			termService.update(term);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("user:term:delete")
    public R delete(@RequestBody Long[] termids){
			termService.deleteBatch(termids);

        return R.ok();
    }
	
}
