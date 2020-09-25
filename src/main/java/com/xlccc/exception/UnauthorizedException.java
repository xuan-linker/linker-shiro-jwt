package com.xlccc.exception;

/**
 * @author Linker
 * @date 2020/9/25 11:12
 * @description：
 */
public class UnauthorizedException extends RuntimeException {
    public UnauthorizedException() {
        super();
    }

    public UnauthorizedException(String message) {
        super(message);
    }
}
