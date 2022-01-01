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
public class TopicServiceImpl implements TopicService {
    @Autowired
    private TopicMapper topicMapper;

    @Override
    public List<Topic> getTopicList() {
        return topicMapper.getTopicList();
    }

    @Override
    public String getTnameByTid(Long tid) {
        return topicMapper.getTnameByTid(tid);
    }

    @Override
    public Long getTidByTname(String tname) {
        return topicMapper.getTidByTname(tname);
    }

    @Override
    public boolean addTopic(Topic topic) {
        return topicMapper.addTopic(topic);
    }

    @Override
    public List<Topic> getTopicInfoList(Integer num, Integer size) {
        return topicMapper.getTopicInfoList((num - 1) * size, size);
    }

    @Override
    public boolean dealTopic(Long tid) {
        return topicMapper.dealTopic(tid);
    }

    @Override
    public boolean updateTopic(Topic topic) {
        return topicMapper.updateTopic(topic);
    }
}
