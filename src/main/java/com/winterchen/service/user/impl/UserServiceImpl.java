package com.winterchen.service.user.impl;

import com.winterchen.dao.UserDao;
import com.winterchen.model.UserDomain;
import com.winterchen.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by Donghua.Chen on 2018/2/5.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDomain selectUserByMap(Map<String, Object> map) {


        return userDao.findUserByNickNameAndPwd(map.get("nickname").toString(),map.get("pswd").toString());
    }

    @Override
    public void updateById(UserDomain userDomain) {
        userDao.updateById(userDomain);
    }
}
