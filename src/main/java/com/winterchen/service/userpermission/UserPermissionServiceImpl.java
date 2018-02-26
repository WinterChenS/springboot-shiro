package com.winterchen.service.userpermission;

import com.github.pagehelper.util.StringUtil;
import com.winterchen.dao.UserPermissionDao;
import com.winterchen.model.UserPermissionDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Donghua.Chen on 2018/2/22.
 */
@Service
public class UserPermissionServiceImpl implements UserPermissionService {

    @Autowired
    private UserPermissionDao permissionDao;

    @Override
    public List<UserPermissionDomain> selectByMap(Map map) {

        return permissionDao.findUserPermissionByUserId(Long.valueOf(map.get("user_id").toString()));
    }
}
