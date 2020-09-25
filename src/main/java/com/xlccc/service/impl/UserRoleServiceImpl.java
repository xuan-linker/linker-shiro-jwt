package com.xlccc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xlccc.dao.UserRoleDao;
import com.xlccc.entity.UserRole;
import com.xlccc.service.IUserRoleService;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleDao, UserRole> implements IUserRoleService {

}
