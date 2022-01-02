package cn.touale.cula.service;

import cn.touale.cula.api.RemoteUserService;
import cn.touale.cula.result.ResultDTO;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

/**
 * @author Touale
 * @description LoginServiceImpl
 * @date 2021/12/31 15:29
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private RemoteUserService remoteUserService;

    @Override
    public ResultDTO doLogin(JSONObject jsonParam, HttpServletRequest request) {

        String user = jsonParam.getString("uname");
        String pwd = jsonParam.getString("upwd");

        ResultDTO resultDTO = new ResultDTO();

        if (remoteUserService.doLogin(user, pwd)) {
            resultDTO.buildSucc("登录成功！");
            request.getSession().setAttribute("users", user);
        } else {
            resultDTO.buildFail("登录失败,请检查账号密码是否有误！");
        }
        return resultDTO;
    }

    @Override
    public ModelAndView getLoginStatus(HttpServletRequest request, String name) {
        Object object = request.getSession().getAttribute("users");
        Integer isLogin = 1;
        if (object == null) {
            object = "游客";
            isLogin = 0;
        }

        ModelAndView mv = new ModelAndView();
        mv.addObject("userName", object)
                .addObject("isLogin", isLogin);
        mv.setViewName(name);
        return mv;
    }

    @Override
    public void doLogout(HttpServletRequest request) {
        request.getSession().removeAttribute("users");
    }
}
