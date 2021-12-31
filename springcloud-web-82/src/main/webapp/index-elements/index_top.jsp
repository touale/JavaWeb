<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=GBK"/>
    <meta http-equiv="pragma" content="no-cache"/>
    <meta http-equiv="cache-control" content="no-cache"/>
    <title>新闻中国</title>

    <link href="CSS/main.css" rel="stylesheet" type="text/css"/>
    <%--	<script language="javascript">--%>
    <%--		function focusOnLogin(){--%>
    <%--			var login_username = document.getElementById("uname");--%>
    <%--			if( login_username != null )--%>
    <%--				login_username.focus();	--%>
    <%--		}--%>
    <%--	</script>--%>
</head>
<%--取消焦点--%>
<%--<body onload="focusOnLogin()">--%>
<script type="text/javascript" src="js/jquery.js"></script>
<div id="header">
    <div id="top_login">
        <c:choose>
            <c:when test="${isLogin==0}">
                <!-- 判断是否登录 session -->
                <form id="toLogin">
                    <label> 账&#160;&#160;号 </label>
                    <input type="text" id="uname" name="uname" value="" class="login_input"/>
                    <label> 密&#160;&#160;码 </label>
                    <input type="password" id="upwd" name="upwd" value="" class="login_input"/>
                    <input type="button" class="login_sub" href="javascript:" id="doLogin" value="登录"/>
                    <label id="error"> </label>


                    <img src="Images/friend_logo.gif" alt="Google" id="friend_logo"/>
                </form>
                <!-- 判断是否登录 session -->
            </c:when>
            <c:otherwise>
                <a>欢迎您：${userName} &nbsp; &nbsp; &nbsp;</a>

                <a href="newspages/admin">登录控制台</a> &nbsp; <a
                    href="logout">退出</a>
                <!-- 已经登录 --></a>

            </c:otherwise>
        </c:choose>



    </div>
    <a> &nbsp;</a>
    <div id="nav">
        <div id="logo"><img src="Images/logo.jpg" alt="新闻中国"/></div>
        <div id="a_b01"><img src="Images/a_b01.gif" alt=""/></div>
        <!--mainnav end-->
    </div>
</div>


<script type="text/javascript">


    function checkLogin() {
        var login_username = document.getElementById("uname");
        var login_password = document.getElementById("upwd");
        if (login_username.value == "") {
            alert("用户名不能为空！请重新填入！");
            login_username.focus();
            return false;
        } else if (login_password.value == "") {
            alert("密码不能为空！请重新填入！");
            login_password.focus();
            return false
        }
        return true;
    }

    $("#doLogin").click(function () {
        if (!checkLogin()) {
            return
        }
        var formObject = {};
        var formArray = $("#toLogin").serializeArray();
        $.each(formArray, function (i, item) {
            formObject[item.name] = item.value;
        });
        $.ajax({
            url: "/doLogin",
            type: "post",
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(formObject),
            dataType: "json",
            success: function (data) {
                alert(data.msg);
                if (data.succ == true) {
                    window.location.href = '/index';
                }
            },
            error: function (e) {
                alert("系统异常，请重试！");
            }
        });
    });
</script>
