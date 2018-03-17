package com.winterchen.controller.app;

import com.winterchen.controller.view.LoginController;
import com.winterchen.mvc.APIResponse;
import com.winterchen.mvc.AppApiResponse;
import com.winterchen.service.sysuser.SysUserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 小程序登录API
 * Created by Donghua.Chen on 2018/3/15.
 */
@RestController
public class AppLoginController {

    @Autowired
    private SysUserService sysUserService;


    Logger logger = Logger.getLogger(LoginController.class);

    @ApiOperation("用户登录")
    @GetMapping("/api/ajaxLogin")
    public APIResponse submitLogin(
            @ApiParam(name = "username", value = "用户名", required = true)
            @RequestParam(name = "username", required = true)
                    String username,
            @ApiParam(name = "password", value = "登录密码", required = true)
            @RequestParam(name = "password", required = true)
                    String password,
            HttpServletRequest request
    ){
        try{
            UsernamePasswordToken token = new UsernamePasswordToken(username, password, false);
            SecurityUtils.getSubject().login(token);
            Object user =  SecurityUtils.getSubject().getPrincipal();
            return APIResponse.success(user);
        }catch (Exception e){
            logger.error("登录失败", e);
            return APIResponse.fail(e.getMessage());
        }

    }
}
