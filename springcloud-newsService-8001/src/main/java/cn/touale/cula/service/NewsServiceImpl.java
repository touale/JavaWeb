package cn.touale.cula.service;

import cn.touale.cula.entity.News;
import cn.touale.cula.mapper.NewsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Touale
 * @description NewsServiceImpl
 * @date 2021/12/30 14:10
 */
@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    NewsMapper newsMapper;

    @Override
    public List<News> getNewsList() {
        return newsMapper.getNewsList();
    }

    @Override
    public List<News> getNewsInfoList(Integer num, Integer size) {
        return newsMapper.getNewsInfoList((num - 1) * size, size);
    }

    @Override
    public Integer getNewsNum() {
        return newsMapper.getNewsNum();
    }
}
