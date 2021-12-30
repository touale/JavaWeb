package cn.touale.cula.service;

import cn.touale.cula.api.RemoteNewsService;
import cn.touale.cula.api.RemoteTopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Touale
 * @description IndexServiceImpl
 * @date 2021/12/31 2:25
 */
@Service
public class IndexServiceImpl implements IndexService{

    @Autowired
    private RemoteNewsService remoteNewsService;

    @Autowired
    private RemoteTopicService remoteTopicService;

    @Override
    public ModelAndView index(HttpServletRequest request) {
        String page_no = request.getParameter("page_no");
        String tid_no = request.getParameter("tid");

        Integer page = null;
        Integer tid = null;
        Integer size = 18;
        try {
            tid = Integer.parseInt(tid_no);
        } catch (Exception e) {
            System.out.println(e);
            tid = 1;
        }

        Integer total = remoteNewsService.getNewsNum(tid);

        try {
            page = Integer.parseInt(page_no);
        } catch (Exception e) {
            System.out.println(e);
            page = 1;
        } finally {
            total = total % size == 0 ? total / size : total / size + 1;
            page = page < total ? page : total;
            page = page > 0 ? page : 1;
        }

        ModelAndView mv = new ModelAndView();
        mv.addObject("newsList", remoteNewsService.getNewsInfoList(page, size, tid));
        mv.addObject("cuurentPage", page);
        mv.addObject("totalPage", total);
        mv.addObject("topicList", remoteTopicService.getTopicList());
        mv.addObject("currentTopicId",tid);
        mv.setViewName("index");

        return mv;
    }
}
