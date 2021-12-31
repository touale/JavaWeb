package cn.touale.cula.service;

import cn.touale.cula.result.ResultDTO;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Touale
 * @description loginService
 * @date 2021/12/31 15:27
 */
@Service
public interface UserService {
    ResultDTO doLogin(JSONObject jsonParam, HttpServletRequest request);
    ModelAndView getLoginStatus(HttpServletRequest request,String name);
    void doLogout(HttpServletRequest request);
}
