package com.suke.czx;


import com.suke.czx.modules.user.entity.MonthclassEntity;
import com.suke.czx.modules.user.entity.MonthteacherEntity;
import com.suke.czx.modules.user.service.MonthclassService;
import com.suke.czx.modules.user.service.MonthteacherService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MonthClassTest {
    @Autowired
    private MonthclassService onthclassService;


    @Test
    public void test(){

        List<MonthclassEntity> monthclassEntityList = onthclassService.queryListByTermid(10l);
        System.out.println(monthclassEntityList.size());

    }

    


}
