package com.winterchen.controller.model;

import com.winterchen.vcode.Captcha;
import com.winterchen.vcode.GifCaptcha;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * shiro权限控制登录Controller
 * Created by Donghua.Chen on 2018/2/23.
 */
@Controller
public class LoginController {

    Logger logger = Logger.getLogger(LoginController.class);


    @GetMapping("login")
    public String login(){
        return "login";
    }


    @ApiOperation("用户登录")
    @PostMapping("/ajaxLogin")
    public String submitLogin(
            @ApiParam(name = "username", value = "用户名", required = true)
            @RequestParam(name = "username", required = true)
            String username,
            @ApiParam(name = "password", value = "登录密码", required = true)
            @RequestParam(name = "password", required = true)
            String password,
            @ApiParam(name = "vcode", value = "验证码", required = true)
            @RequestParam(name = "vcode", required = true)
            String vcode,
            @ApiParam(name = "rememberMe", value = "是否记住当前登录状态",defaultValue = "false")
            @RequestParam(name = "rememberMe", defaultValue = "false")
            Boolean rememberMe,
            Model model
    ){
        try{
            if (null == vcode || "".equals(vcode)){
                model.addAttribute("status", 500);
                model.addAttribute("error", "验证码不能为空");
                return "login";
            }
            Session session = SecurityUtils.getSubject().getSession();
            vcode = vcode.toLowerCase();
            String v = (String) session.getAttribute("_code");
            //还可以读取一次后把验证码清空，这样每次登录都必须获取验证码
            //session.removeAttribute("_come");
            if(!vcode.equals(v)){
                model.addAttribute("status", 500);
                model.addAttribute("message", "验证码错误！");
                return "login";
            }
            UsernamePasswordToken token = new UsernamePasswordToken(username, password, rememberMe);
            SecurityUtils.getSubject().login(token);
            model.addAttribute("result","登录成功");
            return "index";
        }catch (Exception e){
            logger.error("登录失败", e);
            Map<String, Object> map = new HashMap();
            map.put("error", e.getMessage());
            model.addAttribute("error", e.getMessage());

            return "login";
        }

    }

    @ApiOperation("获取验证码")
    @GetMapping("/getGifCode")
    public void getGifCode(HttpServletResponse response, HttpServletRequest request){
        try {
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            response.setContentType("image/gif");
            /**
             * gif格式动画验证码
             * 宽，高，位数。
             */
            Captcha captcha = new GifCaptcha(146,33,4);
            //输出
            captcha.out(response.getOutputStream());
            HttpSession session = request.getSession(true);
            //存入Session
            session.setAttribute("_code",captcha.text().toLowerCase());
        } catch (Exception e) {
            System.err.println("获取验证码异常："+e.getMessage());
        }

    }

    @GetMapping("kickout")
    public String getKickoutPage(){
        return "kickout";
    }

    @GetMapping("/user")
    public String getUserPage(){
        return "register";
    }
}
