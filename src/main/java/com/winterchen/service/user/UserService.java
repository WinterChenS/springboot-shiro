package com.winterchen.service.user;

import com.winterchen.dto.UserDto;
import com.winterchen.model.UserDomain;

import java.util.List;
import java.util.Map;

/**
 * Created by Donghua.Chen on 2018/2/5.
 */
public interface UserService {

    /***
     * 根据账号密码查找用户
     * @param map
     * @return
     */
    UserDomain selectUserByMap(Map<String, Object> map);

    /**
     * 根据id更新用户信息
     * @param userDomain
     */
    void updateById(UserDomain userDomain);
}
