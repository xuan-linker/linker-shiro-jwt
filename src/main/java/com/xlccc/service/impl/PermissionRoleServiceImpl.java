package com.xlccc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xlccc.dao.PermissionRoleDao;
import com.xlccc.entity.PermissionRole;
import com.xlccc.service.IPermissionRoleService;
import org.springframework.stereotype.Service;

@Service
public class PermissionRoleServiceImpl extends ServiceImpl<PermissionRoleDao, PermissionRole> implements IPermissionRoleService {
}
