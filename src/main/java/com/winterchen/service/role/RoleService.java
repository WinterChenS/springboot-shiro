package com.winterchen.service.role;

import com.winterchen.model.RoleDomain;

import java.util.List;
import java.util.Map;

/**
 * Created by Donghua.Chen on 2018/2/22.
 */
public interface RoleService {

    /***
     * 根据用户id查找用户角色
     * @param map
     * @return
     */
    List<RoleDomain> selectByMap(Map map);
}
