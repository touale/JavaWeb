<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>


<jsp:include page="console_element/top"/>
<script type="text/javascript" src="../js/jquery.js"></script>


<div id="main">
    <jsp:include page="console_element/left.jsp"/>
    <div id="opt_area">
        <h1 id="opt_type"> 添加新闻： </h1>
        <form id="addNews" enctype="multipart/form-data">
            <p>
                <label> 主题 </label>
                <select name="ntid">
                    <c:forEach var="topic" items="${topicList}">
                        <option value='${topic.tname}' name="ntid">${topic.tname}</option>
                    </c:forEach>
                </select>
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


            <input name="submit" value="提交" href="javascript:" id="do_add_news" type="button" align="center"/>
            <input name="submit" value="重置" href="javascript:" id="do_reload_news" type="button" align="center"/>
        </form>
    </div>
</div>
<script type="text/javascript">
    $("#do_reload_news").click(function () {
        location.reload();
    });

    $("#do_add_news").click(function () {
        var formObject = {};
        var formArray = $("#addNews").serializeArray();
        $.each(formArray, function (i, item) {
            formObject[item.name] = item.value;
        });
        $.ajax({
            url: "../util/do_add_news",
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
