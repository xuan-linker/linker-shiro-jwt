package com.xlccc.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xlccc.dao.RoleDao;
import com.xlccc.dao.UserRoleDao;
import com.xlccc.entity.Role;
import com.xlccc.entity.UserRole;
import com.xlccc.service.IRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleDao, Role> implements IRoleService {
    @Resource
    private RoleDao roleDao;
    @Resource
    private UserRoleDao userRoleDao;

    @Override
    public Set<String> findRoleByUserId(Integer id) {

        QueryWrapper<UserRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(id != null, UserRole::getUserId, id);
        List<Integer> roleList = userRoleDao.selectList(queryWrapper).stream().map(e -> {
            return e.getRoleId();
        }).collect(Collectors.toList());

        QueryWrapper<Role> queryWrapper2 = new QueryWrapper<>();
        queryWrapper2.lambda().in(Role::getId, roleList);
        Set<String> result = roleDao.selectList(queryWrapper2).stream().map(e -> {
            return e.getName();
        }).collect(Collectors.toSet());

        return result;
    }
//    @Resource
//    private RoleDao roleDao;
//
//    @Override
//    public Set<Role> findRoleByUserId(Integer id) {
//        return null;
//    }
}
