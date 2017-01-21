
<%--
  Created by IntelliJ IDEA.
  User: toy
  Date: 2016/8/2
  Time: 19:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <title>添加User</title>
</head>
<body>
<div class="row" style="margin-top: 30px;">
    <div class="col-lg-2"></div>
    <div class="col-lg-6">
        <c:if test="${!empty error}">
            <div class="alert alert-danger" role="alert">${error}</div>
        </c:if>

        <form:form action="/user/add" method="post">
            <div class="form-group">
                <label for="name">用户名:</label>
                <input type="text" class="form-group" id="name" name="name" value="${user.name}">
            </div>

            <div class="form-group">
                <label for="sex">性别:</label>
                <select class="form-group" id="sex" name="sex" class="effective" record-id="${user.sex}">
                    <option value="1" >男</option>
                    <option value="0" >女</option>
                </select>
            </div>

            <div class="form-group">
                <label for="age">年龄:</label>
                <input type="number" id="age" name="age" value="${user.age}">
            </div>

            <div class="form-group">
                <label for="email">邮箱:</label>
                <input type="text" id="email" name="email" value="${user.email}">
            </div>

            <button type="submit" class="btn btn-default">提交</button>
        </form:form>
    </div>
</div>
</body>
</html>

