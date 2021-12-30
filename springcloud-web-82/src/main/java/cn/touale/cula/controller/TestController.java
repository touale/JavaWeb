package cn.touale.cula.controller;

import cn.touale.cula.api.RemoteNewsService;
import cn.touale.cula.entity.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    private RemoteNewsService service;

    @RequestMapping(value = {"/index","/"})
    public ModelAndView index(HttpServletRequest request) {
        String page_no = request.getParameter("page_no");

        System.out.println("---------------" + page_no);
        Integer page = null;
        Integer size = 18;
        Integer total = service.getNewsNum();

        try {
            page = Integer.parseInt(page_no);
        } catch (Exception e) {
            System.out.println(e);
            page = 1;
        } finally {
            total = total % size == 0 ? total / size : total / size + 1;
            page = page > 0 ? page : 1;
            page = page < total ? page : total;
        }


        ModelAndView mv = new ModelAndView();
        mv.addObject("newsList", service.getNewsInfoList(page, size));
        mv.addObject("cuurentPage", page);
        mv.addObject("totalPage", total);
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping(value = "/test")
    public @ResponseBody
    List<News> speak() {
        return service.getNewsList();
    }


}
