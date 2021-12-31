package cn.touale.cula.controller;

import cn.touale.cula.entity.News;
import cn.touale.cula.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Touale
 * @description SysController
 * @date 2021/12/30 14:34
 */

@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @GetMapping("/test")
    public String test() {
        return "success";
    }

    @GetMapping("/getNewsList")
    public List<News> getNewsList() {
        return newsService.getNewsList();
    }

    @PostMapping("/getNewsInfoList")
    public List<News> getNewsInfoList(@RequestParam(name = "page") Integer page, @RequestParam(name = "size") Integer size, @RequestParam(name = "tid") Integer tid) {
        return newsService.getNewsInfoList(page, size, tid);
    }

    @PostMapping("/getNewsNum")
    public Integer getNewsNum(@RequestParam(name = "tid") Integer tid) {
        return newsService.getNewsNum(tid);
    }

    @PostMapping("/getNewsInfo")
    public News getNewsInfo(@RequestParam(name = "nid") Integer nid) {
        return newsService.getNewsInfo(nid);
    }

    @PostMapping("/getAllNewsNum")
    public Integer getAllNewsNum() {
        return newsService.getAllNewsNum();
    }

    @PostMapping("/getNewsInfoList_withoutTid")
    public List<News> getNewsInfoList_withoutTid(@RequestParam(name = "page") Integer page, @RequestParam(name = "size") Integer size) {
        return newsService.getNewsInfoList_withoutTid(page, size);
    }
}
