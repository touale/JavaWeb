package cn.touale.cula.controller;

import cn.touale.cula.entity.Comments;
import cn.touale.cula.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Touale
 * @description CommentsController
 * @date 2021/12/31 9:42
 */
@RestController
@RequestMapping("/comments")
public class CommentsController {
    @Autowired
    private CommentsService commentsService;

    @PostMapping("/getCommentsByNid")
    public List<Comments> getCommentsByNid(@RequestParam(name = "nid") Long nid) {
        return commentsService.getCommentsByNid(nid);
    }

    @PostMapping("/addComment")
    public boolean addComment(@RequestParam(name = "cnid") Long cnid,
                              @RequestParam(name = "ccontent") String ccontent,
                              @RequestParam(name = "cip") String cip,
                              @RequestParam(name = "cauthor") String cauthor) {
        return commentsService.addComment(cnid, ccontent, cip, cauthor);
    }

    @PostMapping("/dealCommentByCnid")
    public Boolean dealCommentByCnid(@RequestParam(name = "cnid") Long cnid) {
        return commentsService.dealCommentByCnid(cnid);
    }

    @PostMapping("/dealCommentByCid")
    public Boolean dealCommentByCid(@RequestParam(name = "cid") Long cid) {
        return commentsService.dealCommentByCid(cid);
    }


}
