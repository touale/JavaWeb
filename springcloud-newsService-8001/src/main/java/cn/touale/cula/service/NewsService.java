package cn.touale.cula.service;

import cn.touale.cula.entity.News;
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

    List<News> getNewsInfoList(Integer num,Integer size);

    Integer getNewsNum();
}
