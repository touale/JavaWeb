package cn.touale.cula.service;

import cn.touale.cula.result.ResultDTO;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Touale
 * @description UtilServer
 * @date 2021/12/31 13:03
 */
@Service
public interface UtilService {
    ResultDTO doAddComment(Long nid, JSONObject jsonParam);

    ResultDTO doUpdateNews(JSONObject jsonParam);

    ResultDTO doAddNews(JSONObject jsonParam);

    void doDealNews(Long nid);

    void doDealCommentByCid(Long cid);


    ResultDTO doAddTopic(JSONObject jsonParam);

    void doDealTopic(Long tid);

    ResultDTO doUpdateTopic(JSONObject jsonParam);


}
