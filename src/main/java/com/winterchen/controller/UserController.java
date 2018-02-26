package com.winterchen.controller;

import com.winterchen.model.UserDomain;
import com.winterchen.service.user.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Donghua.Chen on 2018/2/5.
 */
@Controller
public class UserController {



    @Autowired
    private UserService userService;




}
