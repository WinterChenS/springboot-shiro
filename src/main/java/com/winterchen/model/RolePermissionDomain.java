package com.winterchen.model;

/**
 * 权限和连接关联表
 * Created by Donghua.Chen on 2018/2/5.
 */
public class RolePermissionDomain {
    private Long rid;
    private Long pid;

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }
}
