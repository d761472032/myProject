<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/18
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="lib/head.jsp"%>
<html>
<head>
    <title>Welcome!${sessionScope.user.username}</title>
</head>
<body>
Welcome!${sessionScope.user.username}
<a href="${basePath}/login/page">Page1</a>
</body>
</html>
