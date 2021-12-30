package cn.touale.cula.controller;

import cn.touale.cula.api.RemoteNewsService;
import cn.touale.cula.entity.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Touale
 * @description TestController
 * @date 2021/12/30 15:36
 */



@RestController
public class TestController {
    @Autowired
    private RemoteNewsService service;

    @GetMapping("/1")
    public List<News> getNewsList() {
        return service.getNewsList();
    }
}
