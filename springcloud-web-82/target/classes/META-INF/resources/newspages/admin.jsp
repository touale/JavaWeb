<%@ page language="java" import="java.util.*,java.sql.*"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<jsp:include page="console_element/top"/>
<script language="javascript">
    function clickdel() {
        return confirm("删除请点击确认");
    }
</script>


<div id="main">
    <jsp:include page="console_element/left.jsp"/>
    <div id="opt_area">
        <ul class="classlist">


            <c:forEach var="news" items="${newsList}">
                <c:forEach var="topic" items="${topicList}" end="${exitId}">
                    <c:if test="${topic.tid == news.ntid}">
                        <!-- 遍历 news list -->
                        <li class='space'><strong>${topic.tname}</strong></li>
                        <li>${news.ntitle}<span> 作者： ${news.nauthor}&#160;&#160;&#160;&#160; <a
                                href='news_modify?nid=${news.nid}'>修改</a> &#160;&#160;&#160;&#160; <a
                                href='../util/do_delete_news?nid=${news.nid}'
                                onclick='return clickdel()'>删除</a>



			</span>
                        </li>
                        <!-- 遍历 news list -->

                        <c:set var="exitID" value="0"></c:set>
                    </c:if>


                </c:forEach>
            </c:forEach>


            <!-- 分页处理 -->
            <p align="right">
                当前页数:[ ${cuurentPage} / ${totalPage} ]&nbsp;&nbsp; <a
                <a href="admin?page_no=1">首页</a><a
                    href="admin?page_no=${cuurentPage-1}">&nbsp;&nbsp;上一页</a><a
                    href="admin?page_no=${cuurentPage+1}">&nbsp;&nbsp;下一页</a> <a
                    href="admin?page_no=${totalPage}">&nbsp;&nbsp;末页</a>
            </p>
        </ul>
    </div>
</div>

<jsp:include page="console_element/bottom.jsp"/>
