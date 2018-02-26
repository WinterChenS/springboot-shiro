package com.winterchen.service.userpermission;

import com.winterchen.model.UserPermissionDomain;

import java.util.List;
import java.util.Map;

/**
 * 用户权限
 * Created by Donghua.Chen on 2018/2/22.
 */
public interface UserPermissionService {

    /**
     * 根据用户id查找相关的权限
     * @param map
     * @return
     */
    List<UserPermissionDomain> selectByMap(Map map);

}
