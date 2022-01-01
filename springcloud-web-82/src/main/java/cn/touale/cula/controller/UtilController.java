package cn.touale.cula.controller;

import cn.touale.cula.result.ResultDTO;
import cn.touale.cula.service.UtilService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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

    @PostMapping(value = "do_add_comment",
            produces = "application/json;charset=UTF-8")
    public ResultDTO doAddComment(@RequestParam(name = "nid") Long nid,
                                  @RequestBody JSONObject jsonParam) {
        return utilService.doAddComment(nid, jsonParam);
    }

    @PostMapping(value = "do_update_news",
            produces = "application/json;charset=UTF-8")
    public ResultDTO doUpdateNews(@RequestBody JSONObject jsonParam) {

        return utilService.doUpdateNews(jsonParam);
    }


    @PostMapping(value = "do_add_news",
            produces = "application/json;charset=UTF-8")
    public ResultDTO doAddNews(@RequestBody JSONObject jsonParam) {
        return utilService.doAddNews(jsonParam);
    }

    @PostMapping(value = "do_add_topic",
            produces = "application/json;charset=UTF-8")
    public ResultDTO doAddTopic(@RequestBody JSONObject jsonParam){
        return utilService.doAddTopic(jsonParam);
    }

    @PostMapping(value ="do_update_topic",
            produces = "application/json;charset=UTF-8")
    public ResultDTO updateTopic(@RequestBody JSONObject jsonParam){
        return utilService.doUpdateTopic(jsonParam);
    }
}
