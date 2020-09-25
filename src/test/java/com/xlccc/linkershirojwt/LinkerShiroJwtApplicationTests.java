package com.xlccc.linkershirojwt;

import com.xlccc.service.IPermissionService;
import com.xlccc.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

@SpringBootTest
class LinkerShiroJwtApplicationTests {

    @Autowired
    private IUserService userService;

    @Test
    void contextLoads() {
//        Set<String> roleSet = userService.findRoleByUserId(user.getId());
        Object o =  userService.findUserByName("admin");
        System.out.println(o.toString());

    }

    @Test
    void test1() {
        Object o = userService.selectPermissionByUserId(1);
        System.out.println(o.toString());
    }

}
