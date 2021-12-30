package cn.touale.cula.controller;

import cn.touale.cula.entity.Topic;
import cn.touale.cula.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Touale
 * @description TopicController
 * @date 2021/12/31 1:18
 */
@RestController
@RequestMapping("/topic")
public class TopicController {
    @Autowired
    private TopicService topicService;

    @GetMapping("/test")
    public String test(){
        return "success";
    }

    @GetMapping("/getTopicList")
    public List<Topic> getTopicList(){
        return topicService.getTopicList();
    }



}
