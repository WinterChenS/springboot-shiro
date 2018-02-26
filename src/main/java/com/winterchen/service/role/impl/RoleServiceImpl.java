package com.winterchen.service.role.impl;

import com.winterchen.dao.RoleDao;
import com.winterchen.model.RoleDomain;
import com.winterchen.service.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Donghua.Chen on 2018/2/22.
 */
@Service
public class RoleServiceImpl implements RoleService {


    @Autowired
    private RoleDao roleDao;

    @Override
    public List<RoleDomain> selectByMap(Map map) {

        return roleDao.getRoleByUserId(Long.parseLong(map.get("user_id").toString()));
    }
}
