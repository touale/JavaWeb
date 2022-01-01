package cn.touale.cula.service;

import cn.touale.cula.entity.News;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Touale
 * @description NewsService
 * @date 2021/12/30 14:08
 */
@Service
public interface NewsService {
    List<News> getNewsList();

    List<News> getNewsInfoList(Integer num, Integer size, Integer tid);

    Integer getNewsNum(Integer tid);

    News getNewsInfo(Integer nid);

    Integer getAllNewsNum();

    List<News> getNewsInfoList_withoutTid(Integer num, Integer size);

    boolean updateNewsInfo(News news);

    boolean dealNewsInfo(Long nid);

    boolean addNewsInfo(News news);

    Boolean dealNewsInfoByntid(Long ntid);
}
