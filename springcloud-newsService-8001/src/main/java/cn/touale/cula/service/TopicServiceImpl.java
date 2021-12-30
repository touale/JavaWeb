package cn.touale.cula.service;

import cn.touale.cula.entity.Topic;
import cn.touale.cula.mapper.TopicMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Touale
 * @description TopicServiceImpl
 * @date 2021/12/31 1:19
 */
@Service
public class TopicServiceImpl implements TopicService{
    @Autowired
    private TopicMapper topicMapper;

    @Override
    public List<Topic> getTopicList() {
        return topicMapper.getTopicList();
    }
}
