<%--
  Created by IntelliJ IDEA.
  User: 栏前
  Date: 2021/12/30
  Time: 13:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Hello World</title></head>
<body>
Hello World!<br/>
<%
  out.println("Your IP address is " + request.getRemoteAddr());
%>
</body>
</html>
