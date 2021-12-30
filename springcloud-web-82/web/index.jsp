<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<jsp:include page="index-elements/index_top.jsp"></jsp:include>
<div id="container">
	<jsp:include page="index-elements/index_sidebar.jsp" />
	<div class="main">
		<div class="class_type">
			<img src="Images/class_type.gif" alt="新闻中心" />
		</div>
		<div class="content">
			<ul class="class_date">
				<!--遍历 显示topic list -->
				<li id='class_month'><a href="index.jsp?tid=1"><b></b> </a> <!--遍历 显示topic list -->
			</ul>

			<ul class="classlist">
				<!-- 遍历显示 news list  -->
				<li><a href="news_read.jsp?nid=1"> </a> <span></span></li>
				<!-- 遍历显示 news list  -->

				<!-- 分页显示 -->
				<p align="right">
					当前页数:[   /  ]&nbsp;&nbsp; <a
						href="index.jsp?page_no=1">首页</a><a
						href="index.jsp?page_no=1">&nbsp;&nbsp;上一页</a><a
						href="index.jsp?page_no=1">&nbsp;&nbsp;下一页</a> <a
						href="index.jsp?page_no=1">&nbsp;&nbsp;末页</a>
				</p>

			</ul>
		</div>
		<jsp:include page="index-elements/index_rightbar.html" />
	</div>
</div>

<jsp:include page="index-elements/index_bottom.html" />
