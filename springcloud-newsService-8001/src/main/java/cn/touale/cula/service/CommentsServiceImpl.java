package cn.touale.cula.service;

import cn.touale.cula.entity.Comments;
import cn.touale.cula.mapper.CommentsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.sql.Timestamp;
import java.util.List;

/**
 * @author Touale
 * @description CommentsServiceImpl
 * @date 2021/12/31 9:40
 */
@Service
public class CommentsServiceImpl implements CommentsService{
    @Autowired
    private CommentsMapper commentsMapper;

    @Override
    public List<Comments> getCommentsByNid(Long nid) {
        return commentsMapper.getCommentsByNid(nid);
    }

    @Override
    public Boolean addComment(Long cnid, String ccontent, String cip, String cauthor) {

        // 傻子，直接传entity不就行
        Comments comment = new Comments();
        comment.setCnid(cnid);
        comment.setCcontent(ccontent);
        comment.setCip(cip);
        comment.setCdate(new Timestamp(System.currentTimeMillis()));
        comment.setCauthor(cauthor);
        return commentsMapper.addComment(comment);
    }

    @Override
    public Boolean dealCommentByCnid(Long cnid) {
        return commentsMapper.dealCommentByCnid(cnid);
    }

    @Override
    public Boolean dealCommentByCid(Long cid) {
        return commentsMapper.dealCommentByCid(cid);
    }
}
