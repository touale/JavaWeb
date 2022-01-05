package cn.touale.cula.controller;

import cn.touale.cula.result.ResultDTO;
import cn.touale.cula.service.UserService;
import cn.touale.cula.service.UtilService;
import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Touale
 * @description UtilController
 * @date 2021/12/31 11:23
 */
@RestController
@RequestMapping("/util")
public class UtilController {

    @Autowired
    private UtilService utilService;

    @Autowired
    private UserService userService;

    Logger logger = Logger.getLogger(UtilController.class);

    @PostMapping(value = "do_add_comment",
            produces = "application/json;charset=UTF-8")
    public ResultDTO doAddComment(@RequestParam(name = "nid") Long nid,
                                  @RequestBody JSONObject jsonParam) {
        logger.info("jsonParam: " + jsonParam.toString());
        ResultDTO resultDTO = new ResultDTO();
        try {
            return utilService.doAddComment(nid, jsonParam);
        } catch (Exception e) {
            logger.error("评论异常", e);
            resultDTO.buildFail("评论异常！");
        }
        return resultDTO;
    }


    @PostMapping(value = "do_update_news",
            produces = "application/json;charset=UTF-8")
    public ResultDTO doUpdateNews(@RequestBody JSONObject jsonParam) {
        logger.info("jsonParam: " + jsonParam.toString());
        ResultDTO resultDTO = new ResultDTO();
        try {
            return utilService.doUpdateNews(jsonParam);
        } catch (Exception e) {
            logger.error("编辑新闻异常", e);
            resultDTO.buildFail("编辑新闻异常！");
        }
        return resultDTO;
    }

    @PostMapping(value = "do_add_news",
            produces = "application/json;charset=UTF-8")
    public ResultDTO doAddNews(@RequestBody JSONObject jsonParam) {
        logger.info("jsonParam: " + jsonParam.toString());
        ResultDTO resultDTO = new ResultDTO();
        try {
            return utilService.doAddNews(jsonParam);
        } catch (Exception e) {
            logger.error("添加新闻异常", e);
            resultDTO.buildFail("添加新闻异常！");
        }
        return resultDTO;
    }

    @PostMapping(value = "do_add_topic",
            produces = "application/json;charset=UTF-8")
    public ResultDTO doAddTopic(@RequestBody JSONObject jsonParam) {
        logger.info("jsonParam: " + jsonParam.toString());
        ResultDTO resultDTO = new ResultDTO();
        try {
            return utilService.doAddTopic(jsonParam);
        } catch (Exception e) {
            logger.error("添加主题异常", e);
            resultDTO.buildFail("添加主题异常！");
        }
        return resultDTO;
    }

    @PostMapping(value = "do_update_topic",
            produces = "application/json;charset=UTF-8")
    public ResultDTO updateTopic(@RequestBody JSONObject jsonParam) {
        logger.info("jsonParam: " + jsonParam.toString());
        ResultDTO resultDTO = new ResultDTO();
        try {
            return utilService.doUpdateTopic(jsonParam);
        } catch (Exception e) {
            logger.error("更新主题异常", e);
            resultDTO.buildFail("更新主题异常！");
        }
        return resultDTO;
    }

}
