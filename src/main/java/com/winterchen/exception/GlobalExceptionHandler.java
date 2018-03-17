package com.winterchen.exception;

import com.winterchen.configuration.PropertiesListenerConfig;
import com.winterchen.mvc.APIResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 统一异常处理类
 * Created by Donghua.Chen on 2018/3/8.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    public static final String DEFAULT_ERROR_VIEW = "error";

    private static Map<String, Object> errorInfo = new ConcurrentHashMap<>();

    static {
        errorInfo.putAll(PropertiesListenerConfig.getAllProperty());
    }

    @ResponseBody
    @ExceptionHandler(value = BusinessException.class)
    public APIResponse defaultErrorHandler(HttpServletRequest request, Exception e) throws Exception{
        BusinessException businessException = (BusinessException) e;
        String message = errorInfo.get(businessException.getErrorCode()).toString();
        if (businessException.errorMessageArguments != null){
            message = message.replace("{0}","");
            for (int i = 0; i < businessException.errorMessageArguments.length; i++) {
                message += businessException.errorMessageArguments[i];
            }
        }
        return APIResponse.fail(message);
    }



}
