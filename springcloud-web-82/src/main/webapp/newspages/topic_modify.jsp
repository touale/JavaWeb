<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:include page="console_element/top.jsp" />
<script type="text/javascript" src="../js/jquery.js"></script>

<script type="text/javascript">
	function check(){
		var tname = document.getElementById("tname");

		if(tname.value == ""){
			alert("请输入主题名称！！");
			tname.focus();
			return false;
		}		
		return true;
	}
</script>


<div id="main">
  <jsp:include page="console_element/left.jsp" />
  <div id="opt_area">
    <h1 id="opt_type"> 添加主题： </h1>
    <form id="updateTopic" onsubmit="return check()">
      <p>
        <label> 主题名称 </label>
        <input name="tname" type="text" class="opt_input" value="${tname}"/>
        <input name="tid" type="hidden" value="${tid}">
      </p>
      <input name="action" type="hidden" value="addtopic">
      <input name="submit" value="提交" href="javascript:" id="do_update_topic" type="button" align="center"/>
      <input name="submit" value="重置" href="javascript:" id="do_reload_topic" type="button" align="center"/>
    </form>
  </div>
</div>

<script type="text/javascript">
  $("#do_reload_topic").click(function () {
    location.reload();
  });

  $("#do_update_topic").click(function () {
    var formObject = {};
    var formArray = $("#updateTopic").serializeArray();
    $.each(formArray, function (i, item) {
      formObject[item.name] = item.value;
    });
    $.ajax({
      url: "../util/do_update_topic",
      type: "post",
      contentType: "application/json; charset=utf-8",
      data: JSON.stringify(formObject),
      dataType: "json",
      success: function (data) {
        alert(data.msg);
        if (data.succ == true) {
          window.history.go(-1);
        }
      },
      error: function (e) {
        alert("系统异常，请重试！");
      }
    });
  });
</script>
<jsp:include page="console_element/bottom.jsp" />
