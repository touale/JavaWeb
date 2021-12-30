<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
         isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<jsp:include page="index-elements/index_top.jsp"></jsp:include>
<div id="container">
    <jsp:include page="index-elements/index_sidebar.jsp"/>
    <div class="main">
        <div class="class_type">
            <img src="Images/class_type.gif" alt="新闻中心"/>
        </div>
        <div class="content">
            <ul class="class_date">
                <!--遍历 显示topic list -->
                <li id='class_month'><a href="index?tid=1"><b></b> </a> <!--遍历 显示topic list -->
            </ul>

            <ul class="classlist">
                <!-- 遍历显示 news list  -->
                <c:forEach var="news" items="${newsList}">
                    <li><a href="news_read.jsp?nid=${news.nid}"> ${news.ntitle} </a> <span>${news.ncreatedate}</span>
                    </li>
                </c:forEach>

                <!-- 遍历显示 news list  -->

                <!-- 分页显示 -->
                <p align="right">
                    当前页数:[ ${cuurentPage} / ${totalPage} ]&nbsp;&nbsp; <a
                        href="index?page_no=1">首页</a><a
                        href="index?page_no=${cuurentPage-1}">&nbsp;&nbsp;上一页</a><a
                        href="index?page_no=${cuurentPage+1}">&nbsp;&nbsp;下一页</a> <a
                        href="index?page_no=${totalPage}">&nbsp;&nbsp;末页</a>
                </p>

            </ul>
        </div>
        <jsp:include page="index-elements/index_rightbar.jsp" flush="true"/>


    </div>
</div>

<jsp:include page="index-elements/index_bottom.jsp" flush="true"/>
