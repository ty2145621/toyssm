<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h2>Hello World!</h2>
<p>SpringMVC + MyBatis Project by toy</p>
<form:form action="/admin/loginView" method="post">
    <button type="submit" class="btn-default">login</button>
</form:form>

</body>
</html>
