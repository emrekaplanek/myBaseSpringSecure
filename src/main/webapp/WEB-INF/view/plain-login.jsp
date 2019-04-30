<%--
  Created by IntelliJ IDEA.
  User: argek
  Date: 29.04.2019
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login page</title>

    <style>
        .failed{
            color: red;
        }
    </style>
</head>
<body>

<form:form action="${pageContext.request.contextPath}/authenticateTheUser"
            method="post">

    <c:if test="${param.error != null}">
        <i class="failed"> Sorry wrong password or username</i>
    </c:if>
    
    <p>User Name
        <input type="text" name="username" >
    </p>


    <p>Password
        <input type="password" name="password" >
    </p>


    <input type="submit" value="LOGIN">
</form:form>

</body>
</html>
