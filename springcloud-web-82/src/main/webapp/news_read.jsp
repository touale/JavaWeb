<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<jsp:include page="index-elements/index_top"/>

<link href="CSS/read.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
    function formatText(name) {
        var txt = document.getElementById(name).innerHTML;
        //多个空格变成单个空格显示，所以需替换空格为&nbsp;
        txt = txt.replace(new RegExp(' ', 'g'), '&nbsp;');
        var j = 0;
        var span = document.createElement("span");
        for (i = 0; i < txt.length; i++) {
            if (txt.charAt(i) == '\n') {
                //以换行符做分割
                var partTxt = txt.slice(j, i);
                var p = document.createElement("p");
                p.innerHTML = partTxt;
                span.append(p);
                //由于p标签内容为空时，页面不显示空行，加一个<br>
                if (partTxt == '') {
                    span.appendChild(document.createElement("br"));
                }
                j = i + 1;
            }
        }
        var p_end = document.createElement("p");
        p_end.innerHTML = txt.slice(j);
        span.appendChild(p_end);
        return span.innerHTML
    }

    function change(name) {
        document.getElementById(name).innerHTML = formatText(name)
    }

</script>
<body onload="change('ncontent');">

<div id="container">
    <jsp:include page="index-elements/index_sidebar.jsp"></jsp:include>
    <div class="main">
        <div class="class_type">
            <img src="Images/class_type.gif" alt="新闻中心"/>
        </div>
        <div class="content" align="center">
            <ul class="classlist">
                <table width="95%" align="center">
                    <tr width="100%">
                        <td colspan="2" align="center">
                            ${newsTitle}
                            <!-- news title -->
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <hr/>
                        </td>
                    </tr>
                    <tr>
                        <td align="center">
                            作者: ${nauthor} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            类型：
                            <a href="index?tid=1">${tname}<!-- tname --></a>
                        </td>
                        <td align="left">
                            发布时间: ${ncreatedate}<!-- ncreatedate -->
                        </td>
                    </tr>
                    <tr>
                        <td align="right">
                            <strong>摘要：${nsummary}<!-- nsummary --></strong>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center"></td>
                    </tr>
                    <tr>
                        <td colspan="2" id="ncontent">${ncontent}</td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <hr/>
                        </td>
                    </tr>
                </table>
            </ul>
            <ul class="classlist">
                <table width="95%">

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
                                <!-- 遍历评论列表 -->
                                <tr>
                                    <td>
                                        留言人：
                                    </td>
                                    <td>
                                            ${comments.cauthor}
                                    </td>
                                    <td>
                                        IP：
                                    </td>
                                    <td>
                                            ${comments.cip}
                                    </td>
                                    <td>
                                        留言时间：
                                    </td>
                                    <td>
                                            ${comments.cdate}
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="6" id="ccontent">
                                            ${comments.ccontent}
                                     </td>
                                 </tr>
                                 <tr>
                                     <td colspan="6">
                                         <hr/>
                                     </td>
                                 </tr>

                             </c:forEach>
                             <!-- 遍历评论列表 -->
                         </c:otherwise>
                     </c:choose>


                     <!-- 遍历评论列表 -->
                     <!-- 有评论 -->
                 </table>
             </ul>
             <ul class="classlist" align="center">
                 <form id="addComment">
                     <table width="95%" align="center" align="center">
                         <tr>
                             <td>
                                 用户名：
                                 <input id="cauthor" name="cauthor" value="${currentUser}" readonly="readonly"/>
                             </td>
                             <td>
                                 IP：
                                 <input name="cip" value="${cip}" readonly="readonly"/>
                             </td>
                         </tr>
                         <td>&nbsp;</td>
                         <tr>

                             <td colspan="2">

                                 <textarea id="ccontent" name="ccontent" cols="85" rows="10"></textarea>
                             </td>
                         </tr>
                         <td>&nbsp;</td>
                     </table>
                     <tr>

                         <input name="submit" value="发    表" href="javascript:" id="do_add_comment" type="button"
                                align="center"/>
                     </tr>

                 </form>
                 <tr>
                     <td>&nbsp;</td>
                 </tr>
             </ul>
         </div>
     </div>
 </div>
     <%
     request.removeAttribute("news_view");
     request.removeAttribute("comments_view");
 %>


<jsp:include page="index-elements/index_bottom.jsp"/>
<script type="text/javascript">


    function checkComment() {
        var cauthor = document.getElementById("cauthor");
        var content = document.getElementById("ccontent");
        if (cauthor.value == "") {
            alert("用户名不能为空！！");
            return false;
        } else if (content.value == "") {
            alert("评论内容不能为空！！");
            return false;
        }
        return true;
    }

    $("#do_add_comment").click(function () {
        if (!checkComment()) {
            return
        }
        var formObject = {};
        var formArray = $("#addComment").serializeArray();
        $.each(formArray, function (i, item) {
            formObject[item.name] = item.value;
        });
        $.ajax({
            url: "util/do_add_comment?nid=${tempnid}",
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
