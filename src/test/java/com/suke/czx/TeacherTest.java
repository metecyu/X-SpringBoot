package com.suke.czx;


import com.suke.czx.modules.sys.entity.SysUserEntity;
import com.suke.czx.modules.sys.service.SysUserService;
import com.suke.czx.modules.user.entity.TeacherpriceEntity;
import com.suke.czx.modules.user.service.TeacherpriceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TeacherTest {
    @Autowired
    private TeacherpriceService teacherpriceService;


    @Test
    public void test(){
        TeacherpriceEntity entity= teacherpriceService.queryObject(1l);
        System.out.println(entity.getTeachername());
    }
    @Test
    public void testSave(){
        for(int i=0;i<20;i++){
            TeacherpriceEntity entity= new TeacherpriceEntity();
            entity.setTeachername("李老师");
            entity.setCreatetime(new Date());
            entity.setUpdatetime(new Date());
            teacherpriceService.save(entity);

            System.out.println(entity.getTeachername());
        }

    }

}
