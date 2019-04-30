<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<body>
<h2>Welcome to My System</h2>

<p>
    user: <security:authentication property="principal.username"/>
    <br>
    <br>
    role: <security:authentication property="principal.authorities"/>
</p>


<security:authorize access="hasRole('manager')">
    <a href="${pageContext.request.contextPath}/leaders">Leaders Page</a>
    <br>
</security:authorize>


<security:authorize access="hasRole('admin')">
    <a href="${pageContext.request.contextPath}/systems">Admins Page</a>
    <br>
</security:authorize>


<form:form method="post" action="${pageContext.request.contextPath}/logout">
    <input type="submit" value="LOGOUT">
</form:form>


</body>
</html>
