package com.winterchen.dao;

import com.winterchen.model.RoleDomain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 角色
 * Created by Donghua.Chen on 2018/2/22.
 */
@Mapper
public interface RoleDao {

    /**
     * 根据用户的Id查找角色
     * @param uid
     * @return
     */
    List<RoleDomain> getRoleByUserId(@Param("uid") Long uid);
}
