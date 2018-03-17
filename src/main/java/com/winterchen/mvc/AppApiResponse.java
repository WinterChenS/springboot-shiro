package com.winterchen.mvc;

import org.springframework.http.ResponseEntity;

/**
 * 微信小程序API返回对象
 * Created by Donghua.Chen on 2018/3/15.
 */
public class AppApiResponse<T> {

    private T data;

    private Integer statusCode;

    private String header;

    public AppApiResponse(T data, Integer statusCode, String header) {
        this.data = data;
        this.statusCode = statusCode;
        this.header = header;
    }

    public AppApiResponse(Integer statusCode, String header) {
        this.statusCode = statusCode;
        this.header = header;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }
}
