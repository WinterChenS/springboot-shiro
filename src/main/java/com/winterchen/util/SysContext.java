package com.winterchen.util;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 系统上下文
 * Created by Donghua.Chen on 2018/3/15.
 */
public class SysContext {

    public static HttpServletRequest getReuqest(){
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }
}
