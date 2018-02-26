package com.winterchen.model;

/**
 * 用户连接
 * Created by Donghua.Chen on 2018/2/5.
 */
public class UserPermissionDomain {
    private Long id;
    private String url;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
