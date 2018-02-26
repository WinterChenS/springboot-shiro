package com.winterchen.dao;

import com.winterchen.model.UserPermissionDomain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Donghua.Chen on 2018/2/22.
 */
@Mapper
public interface UserPermissionDao {

    List<UserPermissionDomain> findUserPermissionByUserId(@Param("uid") Long userId);
}
