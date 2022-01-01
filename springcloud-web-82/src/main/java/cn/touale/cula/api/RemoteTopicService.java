package cn.touale.cula.api;


import cn.touale.cula.entity.Topic;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


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

    @PostMapping("/getTidByTname")
    public Long getTidByTname(@RequestParam(name = "tname") String tname);

    @PostMapping("/addTopic")
    public boolean addTopic(@RequestBody Topic topic);

    @PostMapping("/getTopicInfoList")
    public List<Topic> getTopicInfoList(@RequestParam(name = "page") Integer page,
                                        @RequestParam(name = "size") Integer size);

    @PostMapping("/dealTopic")
    public boolean dealTopic(@RequestParam(name = "tid") Long tid);

    @PostMapping("/updateTopic")
    public boolean updateTopic(@RequestBody Topic topic);
}
