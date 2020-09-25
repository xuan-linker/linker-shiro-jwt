package com.xlccc.controller;

import com.xlccc.exception.UnauthorizedException;
import com.xlccc.model.api.vo.ERROR;
import com.xlccc.model.api.vo.Fail;
import com.xlccc.model.api.vo.R;
import com.xlccc.model.constant.enums.CommonResponseCode;
import org.apache.shiro.ShiroException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Linker
 * @date 2020/9/25 11:00
 * @description：
 */
@RestController
public class ExceptionController {

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(ShiroException.class)
    public R handle401(ShiroException e) {
        //401
        return ERROR.fromCode(CommonResponseCode.ERROR);
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnauthorizedException.class)
    public R handle401() {
        return ERROR.ofMsgAndCode("Unauthorized", "401");
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public R globalException(HttpServletRequest request, Throwable ex) {
        return ERROR.ofMsgAndCode(ex.getMessage(), String.valueOf(getStatus(request).value()));
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }
}
