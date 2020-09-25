package com.xlccc.shiro;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author Linker
 * @date 2020/9/25 12:15
 * @description：
 */
public class JWTToken implements AuthenticationToken {

    /**
     * 密匙
     */
    private String token;

    public JWTToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
