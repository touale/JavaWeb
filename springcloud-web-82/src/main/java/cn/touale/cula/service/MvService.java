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
public interface MvService {
    ModelAndView index(HttpServletRequest request);

    ModelAndView buildMv(HttpServletRequest request,String name);

    ModelAndView newsRead(HttpServletRequest request);

    ModelAndView newspages_admin(HttpServletRequest request);

    ModelAndView newspages_news_modify(HttpServletRequest request);

    ModelAndView newspages_news_add(HttpServletRequest request);

    ModelAndView newspages_topic_list(HttpServletRequest request);

    ModelAndView newspages_topic_modify(HttpServletRequest request);
}
