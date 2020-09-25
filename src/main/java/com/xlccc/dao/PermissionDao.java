package com.xlccc.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xlccc.entity.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PermissionDao extends BaseMapper<Permission> {

    @Select(" SELECT p.name,p.id\n" +
            "    FROM permission p\n" +
            "        INNER JOIN permission_role pr ON p.id=pr.permission_id\n" +
            "        INNER JOIN user_role ur ON ur.role_id=pr.role_id\n" +
            "    WHERE ur.user_id = #{id}\n;")
    List<Permission> selectPermissionByUserId(Integer id);
}
