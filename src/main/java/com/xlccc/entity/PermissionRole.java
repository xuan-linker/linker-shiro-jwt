package com.xlccc.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Linker
 * @date 2020/9/25 13:53
 * @description：
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("permission_role")
public class PermissionRole {
    @TableField(value = "permission_id")
    private Integer permissionId;
    @TableField(value = "role_id")
    private Integer roleId;
}
