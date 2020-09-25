package com.xlccc.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xlccc.entity.User;

import java.util.List;
import java.util.Set;

public interface IUserService extends IService<User> {
    List<String> selectPermissionByUserId(Integer id);

    User findUserByName(String userName);

    Set<String> findRoleByUserId(Integer id );
}
