package com.xlccc.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Linker
 * @date 2020/9/23 21:03
 * @description：
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("role")
public class Role {

    private Integer id;
    private String name;
    @TableField(exist = false)
    private Set<com.xlccc.entity.Permission> permissions = new HashSet<>();
    @TableField(exist = false)
    private Set<com.xlccc.entity.User> users = new HashSet<>();
}
