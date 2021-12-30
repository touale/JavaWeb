package cn.touale.cula.mapper;

import cn.touale.cula.entity.News;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Touale
 * @description NewsMapper
 * @date 2021/12/30 14:02
 */
@Mapper
public interface NewsMapper {
    List<News> getNewsList();

    List<News> getNewsInfoList(@Param("startRow") Integer startRow, @Param("endRow") Integer endRow, @Param("tid") Integer tid);

    Integer getNewsNum(@Param("tid") Integer tid);

    News getNewsInfo(@Param("nid") Integer nid);
}
