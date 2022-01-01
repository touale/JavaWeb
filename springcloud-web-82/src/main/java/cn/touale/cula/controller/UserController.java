package cn.touale.cula.controller;

import cn.touale.cula.result.ResultDTO;
import cn.touale.cula.service.IndexService;
import cn.touale.cula.service.UserService;
import cn.touale.cula.service.UtilService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Touale
 * @description loginController
 * @date 2021/12/31 14:39
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UtilService utilService;

    @Autowired
    private IndexService indexService;

    @RequestMapping(value = {"/index-elements/index_top",})
    public ModelAndView index_top(HttpServletRequest request) {
        return userService.getLoginStatus(request, "index-elements/index_top");
    }

    @RequestMapping(value = {"/newspages/admin",})
    public ModelAndView newspages_admin(HttpServletRequest request) {
        return indexService.newspages_admin(request);
    }


    @RequestMapping(value = {"/login"})
    public ModelAndView login(HttpServletRequest request) {
        return indexService.buildMv(request, "login");
    }

    @RequestMapping(value = {"/logout"})
    public String logout(HttpServletRequest request) {
        userService.doLogout(request);
        return "redirect:/index";
    }

    @RequestMapping(value = {"newspages/console_element/top"})
    public ModelAndView console_element_top(HttpServletRequest request) {
        return userService.getLoginStatus(request, "newspages/console_element/top");
    }

    @RequestMapping(value = {"newspages/news_modify"})
    public ModelAndView newspages_news_modify(HttpServletRequest request) {
        return indexService.newspages_news_modify(request);
    }

    @RequestMapping(value = {"newspages/news_add"})
    public ModelAndView newspages_news_add(HttpServletRequest request) {
        return indexService.newspages_news_add(request);
    }


    @GetMapping(value = "util/do_delete_news")
    public String doDeleteNews(@RequestParam(name = "nid") Long nid) {
        utilService.doDealNews(nid);
        return "redirect:/newspages/admin";
    }

    @GetMapping(value = "util/do_delete_comments")
    public String doDeleteComments(@RequestParam(name = "cid") Long cid,
                                   @RequestParam(name = "cnid") Long cnid) {
        utilService.doDealCommentByCid(cid);
        return "redirect:/newspages/news_modify?nid=" + cnid;
    }

    @GetMapping(value = "util/do_delete_topics")
    public String doDeleteTopics(@RequestParam(name = "tid") Long tid,
                                 @RequestParam(name = "page_no") Integer page_no) {
        utilService.doDealTopic(tid);
        return "redirect:/newspages/topic_list?page_no="+page_no;
    }

    @GetMapping(value = "newspages/topic_add")
    public ModelAndView doDeleteTopic(HttpServletRequest request) {
        return indexService.buildMv(request, "newspages/topic_add");
    }

    @GetMapping(value = "newspages/topic_list")
    public ModelAndView newspages_topic_list(HttpServletRequest request) {
        return indexService.newspages_topic_list(request);
    }

    @GetMapping(value ="newspages/topic_modify")
    public ModelAndView newspages_topic_modify(HttpServletRequest request) {
        return indexService.newspages_topic_modify(request);
    }

    @PostMapping(value = "/doLogin", produces = "application/json;charset=UTF-8")
    public @ResponseBody
    ResultDTO doLogin(@RequestBody JSONObject jsonParam, HttpServletRequest request) {
        return userService.doLogin(jsonParam, request);
    }


}
