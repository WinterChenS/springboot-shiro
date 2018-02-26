package com.winterchen.model;

import com.fasterxml.jackson.databind.ser.std.SerializableSerializer;
import org.springframework.ui.Model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Donghua.Chen on 2018/2/2.
 */
public class UserDomain extends SerializableSerializer {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String nickname;
    private String email;
    private String pswd;
    private Date createTime;
    private Date lastLoginTime;
    private Long status;

    public UserDomain() {
    }

    public UserDomain(Long id, String nickname, String email, String pswd, Date createTime, Date lastLoginTime, Long status) {
        this.id = id;
        this.nickname = nickname;
        this.email = email;
        this.pswd = pswd;
        this.createTime = createTime;
        this.lastLoginTime = lastLoginTime;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }
}
