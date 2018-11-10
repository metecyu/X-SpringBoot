package com.suke.czx;


import com.suke.czx.modules.user.entity.MonthteacherEntity;
import com.suke.czx.modules.user.entity.TeacherpriceEntity;
import com.suke.czx.modules.user.service.MonthteacherService;
import com.suke.czx.modules.user.service.TeacherpriceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.HashMap;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TeacherMonthTest {
    @Autowired
    private MonthteacherService monthteacherService;


    @Test
    public void test(){
        List<MonthteacherEntity> monthteacherEntities = monthteacherService.queryList(new HashMap<>());
        System.out.println(monthteacherEntities.size());

    }


}
