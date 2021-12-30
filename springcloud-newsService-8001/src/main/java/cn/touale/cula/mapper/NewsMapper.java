package cn.touale.cula.mapper;

import cn.touale.cula.entity.News;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Touale
 * @description NewsMapper
 * @date 2021/12/30 14:02
 */
@Mapper
public interface NewsMapper {
    List<News> getNewsList();
}
