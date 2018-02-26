package com.winterchen.dao;

import com.winterchen.model.UserDomain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Donghua.Chen on 2018/2/2.
 */
@Mapper
public interface UserDao {


    UserDomain findUserByNickNameAndPwd(@Param("nickname") String nickname, @Param("pswd") String pswd);

    void updateById(UserDomain userDomain);

}
