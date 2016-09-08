<%--
  Created by IntelliJ IDEA.
  User: toy
  Date: 2016/8/10
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Mybatis分页插件 - 测试页面</title>
    <style type="text/css">
        * {
            margin: 0;
        }

        html, body {
            height: 100%;
        }

        .wrapper {
            min-height: 100%;
            height: auto !important;
            height: 100%;
            margin: 0 auto -155px;
        }

        .footer, .push {
            height: 155px;
        }

        table.gridtable {
            font-family: verdana, arial, sans-serif;
            font-size: 11px;
            color: #333333;
            border-width: 1px;
            border-color: #666666;
            border-collapse: collapse;
            margin: 5px auto;
        }

        table.gridtable th {
            border-width: 1px;
            padding: 8px;
            border-style: solid;
            border-color: #666666;
            background-color: #dedede;
        }

        table.gridtable td {
            border-width: 1px;
            padding: 8px;
            border-style: solid;
            border-color: #666666;
            background-color: #ffffff;
        }

        .middle {
            text-align: center;
            margin: 0 auto;
            width: 600px;
            height: auto;
        }

        .info {
            font-size: 12px;
            text-align: center;
            line-height: 20px;
            padding: 40px;
        }

        .info a {
            margin: 0 10px;
            text-decoration: none;
            color: green;
        }
    </style>
</head>
<body>
<div class="wrapper">
    <div class="middle">
        <c:if test="${empty page}">
            <h1 style="padding: 150px 0 20px;">查询国家列表</h1>
        </c:if>
        <c:if test="${!empty page}">
            <h1 style="padding: 50px 0 20px;">查询国家列表</h1>
        </c:if>

        <c:if test="${err!=null}">
            <h3 style="color:red;">${err}</h3>
        </c:if>
        <form action="user/list" method="post">
            <table class="gridtable" style="width:100%;">
                <tr>
                    <th>页码：</th>
                    <td><input type="text" name="pageNum"/></td>
                    <th>页面大小：</th>
                    <td><input type="text" name="pageSize"/></td>
                    <td><input type="submit" value="查询"/></td>
                </tr>
            </table>
        </form>
        <c:if test="${!empty page}">
            <table class="gridtable" style="width:100%;">
                <tr>
                    <th colspan="2">分页信息</th>
                </tr>
                <tr>
                    <th style="width: 300px;">当前页号</th>
                    <td>${page.pageNum}</td>
                </tr>
                <tr>
                    <th>页面大小</th>
                    <td>${page.pageSize}</td>
                </tr>
                <tr>
                    <th>起始行号(>=)</th>
                    <td>${page.startRow}</td>
                </tr>
                <tr>
                    <th>终止行号(<=)</th>
                    <td>${page.endRow}</td>
                </tr>
                <tr>
                    <th>总结果数</th>
                    <td>${page.total}</td>
                </tr>
                <tr>
                    <th>总页数</th>
                    <td>${page.pages}</td>
                </tr>
                <tr>
                    <th>第一页</th>
                    <td>${page.firstPage}</td>
                </tr>
                <tr>
                    <th>前一页</th>
                    <td>${page.prePage}</td>
                </tr>
                <tr>
                    <th>下一页</th>
                    <td>${page.nextPage}</td>
                </tr>
                <tr>
                    <th>最后一页</th>
                    <td>${page.lastPage}</td>
                </tr>
                <tr>
                    <th>是否为第一页</th>
                    <td>${page.isFirstPage}</td>
                </tr>
                <tr>
                    <th>是否为最后一页</th>
                    <td>${page.isLastPage}</td>
                </tr>
                <tr>
                    <th>是否有前一页</th>
                    <td>${page.hasPreviousPage}</td>
                </tr>
                <tr>
                    <th>是否有下一页</th>
                    <td>${page.hasNextPage}</td>
                </tr>
            </table>
            <table class="gridtable" style="width:100%;">
                <thead>
                <tr>
                    <th colspan="4">查询结果</th>
                </tr>
                <tr>
                    <th>姓名</th>
                    <th>性别</th>
                    <th>年龄</th>
                    <th>邮箱</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${page.list}" var="user">
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
                </tbody>
            </table>
            <table class="gridtable" style="width:100%;text-align: center;">
                <tr>
                    <c:if test="${page.hasPreviousPage}">
                        <td><a href="${pageContext.request.contextPath}/user/list/?page=${page.prePage}&pageSize=${page.pageSize}">前一页</a></td>
                    </c:if>
                    <c:forEach items="${page.navigatepageNums}" var="nav">
                        <c:if test="${nav == page.pageNum}">
                            <td style="font-weight: bold;">${nav}</td>
                        </c:if>
                        <c:if test="${nav != page.pageNum}">
                            <td><a href="${pageContext.request.contextPath}/user/list/?page=${nav}&pageSize=${page.pageSize}">${nav}</a></td>
                        </c:if>
                    </c:forEach>
                    <c:if test="${page.hasNextPage}">
                        <td><a href="${pageContext.request.contextPath}/user/list/?page=${page.nextPage}&pageSize=${page.pageSize}">下一页</a></td>
                    </c:if>
                </tr>
            </table>
        </c:if>
    </div>
    <div class="push"></div>
</div>
<div class="footer">
    <div class="info">
        <a href="http://git.oschina.net/free/Mybatis_PageHelper">Mybatis分页插件</a>
        <a href="http://git.oschina.net/free/Mybatis-Sample">Mybatis-Sample</a>
        <br/>
        作者：<a href="http://blog.csdn.net/isea533" style="margin: 0;">@Isea533/abel533</a>
    </div>
</div>
</body>
</html>

