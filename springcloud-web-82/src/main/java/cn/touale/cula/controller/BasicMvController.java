package cn.touale.cula.controller;

import cn.touale.cula.service.MvService;
import cn.touale.cula.service.UserService;
import cn.touale.cula.service.UtilService;
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
public class BasicMvController {
    @Autowired
    private UserService userService;

    @Autowired
    private UtilService utilService;

    @Autowired
    private MvService mvService;

    @RequestMapping(value = {"/index", "/"})
    public ModelAndView index(HttpServletRequest request) {
        try {
            return mvService.index(request);
        } catch (Exception e) {
            return mvService.buildMv(request, "index");
        }
    }

    @RequestMapping(value = {"/news_read"})
    public ModelAndView newsRead(HttpServletRequest request) {
        // 此处异常直接 404 即可
        return mvService.newsRead(request);
    }

    @RequestMapping(value = {"/index-elements/index_top",})
    public ModelAndView index_top(HttpServletRequest request) {
        try {
            return userService.getLoginStatus(request, "index-elements/index_top");
        } catch (Exception e) {
            return mvService.buildMv(request, "index-elements/index_top");
        }
    }

    @RequestMapping(value = {"/newspages/admin",})
    public ModelAndView newspages_admin(HttpServletRequest request) {
        try {
            return mvService.newspages_admin(request);
        } catch (
                Exception e) {
            return mvService.buildMv(request, "newspages/admin");
        }
    }

    @RequestMapping(value = {"/login"})
    public ModelAndView login(HttpServletRequest request) {
        return mvService.buildMv(request, "login");
    }

    @RequestMapping(value = {"newspages/console_element/top"})
    public ModelAndView console_element_top(HttpServletRequest request) {
        try {
            return userService.getLoginStatus(request, "newspages/console_element/top");
        } catch (Exception e) {
            return mvService.buildMv(request, "newspages/console_element/top");
        }
    }

    @RequestMapping(value = {"newspages/news_modify"})
    public ModelAndView newspages_news_modify(HttpServletRequest request) {
        try {
            return mvService.newspages_news_modify(request);
        } catch (Exception e) {
            return mvService.buildMv(request, "newspages/news_modify");
        }
    }

    @RequestMapping(value = {"newspages/news_add"})
    public ModelAndView newspages_news_add(HttpServletRequest request) {
        try {
            return mvService.newspages_news_add(request);
        } catch (Exception e) {
            return mvService.buildMv(request, "newspages/news_add");
        }
    }

    @GetMapping(value = "util/do_delete_news")
    public String doDeleteNews(@RequestParam(name = "nid") Long nid) {
        try {
            utilService.doDealNews(nid);
        } catch (Exception e) {
            // ToDo
        }
        return "redirect:/newspages/admin";
    }

    @GetMapping(value = "util/do_delete_comments")
    public String doDeleteComments(@RequestParam(name = "cid") Long cid,
                                   @RequestParam(name = "cnid") Long cnid) {
        try {
            utilService.doDealCommentByCid(cid);
        } catch (Exception e) {
            // ToDo
        }
        return "redirect:/newspages/news_modify?nid=" + cnid;
    }

    @GetMapping(value = "util/do_delete_topics")
    public String doDeleteTopics(@RequestParam(name = "tid") Long tid,
                                 @RequestParam(name = "page_no") Integer page_no) {
        try {
            utilService.doDealTopic(tid);
        } catch (Exception e) {
            // ToDo
        }
        return "redirect:/newspages/topic_list?page_no=" + page_no;
    }

    @GetMapping(value = "newspages/topic_add")
    public ModelAndView doDeleteTopic(HttpServletRequest request) {
        return mvService.buildMv(request, "newspages/topic_add");
    }

    @GetMapping(value = "newspages/topic_list")
    public ModelAndView newspages_topic_list(HttpServletRequest request) {
        try {
            return mvService.newspages_topic_list(request);
        } catch (Exception e) {
            // ToDo
            return mvService.buildMv(request, "newspages/topic_list");
        }
    }

    @GetMapping(value = "newspages/topic_modify")
    public ModelAndView newspages_topic_modify(HttpServletRequest request) {
        try {
            return mvService.newspages_topic_modify(request);
        } catch (Exception e) {
            // ToDo
            return mvService.buildMv(request, "newspages/topic_modify");
        }
    }

}
