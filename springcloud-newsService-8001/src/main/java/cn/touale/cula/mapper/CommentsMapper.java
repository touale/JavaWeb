package cn.touale.cula.mapper;

import cn.touale.cula.entity.Comments;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Touale
 * @description CommentsMapper
 * @date 2021/12/31 9:35
 */
@Mapper
public interface CommentsMapper {
    List<Comments> getCommentsByNid(@Param("nid") Long nid);

    Boolean addComment(Comments comment);
}
