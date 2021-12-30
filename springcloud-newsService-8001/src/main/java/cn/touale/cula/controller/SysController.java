package cn.touale.cula.controller;

import cn.touale.cula.entity.News;
import cn.touale.cula.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Touale
 * @description SysController
 * @date 2021/12/30 14:34
 */

@RestController
public class SysController {

    @Autowired
    private NewsService newsService;

    @GetMapping("/test")
    public String test(){
        return "123";
    }

    @GetMapping("/getNewsList")
    public List<News> getNewsList(){
        return newsService.getNewsList();
    }

}