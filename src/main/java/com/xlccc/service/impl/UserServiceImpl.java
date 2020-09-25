package com.xlccc.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xlccc.dao.PermissionDao;
import com.xlccc.dao.UserDao;
import com.xlccc.entity.Permission;
import com.xlccc.entity.Role;
import com.xlccc.entity.User;
import com.xlccc.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements IUserService {
    @Resource
    private UserDao userDao;
    @Resource
    private PermissionDao permissionDao;

    @Override
    public List<String> selectPermissionByUserId(Integer id) {
        List<Permission> permissions = permissionDao.selectPermissionByUserId(id);
        List<String> permissionResult = permissionDao.selectPermissionByUserId(id).stream().map(e -> {
            return e.getName();
        }).collect(Collectors.toList());
        return permissionResult;
    }

    @Override
    public User findUserByName(String userName) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(userName != null, User::getName, userName);
        User resultUser = userDao.selectOne(queryWrapper);
        return resultUser;
    }

    @Override
    public Set<String> findRoleByUserId(Integer id) {
        Set<Role> roleSet = userDao.findRoleByUserId(id);
        Set<String> resultRoleSet = new HashSet<>();
        roleSet.forEach(e -> {
            resultRoleSet.add(e.getName());
        });
        return resultRoleSet;
    }
}
