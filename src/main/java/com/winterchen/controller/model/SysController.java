package com.winterchen.controller.model;

import com.winterchen.dto.UserOnlineBo;
import com.winterchen.service.sysuser.SysUserService;
import com.winterchen.util.FrontPage;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 系统相关
 * Created by Donghua.Chen on 2018/3/5.
 */
@Controller
public class SysController {

    @Autowired
    private SysUserService sysUserService;

    @ApiOperation("获取在线用户列表")
    @GetMapping("/user-online-bos")
    public ResponseEntity getUserOnlineBos(){
        FrontPage<UserOnlineBo> page = new FrontPage<>();
        page.setPage(1);
        page.setRows(10);
        return ResponseEntity.ok(sysUserService.getPagePlus(page));
    }
}
