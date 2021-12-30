package cn.touale.cula.api;

import cn.touale.cula.entity.News;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author Touale
 * @description RemoteNewsService
 * @date 2021/12/30 15:32
 */

@FeignClient(contextId = "NEWSSERVICE-8001", value = "NEWSSERVICE-8001")
public interface RemoteNewsService {
    @GetMapping("/test")
    public String test();

    @GetMapping("/getNewsList")
    public List<News> getNewsList();
}
