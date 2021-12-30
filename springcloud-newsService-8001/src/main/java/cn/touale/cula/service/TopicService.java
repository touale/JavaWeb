package cn.touale.cula.service;

import cn.touale.cula.entity.Topic;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Touale
 * @description TopicService
 * @date 2021/12/31 1:19
 */
@Service
public interface TopicService {
    List<Topic> getTopicList();
}
