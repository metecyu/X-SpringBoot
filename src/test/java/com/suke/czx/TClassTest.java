package com.suke.czx;


import com.suke.czx.modules.sys.entity.SysMenuEntity;
import com.suke.czx.modules.user.entity.MonthclassEntity;
import com.suke.czx.modules.user.entity.TclassEntity;
import com.suke.czx.modules.user.service.MonthclassService;
import com.suke.czx.modules.user.service.TclassService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TClassTest {
    @Autowired
    private TclassService tclassService;


    @Test
    public void getExistYearList(){

        List<Integer> yearList = tclassService.getExistYearList();
        System.out.println(yearList.get(0));

    }
    @Test
    public void queryListByYearClassType(){

        List<TclassEntity> tclassEntityList = tclassService.queryListByYearClassType(2018, 11);
        System.out.println(tclassEntityList.size());

    }
    @Test
    public void getClassMenuList(){

        List<SysMenuEntity> menuList = tclassService.getClassMenuList(2018, 10);
        System.out.println(menuList.size());

    }


    


}
