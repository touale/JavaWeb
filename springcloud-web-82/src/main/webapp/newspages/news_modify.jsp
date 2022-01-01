<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<jsp:include page="console_element/top"/>
<script type="text/javascript" src="../js/jquery.js"></script>


<div id="main">
    <jsp:include page="console_element/left.jsp"/>
    <div id="opt_area">
        <h1 id="opt_type">添加新闻：</h1>
        <form id="updateNews" enctype="multipart/form-data">
            <p>
                <label> 主题 </label>
                <select name="ntid">
                    <c:forEach var="topic" items="${topicList}">
                        <c:choose>
                            <c:when test="${topic.tid == newsInfo.ntid}">
                                <option value='${topic.tname}' name="ntid" selected="selected">${topic.tname}</option>
                            </c:when>
                            <c:otherwise>
                                <option value='${topic.tname}' name="ntid">${topic.tname}</option>
                            </c:otherwise>
                        </c:choose>

                    </c:forEach>

                </select>
                <input type="hidden" name="nid" value="${newsInfo.nid}"/>
            </p>
            <p>
                <label> 标题 </label> <input name="ntitle" type="text"
                                           class="opt_input" value="${newsInfo.ntitle}"/>
            </p>
            <p>
                <label> 作者 </label> <input name="nauthor" type="text"
                                           class="opt_input" value="${newsInfo.nauthor}"/>
            </p>
            <p>
                <label> 摘要 </label>
                <textarea name="nsummary" cols="40" rows="3">${newsInfo.nsummary}</textarea>
            </p>
            <p>
                <label> 内容 </label>
                <textarea name="ncontent" cols="70" rows="10">${newsInfo.ncontent}</textarea>
            </p>
            <p>
                <label> 上传图片 </label> <input name="file" type="file"
                                             class="opt_input"/>
            </p>

            <input name="submit" value="提交" href="javascript:" id="do_update_news" type="button" align="center"/>
            <input name="submit" value="重置" href="javascript:" id="do_reload_news" type="button" align="center"/>
        </form>
        <tr>
            <td>&nbsp;</td>
        </tr>
        <h1 id="opt_type">修改新闻评论：</h1>
        <table width="80%" align="left">

            <c:choose>
                <c:when test="${hasComments== 0}">
                    <!-- 暂无评论！ -->
                    <td colspan="6">
                        暂无评论！
                    </td>
                    <tr>
                        <td colspan="6">
                            <hr/>
                        </td>
                    </tr>
                    <!-- -->
                </c:when>
                <c:otherwise>
                    <!-- 有评论 -->
                    <c:forEach var="comments" items="${commentsList}">
                        <!-- 判断： 有评论 -->
                        <!-- 循环输出评论 -->
                        <tr>
                            <td>留言人：</td>
                            <td>${comments.cauthor}</td>
                            <td>IP：</td>
                            <td>${comments.cip}</td>
                            <td>留言时间：</td>
                            <td>${comments.cdate}</td>
                            <td><a
                                    href="../util/do_delete_comments?cid=${comments.cid}&cnid=${comments.cnid}">删除</a>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="6">${comments.ccontent}</td>
                        </tr>
                        <tr>
                            <td colspan="6">
                                <hr/>
                            </td>
                        </tr>
                        <!-- 循环输出评论 -->
                        <!-- 判断： 有评论 -->
                    </c:forEach>
                    <!-- 遍历评论列表 -->
                </c:otherwise>
            </c:choose>


            <!-- 判断： 无评论 -->


        </table>
    </div>
</div>

<script type="text/javascript">
    $("#do_reload_news").click(function () {
        location.reload();
    });

    $("#do_update_news").click(function () {
        var formObject = {};
        var formArray = $("#updateNews").serializeArray();
        $.each(formArray, function (i, item) {
            formObject[item.name] = item.value;
        });
        $.ajax({
            url: "../util/do_update_news",
            type: "post",
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(formObject),
            dataType: "json",
            success: function (data) {
                alert(data.msg);
                if (data.succ == true) {
                    location.reload();
                }
            },
            error: function (e) {
                alert("系统异常，请重试！");
            }
        });
    });
</script>


<jsp:include page="console_element/bottom.jsp"/>


