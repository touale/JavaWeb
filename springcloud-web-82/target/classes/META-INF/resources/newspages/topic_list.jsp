<%@ page language="java" import="java.util.*,java.sql.*"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<jsp:include page="console_element/top"/>

<script language="javascript">
    function clickdel() {
        return confirm("删除后，主题下的文章也会删除，确认删除吗？");
    }
</script>


<div id="main">
    <jsp:include page="console_element/left.jsp"/>
    <div id="opt_area">
        <ul class="classlist">
            <!-- 遍历  topic list -->
            <c:forEach var="topic" items="${topicList}">
                <li>&#160;&#160;&#160;&#160; ${topic.tname}&#160;&#160;&#160;&#160; <a
                        href='topic_modify?tid=${topic.tid}&tname=${topic.tname}'>修改</a>
                    &#160;&#160;&#160;&#160; <a
                            href='../util/do_delete_topics?tid=${topic.tid}&page_no=${cuurentPage}'
                            onclick='return clickdel()'>删除</a>
                </li>
            </c:forEach>

            <!-- 遍历  topic list -->

            <!-- 显示分页 -->
            <p align="right">
                当前页数:[ ${cuurentPage} / ${totalPage} ]&nbsp;&nbsp; <a
                    href="topic_list?page_no=1">首页</a><a
                    href="topic_list?page_no=${cuurentPage-1}">&nbsp;&nbsp;上一页</a><a
                    href="topic_list?page_no=${cuurentPage+1}">&nbsp;&nbsp;下一页</a> <a
                    href="topic_list?page_no=${totalPage }">&nbsp;&nbsp;末页</a>
            </p>
        </ul>
    </div>
</div>


<jsp:include page="console_element/bottom.jsp"/>
