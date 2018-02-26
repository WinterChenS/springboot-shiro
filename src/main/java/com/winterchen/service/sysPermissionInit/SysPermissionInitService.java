package com.winterchen.service.sysPermissionInit;

import com.winterchen.model.SysPermissionInitDomain;

import java.util.List;

/**
 * Created by Donghua.Chen on 2018/2/23.
 */
public interface SysPermissionInitService {

    /**
     * 获取所有权限链接
     * @return
     */
    List<SysPermissionInitDomain> selectAll();
}
