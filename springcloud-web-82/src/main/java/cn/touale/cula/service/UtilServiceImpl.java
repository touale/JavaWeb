package cn.touale.cula.service;

import cn.touale.cula.api.RemoteCommentsService;
import cn.touale.cula.api.RemoteNewsService;
import cn.touale.cula.api.RemoteTopicService;
import cn.touale.cula.entity.News;
import cn.touale.cula.entity.Topic;
import cn.touale.cula.result.ResultDTO;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;

/**
 * @author Touale
 * @description UtilServiceImpl
 * @date 2021/12/31 13:04
 */
@Service
public class UtilServiceImpl implements UtilService {
    @Autowired
    private RemoteCommentsService remoteCommentsService;

    @Autowired
    private RemoteTopicService remoteTopicService;

    @Autowired
    private RemoteNewsService remoteNewsService;

    @Override
    public ResultDTO doAddComment(Long nid, JSONObject jsonParam) {
        String cauthor = jsonParam.getString("cauthor");
        String cip = jsonParam.getString("cip");
        String ccontent = jsonParam.getString("ccontent");
        ResultDTO resultDTO = new ResultDTO();

        if (remoteCommentsService.addComment(nid, ccontent, cip, cauthor)) {
            resultDTO.buildSucc("评论成功");
        } else {
            resultDTO.buildFail("评论失败，请重试");
        }
        return resultDTO;
    }

    @Override
    public void doDealCommentByCid(Long cid) {
        remoteCommentsService.dealCommentByCid(cid);
    }

    @Override
    public ResultDTO doUpdateNews(JSONObject jsonParam) {
        /**
         * nauthor: ""
         * ncontent: ""
         * nid: "47"
         * nsummary: ""
         * ntid: "财经"
         * ntitle: ""
         */

        Long ntid = remoteTopicService.getTidByTname(jsonParam.getString("ntid"));
        ResultDTO resultDTO = new ResultDTO();

        News news = new News();
        news.setNauthor(jsonParam.getString("nauthor"));
        news.setNcontent(jsonParam.getString("ncontent"));
        news.setNid(Long.parseLong(jsonParam.getString("nid")));
        news.setNsummary(jsonParam.getString("nsummary"));
        news.setNtid(ntid);
        news.setNtitle(jsonParam.getString("ntitle"));


        if (remoteNewsService.updateNewsInfo(news)) {
            resultDTO.buildSucc("提交成功");
        } else {
            resultDTO.buildFail("提交失败，请重试");
        }

        return resultDTO;
    }

    @Override
    public ResultDTO doAddNews(JSONObject jsonParam) {
        Long ntid = remoteTopicService.getTidByTname(jsonParam.getString("ntid"));
        ResultDTO resultDTO = new ResultDTO();

        News news = new News();
        news.setNauthor(jsonParam.getString("nauthor"));
        news.setNcontent(jsonParam.getString("ncontent"));
        news.setNsummary(jsonParam.getString("nsummary"));
        news.setNcreatedate(new Timestamp(System.currentTimeMillis()));
        news.setNtid(ntid);
        news.setNtitle(jsonParam.getString("ntitle"));

        if (remoteNewsService.addNewsInfo(news)) {
            resultDTO.buildSucc("提交成功");
        } else {
            resultDTO.buildFail("提交失败，请重试");
        }

        return resultDTO;
    }

    @Override
    public void doDealNews(Long nid) {
        remoteCommentsService.dealCommentByCnid(nid);
        remoteNewsService.dealNewsInfo(nid);
    }

    @Override
    public ResultDTO doAddTopic(JSONObject jsonParam) {
        Topic topic = new Topic();
        topic.setTname(jsonParam.getString("tname"));

        ResultDTO resultDTO = new ResultDTO();

        if (remoteTopicService.addTopic(topic)) {
            resultDTO.buildSucc("提交成功");
        } else {
            resultDTO.buildFail("提交失败，请重试");
        }

        return resultDTO;

    }

    @Override
    public void doDealTopic(Long tid) {
        remoteNewsService.dealNewsInfoByntid(tid);
        remoteTopicService.dealTopic(tid);
    }

    @Override
    public ResultDTO doUpdateTopic(JSONObject jsonParam) {

        ResultDTO resultDTO = new ResultDTO();
        Topic topic = new Topic();
        topic.setTname(jsonParam.getString("tname"));
        topic.setTid(Long.parseLong(jsonParam.getString("tid")));

        if (remoteTopicService.updateTopic(topic)) {
            resultDTO.buildSucc("提交成功");
        } else {
            resultDTO.buildFail("提交失败，请重试");
        }

        return resultDTO;
    }
}

