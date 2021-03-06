package cn.touale.cula.service;

import cn.touale.cula.api.RemoteCommentsService;
import cn.touale.cula.api.RemoteNewsService;
import cn.touale.cula.api.RemoteTopicService;
import cn.touale.cula.entity.Comments;
import cn.touale.cula.entity.News;
import cn.touale.cula.entity.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Touale
 * @description IndexServiceImpl
 * @date 2021/12/31 2:25
 */
@Service
public class MvServiceImpl implements MvService {

    @Autowired
    private RemoteNewsService remoteNewsService;

    @Autowired
    private RemoteTopicService remoteTopicService;

    @Autowired
    private RemoteCommentsService remoteCommentsService;

    @Override
    public ModelAndView buildMv(HttpServletRequest request, String name) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName(name);
        return mv;
    }

    @Override
    public ModelAndView index(HttpServletRequest request) {
        String page_no = request.getParameter("page_no");
        String tid_no = request.getParameter("tid");

        List<Topic> topicList = remoteTopicService.getTopicList();
        Topic tempTopic = new Topic();
        tempTopic.setTid(0);
        tempTopic.setTname("全部");
        topicList.add(0,tempTopic);

        Integer page = null;
        Integer tid = null;
        Integer size = 10;
        try {
            tid = Integer.parseInt(tid_no);
        } catch (Exception e) {
            tid = 0;
        }

        Integer total = tid != 0 ? remoteNewsService.getNewsNum(tid) : remoteNewsService.getAllNewsNum();
        try {
            page = Integer.parseInt(page_no);
        } catch (Exception e) {
            page = 1;
        } finally {
            total = total % size == 0 ? total / size : total / size + 1;
            page = page < total ? page : total;
            page = page > 0 ? page : 1;
        }

        ModelAndView mv = new ModelAndView();
        mv.addObject("newsList", remoteNewsService.getNewsInfoList(page, size, tid))
                .addObject("cuurentPage", page)
                .addObject("totalPage", total)
                .addObject("topicList", topicList)
                .addObject("currentTopicId", tid);

        mv.setViewName("index");
        return mv;
    }

    @Override
    public ModelAndView newsRead(HttpServletRequest request) {

        Integer nid = Integer.parseInt(request.getParameter("nid"));
        News news = remoteNewsService.getNewsInfo(nid);
        List<Comments> commentsList = remoteCommentsService.getCommentsByNid(news.getNid());
        List<Comments> commentsListNew = new ArrayList<>();

        for (Comments comments : commentsList) {
            comments.setCcontent(
                    comments.getCcontent().replace("\n", "<br>")
            );
            commentsListNew.add(comments);
        }

        ModelAndView mv = new ModelAndView();
        Integer hasComments = commentsList.size();

        Object object = request.getSession().getAttribute("users");
        String userName = object == null ? "游客" : object.toString();

        mv.addObject("ncontent", news.getNcontent())
                .addObject("ncreatedate", news.getNcreatedate())
                .addObject("nsummary", news.getNsummary())
                .addObject("tname", remoteTopicService.getTnameByTid(news.getNtid()))
                .addObject("newsTitle", news.getNtitle())
                .addObject("nauthor", news.getNauthor())
                .addObject("tempnid", nid)
                .addObject("commentsList", commentsListNew)
                .addObject("hasComments", hasComments)
                .addObject("cip", request.getRemoteAddr())
                .addObject("currentUser", userName);

        mv.setViewName("news_read");
        return mv;
    }

    @Override
    public ModelAndView indexSidebar(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();

        mv.addObject("newsList_international", remoteNewsService.getNewsInfoList(1, 10, 2))
                .addObject("newsList_entertainment", remoteNewsService.getNewsInfoList(1, 10, 5))
                .addObject("newsList_domestic", remoteNewsService.getNewsInfoList(1, 10, 1));

        mv.setViewName("index-elements/index_sidebar");
        return mv;
    }

    @Override
    public ModelAndView newspages_admin(HttpServletRequest request) {
        String page_no = request.getParameter("page_no");

        Integer page = null;
        Integer size = 18;
        Integer total = remoteNewsService.getAllNewsNum();
        List<Topic> topicList = remoteTopicService.getTopicList();

        try {
            page = Integer.parseInt(page_no);
        } catch (Exception e) {
            page = 1;
        } finally {
            total = total % size == 0 ? total / size : total / size + 1;
            page = page < total ? page : total;
            page = page > 0 ? page : 1;
        }


        ModelAndView mv = new ModelAndView();
        mv.addObject("newsList", remoteNewsService.getNewsInfoList_withoutTid(page, size))
                .addObject("cuurentPage", page)
                .addObject("totalPage", total)
                .addObject("topicList", topicList)
                .addObject("exitId", topicList.size());

        mv.setViewName("newspages/admin");
        return mv;
    }

    @Override
    public ModelAndView newspages_news_modify(HttpServletRequest request) {
        Integer nid = Integer.parseInt(request.getParameter("nid"));
        News news = remoteNewsService.getNewsInfo(nid);
        List<Topic> topicList = remoteTopicService.getTopicList();
        List<Comments> commentsList = remoteCommentsService.getCommentsByNid(news.getNid());
        List<Comments> commentsListNew = new ArrayList<>();

        for (Comments comments : commentsList) {
            comments.setCcontent(
                    comments.getCcontent().replace("\n", "<br>")
            );
            commentsListNew.add(comments);
        }

        Integer hasComments = commentsList.size();

        ModelAndView mv = new ModelAndView();
        mv.addObject("newsInfo", news)
                .addObject("topicList", topicList)
                .addObject("commentsList", commentsList)
                .addObject("hasComments", hasComments);

        mv.setViewName("newspages/news_modify");
        return mv;
    }

    @Override
    public ModelAndView newspages_news_add(HttpServletRequest request) {
        List<Topic> topicList = remoteTopicService.getTopicList();
        ModelAndView mv = new ModelAndView();
        mv.addObject("topicList", topicList);
        mv.setViewName("newspages/news_add");
        return mv;
    }

    @Override
    public ModelAndView newspages_topic_list(HttpServletRequest request) {
        String page_no = request.getParameter("page_no");
        Integer size = 10;
        Integer page = null;

        Integer total = remoteTopicService.getTopicList().size();
        try {
            page = Integer.parseInt(page_no);
        } catch (Exception e) {
            page = 1;
        } finally {
            total = total % size == 0 ? total / size : total / size + 1;
            page = page < total ? page : total;
            page = page > 0 ? page : 1;
        }

        List<Topic> topicList = remoteTopicService.getTopicInfoList(page, size);

        ModelAndView mv = new ModelAndView();
        mv.addObject("topicList", topicList)
                .addObject("cuurentPage", page)
                .addObject("totalPage", total);
        mv.setViewName("newspages/topic_list");
        return mv;
    }

    @Override
    public ModelAndView newspages_topic_modify(HttpServletRequest request) {
        /**
         * tid=3&tname=军事
         */
        String tid = request.getParameter("tid");
        String tname = request.getParameter("tname");

        ModelAndView mv = new ModelAndView();
        mv.addObject("tid", tid)
                .addObject("tname", tname);
        mv.setViewName("newspages/topic_modify");
        return mv;
    }

}
