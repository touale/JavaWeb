package cn.touale.cula.service;

import cn.touale.cula.entity.Comments;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Touale
 * @description CommentsService
 * @date 2021/12/31 9:39
 */

@Service
public interface CommentsService {
    List<Comments> getCommentsByNid(Long nid);

    Boolean addComment(Long cnid,String ccontent,String cip,String cauthor);
}
