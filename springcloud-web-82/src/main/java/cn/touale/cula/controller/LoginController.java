package cn.touale.cula.controller;

import cn.touale.cula.result.ResultDTO;
import cn.touale.cula.service.UserService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Touale
 * @description LoginController
 * @date 2022/1/1 13:54
 */

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/doLogin", produces = "application/json;charset=UTF-8")
    public @ResponseBody
    ResultDTO doLogin(@RequestBody JSONObject jsonParam, HttpServletRequest request) {
        ResultDTO resultDTO = new ResultDTO();
        try {
            return userService.doLogin(jsonParam, request);
        } catch (Exception e) {
            // ToDo
            //Log
            resultDTO.buildFail("系统登录异常！");
        }
        return resultDTO;
    }

    @RequestMapping(value = {"/logout"})
    public String logout(HttpServletRequest request) {
        try {
            userService.doLogout(request);
        }catch (Exception e){
            // ToDo
            //Log
        }
        return "redirect:/index";
    }

}
