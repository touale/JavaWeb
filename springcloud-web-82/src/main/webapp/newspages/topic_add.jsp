<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>

<jsp:include page="console_element/top"/>
<script type="text/javascript" src="../js/jquery.js"></script>

<script type="text/javascript">
    function check() {
        var tname = document.getElementById("tname");

        if (tname.value == "") {
            alert("请输入主题名称！！");
            tname.focus();
            return false;
        }
        return true;
    }
</script>

<div id="main">
    <jsp:include page="console_element/left.jsp"/>
    <div id="opt_area">
        <h1 id="opt_type"> 添加主题： </h1>
        <form id="addTopic">
            <p>
                <label> 主题名称 </label>
                <input name="tname" type="text" class="opt_input"/>
            </p>
            <input name="action" type="hidden" value="addtopic">


            <input name="submit" value="提交" href="javascript:" id="do_add_topic" type="button" align="center"/>
            <input name="submit" value="重置" href="javascript:" id="do_reload_topic" type="button" align="center"/>

        </form>
    </div>
</div>

<script type="text/javascript">
    $("#do_reload_topic").click(function () {
        location.reload();
    });

    $("#do_add_topic").click(function () {
        var formObject = {};
        var formArray = $("#addTopic").serializeArray();
        $.each(formArray, function (i, item) {
            formObject[item.name] = item.value;
        });
        $.ajax({
            url: "../util/do_add_topic",
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
