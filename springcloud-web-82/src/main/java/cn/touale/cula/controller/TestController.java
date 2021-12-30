package cn.touale.cula.controller;

import cn.touale.cula.api.RemoteNewsService;
import cn.touale.cula.api.RemoteTopicService;
import cn.touale.cula.entity.News;
import cn.touale.cula.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Touale
 * @description TestController
 * @date 2021/12/30 15:36
 */


@Controller
public class TestController {
    @Autowired
    IndexService indexService;

    @RequestMapping(value = {"/index", "/"})
    public ModelAndView index(HttpServletRequest request) {
        return indexService.index(request);
    }


}
