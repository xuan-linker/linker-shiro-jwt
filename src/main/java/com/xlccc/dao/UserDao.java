package com.xlccc.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xlccc.entity.Permission;
import com.xlccc.entity.Role;
import com.xlccc.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Set;

@Mapper
public interface UserDao extends BaseMapper<User> {

    /**
     * 通过用户ID查询用户
     *
     * @param id
     * @return
     */
    List<Permission> selectPermissionByUserId(Integer id);

    Set<Role> findRoleByUserId(Integer id);

}
