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
    //@RequiresPermissions("user:monthteacher:list")
    public R list(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);

        List<MonthteacherEntity> monthteacherList = monthteacherService.queryList(query);
        int total = monthteacherService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(monthteacherList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }



	
}
