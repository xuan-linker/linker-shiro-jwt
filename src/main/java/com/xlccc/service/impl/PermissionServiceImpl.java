package com.xlccc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xlccc.dao.PermissionDao;
import com.xlccc.entity.Permission;
import com.xlccc.entity.PermissionRole;
import com.xlccc.service.IPermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Set;

@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionDao, Permission> implements IPermissionService {
//    @Resource
//    private PermissionDao permissionDao;
//    @Resource
//    private PermissionRole permissionRole;
//
//    @Override
//    public Set<String> findPermissionByUserId(Integer id) {
//        return null;
//    }
}
