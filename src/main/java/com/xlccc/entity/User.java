package com.xlccc.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Linker
 * @date 2020/9/23 21:01
 * @description：
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@TableName("user")
public class User {

    private Integer id;
    private String name;
    private String password;
    @TableField(exist=false)
    private Set<Role> roles = new HashSet<>();

}
