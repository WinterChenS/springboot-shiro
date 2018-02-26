package com.winterchen.service.sysPermissionInit.impl;

import com.winterchen.dao.SysPermissionInitDao;
import com.winterchen.model.SysPermissionInitDomain;
import com.winterchen.service.sysPermissionInit.SysPermissionInitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * Created by Donghua.Chen on 2018/2/23.
 */
@Service
public class SysPermissionInitServiceImpl implements SysPermissionInitService {

    @Autowired
    private SysPermissionInitDao sysPermissionInitDao;

    public List<SysPermissionInitDomain> selectAll() {
        return sysPermissionInitDao.selectAll();
    }
}
