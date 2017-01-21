<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: toy
  Date: 2016/8/2
  Time: 19:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html:charset=utf-8">
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="/js/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="/js/bootstrap.min.js"></script>
    <title>User信息</title>
</head>
<body>
<div class="row" style="margin-top: 30px">

    <div class="col-lg-6">
        <form:form action="/user/list" method="post" class="form-inline">
            <div class="form-group">
                <label>用户名</label>
                <input class="form-group" type="text" id="userName" name="userName" value="${name}" />
            </div>
            <div class="form-group">
                <label>年龄</label>
                <input class="form-group" type="text" id="age" name="age" value="${age}" />
            </div>
            <button type="submit" class="btn btn-primary btn-group-sm">查询</button>
        </form:form>
    </div>

    <div class="col-lg-x2">
        <a href="/user/add" class="btn btn-primary btn-sm">添加</a>
    </div>
</div>

<table class="table table-hover">
    <thead>
    <tr>
        <th>姓名</th>
        <th>性别</th>
        <th>年龄</th>
        <th>邮箱</th>
    </tr>
    </thead>
    <tbody>
    <c:if test="${!empty users}">
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.name}</td>
                <td>
                    <select class="effective" >
                        <option value="1" ${user.sex == 1 ? "selected=selected" : ""}>男</option>
                        <option value="0" ${user.sex == 0 ? "selected=selected" : ""}>女</option>
                    </select>
                </td>
                <td>${user.age}</td>
                <td>${user.email}</td>
                <td><a href="/user/update?id=${user.id}" type="button" class="btn btn-sm btn-warning">修改</a></td>
            </tr>
        </c:forEach>
    </c:if>
    </tbody>
</table>

<div class="row">
    <div class="col-lg-10"></div>
    <div class="col-lg-2">
        <a class="pagination-prev btn btn-default" href="#">上一页</a>
        <a class="pagination-next btn btn-default" href="#">下一页</a>
    </div>
</div>

<script>
    $(function(){
        prev_href = "/user/list?page=${page-1 <= 0 ? 1 : page-1}";
        next_href = "/user/list?page=${page+1 >= pages ? pages : page+1}";

        param = "&name=" + $("#userName").val() + "&age=" + $("#age").val();

        $(".pagination-prev").click(function () {
            location.href = prev_href + param;
        })

        $(".pagination-next").click(function () {
            location.href = next_href + param;
        })


        $(".effective").change(function(){
            var id = $(this).attr("record-id");
            var effective = $(this).val();
            $.ajax({
                url: "/customer/changeStatus",
                type: "post",
                data: {"id":id, "effective": effective},
                dataType: "json",

                success: function(result)
                {
                    if (result.status == 1)
                    {
                        alert("Operate success!");
                    } else
                    {
                        alert("Operate failed!");
                    }
                },

                error: function()
                {
                    alert("Operate failed!");
                }
            });
        });
    });
</script>

</body>
</html>
