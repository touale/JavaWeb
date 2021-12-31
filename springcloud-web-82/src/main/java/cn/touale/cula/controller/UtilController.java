package cn.touale.cula.controller;

import cn.touale.cula.result.ResultDTO;
import cn.touale.cula.service.UtilService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "do_add_comment", produces = "application/json;charset=UTF-8")
    public ResultDTO doAddComment(@RequestParam(name = "nid") Long nid,
                                  @RequestBody JSONObject jsonParam) {


        return utilService.doAddComment(nid,jsonParam);
    }


}
