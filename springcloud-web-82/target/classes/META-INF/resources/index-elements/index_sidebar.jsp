<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="sidebar">
    <h1><img src="Images/title_1.gif" alt="国内新闻"/></h1>
    <div class="side_list">
        <ul>
            <!-- 国内新闻 -->
            <c:forEach var="news" items="${newsList_domestic}">
                <li style="overflow: hidden;white-space: nowrap;text-overflow: ellipsis;"><a
                        href='news_read?nid=${news.nid}'>&nbsp;&nbsp;${news.ntitle}</b></a></li>
            </c:forEach>
            <!-- 国内新闻 -->
        </ul>
    </div>
    <h1><img src="Images/title_2.gif" alt="国际新闻"/></h1>
    <div class="side_list">

        <!-- 国际新闻 -->
        <c:forEach var="news" items="${newsList_international}">
            <li style="overflow: hidden;white-space: nowrap;text-overflow: ellipsis;"><a
                    href='news_read?nid=${news.nid}'>&nbsp;&nbsp;${news.ntitle}</b></a></li>
        </c:forEach>


        <!-- 国际新闻 -->

        </ul>
    </div>
    <h1><img src="Images/title_3.gif" alt="娱乐新闻"/></h1>
    <div class="side_list">
        <ul>
            <!-- 娱乐新闻 -->
            <c:forEach var="news" items="${newsList_entertainment}">
                <li style="overflow: hidden;white-space: nowrap;text-overflow: ellipsis;"><a
                        href='news_read?nid=${news.nid}'>&nbsp;&nbsp;${news.ntitle}</b></a></li>
            </c:forEach>
            <!-- 娱乐新闻 -->
        </ul>
    </div>
</div>

