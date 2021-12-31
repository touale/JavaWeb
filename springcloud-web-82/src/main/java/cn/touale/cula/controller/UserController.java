package cn.touale.cula.controller;

import cn.touale.cula.result.ResultDTO;
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

    @RequestMapping(value = {"/index-elements/index_top",})
    public ModelAndView index_top(HttpServletRequest request) {
        return userService.getLoginStatus(request,"index-elements/index_top");
    }

    @RequestMapping(value = {"/newspages/admin",})
    public ModelAndView newspages_admin(HttpServletRequest request) {
        return utilService.buildMv(request, "newspages/admin");
    }


    @RequestMapping(value = {"/login"})
    public ModelAndView login(HttpServletRequest request) {
        return utilService.buildMv(request, "login");
    }

    @RequestMapping(value = {"/logout"})
    public String logout(HttpServletRequest request) {
        userService.doLogout(request);
        return "redirect:/index";
    }

    @RequestMapping(value = {"newspages/console_element/top"})
    public ModelAndView console_element_top(HttpServletRequest request) {
        return userService.getLoginStatus(request,"newspages/console_element/top");
    }






    @PostMapping(value = "/doLogin", produces = "application/json;charset=UTF-8")
    public @ResponseBody
    ResultDTO doLogin(@RequestBody JSONObject jsonParam, HttpServletRequest request) {
        return userService.doLogin(jsonParam, request);
    }


}
