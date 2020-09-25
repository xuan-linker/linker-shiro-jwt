package com.xlccc.controller;

import com.xlccc.entity.User;
import com.xlccc.exception.UnauthorizedException;
import com.xlccc.model.api.vo.OK;
import com.xlccc.model.api.vo.R;
import com.xlccc.service.IUserService;
import com.xlccc.utils.JWTUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Linker
 * @date 2020/9/25 11:19
 * @description：
 */
@Slf4j
@RestController
public class TestController {

    private IUserService userService;

    @Autowired
    public TestController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public R login(@RequestParam("username") String username,
                   @RequestParam("password") String password) {
        User user = userService.findUserByName(username);
        if (user.getPassword().equals(password)) {
            return OK.data(JWTUtil.sign(username, password));
        } else {
            throw new UnauthorizedException();
        }
    }

    @GetMapping("/article")
    public R article() {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            return OK.data("You are already logged in");
        } else {
            return OK.data("You are guest");
        }
    }

    @GetMapping("/require_auth")
    @RequiresAuthentication
    public R requireAuth() {
        return OK.data("You are authenticated");
    }

    @GetMapping("/require_role")
    @RequiresRoles("admin")
    public R requireRole() {
        return OK.data("You are visiting require_role");
    }

    @GetMapping("/require_permission")
    @RequiresPermissions(logical = Logical.AND, value = {"view", "edit"})
    public R requirePermission() {
        return OK.data("You are visiting permission require edit,view");
    }

    @RequestMapping(path = "/401")
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public R unauthorized() {
        return OK.data("Unauthorized");
    }


    @PostMapping("/hello")
    public R test() {
        List<String> result = userService.selectPermissionByUserId(1);
        return OK.data(result);
    }
}
