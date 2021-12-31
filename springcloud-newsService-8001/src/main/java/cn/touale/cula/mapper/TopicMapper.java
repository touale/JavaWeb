package cn.touale.cula.mapper;

import cn.touale.cula.entity.Topic;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Touale
 * @description TopicMapper
 * @date 2021/12/31 1:15
 */
@Mapper
public interface TopicMapper {
    List<Topic> getTopicList();

    String getTnameByTid(@Param("tid") Long tid);
}