package com.winterchen.dao;

import com.winterchen.model.SysPermissionInitDomain;

import java.util.List;

/**
 * Created by Donghua.Chen on 2018/2/23.
 */
public interface SysPermissionInitDao {

    /**
     * 获取所有权限连接
     * @return
     */
    List<SysPermissionInitDomain> selectAll();
}
