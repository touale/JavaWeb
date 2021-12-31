package cn.touale.cula.service;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Touale
 * @description IndexService
 * @date 2021/12/31 2:24
 */
@Service
public interface IndexService {
    ModelAndView index(HttpServletRequest request);

    ModelAndView newsRead(HttpServletRequest request);
}
