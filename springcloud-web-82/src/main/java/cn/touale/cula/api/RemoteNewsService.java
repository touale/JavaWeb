package cn.touale.cula.api;

import cn.touale.cula.entity.News;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Touale
 * @description RemoteNewsService
 * @date 2021/12/30 15:32
 */

@FeignClient(contextId = "RemoteNewsService", value = "NEWSSERVICE-8001")
@RequestMapping("/news")
public interface RemoteNewsService {
    @GetMapping("/test")
    public String test();

    @GetMapping("/getNewsList")
    public List<News> getNewsList();

    @PostMapping("/getNewsInfoList")
    public List<News> getNewsInfoList(@RequestParam(name = "page") Integer page,
                                      @RequestParam(name = "size") Integer size,
                                      @RequestParam(name = "tid") Integer tid);

    @PostMapping("/getNewsNum")
    public Integer getNewsNum(@RequestParam(name = "tid") Integer tid);

    @PostMapping("/getNewsInfo")
    public News getNewsInfo(@RequestParam(name = "nid") Integer nid);

    @PostMapping("/getAllNewsNum")
    public Integer getAllNewsNum();

    @PostMapping("/getNewsInfoList_withoutTid")
    public List<News> getNewsInfoList_withoutTid(@RequestParam(name = "page") Integer page,
                                                 @RequestParam(name = "size") Integer size);

    @PostMapping("/updateNewsInfo")
    public Boolean updateNewsInfo(@RequestBody News news);

    @PostMapping("/dealNewsInfo")
    public boolean dealNewsInfo(@RequestParam(name = "nid") Long nid);

    @PostMapping("/addNewsInfo")
    public boolean addNewsInfo(@RequestBody News news);

    @PostMapping("/dealNewsInfoByntid")
    public boolean dealNewsInfoByntid(@RequestParam(name = "ntid") Long ntid);


}
