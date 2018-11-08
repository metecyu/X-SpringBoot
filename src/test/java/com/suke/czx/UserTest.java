package com.suke.czx;


import com.suke.czx.datasources.DataSourceTestService;
import com.suke.czx.modules.sys.entity.SysUserEntity;
import com.suke.czx.modules.sys.service.SysUserService;
import com.suke.czx.modules.user.entity.UserEntity;
import com.suke.czx.modules.user.service.UserService;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {
    @Autowired
    private SysUserService sysUserService;


    @Test
    public void test(){


        SysUserEntity userEntity= sysUserService.queryObject(1l);
        System.out.println(userEntity.getUsername());
    }

}
