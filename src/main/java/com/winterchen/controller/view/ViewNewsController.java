package com.winterchen.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 博客视图控制器
 * Created by Donghua.Chen on 2018/3/25.
 */
@ApiIgnore
@Controller
@RequestMapping("/news/")
public class ViewNewsController {

    @GetMapping("/index")
    public String newsIndex(){
        return "newsIndex";
    }




}
