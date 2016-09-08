<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: toy
  Date: 2016/8/4
  Time: 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>成功</title>
</head>
<body>
<p>操作成功</p>
<form:form action="/user/list" method="get">
    <button type="submit" class="btn-default">返回</button>
</form:form>
</body>
</html>
