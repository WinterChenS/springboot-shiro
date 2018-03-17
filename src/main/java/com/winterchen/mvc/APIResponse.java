package com.winterchen.mvc;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.winterchen.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Donghua.Chen on 2018/3/8.
 */
public class APIResponse<T> {
    private static final Logger logger = LoggerFactory.getLogger(APIResponse.class);
    public static final String NOT_INITIALIZED = "not-initialized";
    public static final String SUCCESS = "success";
    public static final String FAIL = "fail";
    public static final String UNAUTHORIZED_SERVICE_INVOKER = "unauthorized-invoker";
    public static final String VALIDATION_FAIL = "validation-fail";
    public static final String BAD_PARAMETER = "bad-parameter";
    public static final String UNAUTHORIZED = "unauthorized";
    public static final String USER_NOT_LOGIN = "user-not-login";
    public static final String RPC_FAIL = "rpc-fail";
    protected String code;
    protected T data;
    protected String message;

    public APIResponse() {
        this("not-initialized", null, (String)null);
    }

    public APIResponse(String code) {
        this(code, null, (String)null);
    }

    public APIResponse(String code, T data) {
        this(code, data, (String)null);
    }

    public APIResponse(String code, T data, String message) {
        this.code = code;
        this.data = data;
        if(message == null) {
            this.message = ErrorTable.convertCode2LocaleMessage(code);
        } else {
            this.message = message;
        }

    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @JsonIgnore
    public boolean isSuccess() {
        return "success".equals(this.getCode());
    }

    public static <T> APIResponse<T> success(T data) {
        return new APIResponse("success", data);
    }

    public static APIResponse success() {
        return success((Object)null);
    }

    public static boolean isSuccess(APIResponse apiResponse) {
        return apiResponse == null?false:apiResponse.isSuccess();
    }

    public static APIResponse fail(String message) {
        return new APIResponse("fail", (Object)null, message);
    }

    public static APIResponse fail(Throwable t) {
        return fail(t.getMessage());
    }

    public static APIResponse widthCode(String code) {
        return new APIResponse(code);
    }

    public static <T> APIResponse<T> widthCode(String code, T data) {
        return new APIResponse(code, data);
    }

    public static APIResponse withCodeAndMessageArgs(String code, String... args) {
        APIResponse ret = widthCode(code, (Object)null);

        try {
            ret.setMessage(MessageFormat.format(ret.getMessage(), args));
        } catch (Exception var4) {
            logger.error(var4.getMessage(), var4);
        }

        return ret;
    }

    public static APIResponse<BindingResult> fail(BindingResult bindingResult) {
        Map<String, String> errorMap = new HashMap();
        Iterator var2 = bindingResult.getFieldErrors().iterator();

        while(var2.hasNext()) {
            FieldError error = (FieldError)var2.next();
            errorMap.put(error.getField(), error.getDefaultMessage());
        }

        return new APIResponse("validation-fail", errorMap);
    }

    public static APIResponse response(String code) {
        return new APIResponse(code);
    }

    public static <T> APIResponse<T> response(String code, T data) {
        return new APIResponse(code, data);
    }

    public static void assertSuccess(APIResponse apiResponse) {
        if(!isSuccess(apiResponse)) {
            throw BusinessException.fromAPIResponse(apiResponse);
        }
    }
}
