package cn.touale.cula.api;

import cn.touale.cula.entity.Comments;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author Touale
 * @description RemoteCommentsService
 * @date 2021/12/31 9:44
 */

@FeignClient(contextId = "RemoteCommentsService", value = "NEWSSERVICE-8001")
@RequestMapping("/comments")
public interface RemoteCommentsService {
    @PostMapping("/getCommentsByNid")
    public List<Comments> getCommentsByNid(@RequestParam(name = "nid") Long nid);

    @PostMapping("/addComment")
    public boolean addComment(@RequestParam(name = "cnid") Long cnid,
                              @RequestParam(name = "ccontent") String ccontent,
                              @RequestParam(name = "cip") String cip,
                              @RequestParam(name = "cauthor") String cauthor);

    @PostMapping("/dealCommentByCnid")
    public Boolean dealCommentByCnid(@RequestParam(name = "cnid") Long cnid);

    @PostMapping("/dealCommentByCid")
    public Boolean dealCommentByCid(@RequestParam(name = "cid") Long cid);
}
