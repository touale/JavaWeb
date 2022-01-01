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
    private NewsMapper newsMapper;

    @Override
    public List<News> getNewsList() {
        return newsMapper.getNewsList();
    }

    @Override
    public List<News> getNewsInfoList(Integer num, Integer size, Integer tid) {
        return newsMapper.getNewsInfoList((num - 1) * size, size, tid);
    }

    @Override
    public Integer getNewsNum(Integer tid) {
        return newsMapper.getNewsNum(tid);
    }

    @Override
    public News getNewsInfo(Integer nid) {
        return newsMapper.getNewsInfo(nid);
    }

    @Override
    public Integer getAllNewsNum() {
        return newsMapper.getAllNewsNum();
    }

    @Override
    public List<News> getNewsInfoList_withoutTid(Integer num, Integer size) {
        return newsMapper.getNewsInfoList_withoutTid((num - 1) * size, size);
    }

    @Override
    public boolean updateNewsInfo(News news) {
        return newsMapper.updateNewsInfo(news);
    }

    @Override
    public boolean dealNewsInfo(Long nid) {
        return newsMapper.dealNewsInfo(nid);
    }

    @Override
    public boolean addNewsInfo(News news) {
        return newsMapper.addNewsInfo(news);
    }

    @Override
    public Boolean dealNewsInfoByntid(Long ntid) {
        return newsMapper.dealNewsInfoByntid(ntid);
    }

}
