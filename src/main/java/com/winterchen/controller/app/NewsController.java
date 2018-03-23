package com.winterchen.controller.app;

import com.winterchen.model.NewsDomain;
import com.winterchen.mvc.APIResponse;
import com.winterchen.service.news.NewsService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Donghua.Chen on 2018/3/20.
 */
@RestController
@RequestMapping(value = "/api/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @ApiOperation("获取新闻列表")
    @GetMapping("/")
    public APIResponse<List<NewsDomain>> news(
            @ApiParam(name = "pageNum", value = "开始页数", required = false, defaultValue = "1")
            @RequestParam(name = "pageNum", required = false, defaultValue = "1")
            int pageNum,
            @ApiParam(name = "pageSize", value = "每页数量", required = false, defaultValue = "10")
            @RequestParam(name = "pageSize", required = false, defaultValue = "10")
            int pageSize
    ){
        return APIResponse.success(newsService.getNews(pageNum, pageSize));
    }

    @ApiOperation("获取一个新闻的信息")
    @GetMapping("/{id}")
    public APIResponse<NewsDomain> oneNew(
            @ApiParam(name = "id", value = "新闻主键", required = true)
            @PathVariable(name = "id")
            Integer id
    ){
        return APIResponse.success(newsService.getNewById(id));
    }




}
