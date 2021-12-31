package cn.touale.cula.api;


import cn.touale.cula.entity.Topic;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

/**
 * @author Touale
 * @description RemoteTopicService
 * @date 2021/12/31 1:26
 */
@FeignClient(contextId = "RemoteTopicService", value = "NEWSSERVICE-8001")
@RequestMapping("/topic")
public interface RemoteTopicService {

    @GetMapping("/test")
    public String test();

    @GetMapping("/getTopicList")
    public List<Topic> getTopicList();

    @PostMapping("/getTnameByTid")
    public String getTnameByTid(@RequestParam(name = "tid") Long tid);
}
