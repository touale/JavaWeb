package cn.touale.cula.interceptor;

import cn.touale.cula.api.RemoteNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Touale
 * @description WebInterreptor
 * @date 2021/12/30 23:37
 */
public class WebInterceptor implements HandlerInterceptor {

    @Autowired
    private RemoteNewsService service;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle：在进入拦截器，执行Controller之前调用");
        System.out.println("拦截"+request.getRequestURL());


        Object object = request.getSession().getAttribute("users");
        if (object == null) {
            response.sendRedirect("/login");
            return false;
        }

        //返回值为false请求原路返回，但是前台显示的200状态码，任何请求都可以成功，到这里以后不在往下，原路返回
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // System.out.println("postHandle：执行完Controller逻辑，在Controller的return ModelAndView 之前执行，可以操控ModelAndView的数据");
        //System.out.println("postHandle：修改了ModelAndView中的name值");

        System.out.println(response.getStatus());
        if (response.getStatus() == 500) {
            modelAndView.setViewName("errorpage/500");
        } else if (response.getStatus() == 404) {
            modelAndView.setViewName("errorpage/404");
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion：Controller的Return之后，Filter返回给客户端之前（应该是FilterAfter方法执行前）");

    }

}
