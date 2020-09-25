package com.xlccc.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Linker
 * @date 2020/9/25 13:56
 * @description：
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user_role")
public class UserRole {
    @TableField(value = "user_id")
    private Integer userId;
    @TableField(value = "role_id")
    private Integer roleId;
}
