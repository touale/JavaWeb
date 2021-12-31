package cn.touale.cula.service;

import cn.touale.cula.api.RemoteCommentsService;
import cn.touale.cula.result.ResultDTO;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Touale
 * @description UtilServiceImpl
 * @date 2021/12/31 13:04
 */
@Service
public class UtilServiceImpl implements UtilService {
    @Autowired
    private RemoteCommentsService remoteCommentsService;

    @Override
    public ResultDTO doAddComment(Long nid, JSONObject jsonParam) {
        String cauthor = jsonParam.getString("cauthor");
        String cip = jsonParam.getString("cip");
        String ccontent = jsonParam.getString("ccontent");
        ResultDTO resultDTO = new ResultDTO();

        if (remoteCommentsService.addComment(nid, ccontent, cip, cauthor)) {
            resultDTO.buildSucc("评论成功");
        } else {
            resultDTO.buildFail("评论失败，请重试");
        }
        return resultDTO;
    }

    @Override
    public ModelAndView buildMv(HttpServletRequest request,String name) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName(name);
        return mv;
    }

}

