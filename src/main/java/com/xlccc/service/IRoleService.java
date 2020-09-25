package com.xlccc.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xlccc.entity.Role;

import java.util.Set;

public interface IRoleService extends IService<Role> {
    Set<String> findRoleByUserId(Integer id);
}
