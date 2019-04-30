<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<body>
<h2>Your access has been denied to this page</h2>

<p>
 you are not authorized to access here!
</p>

<a href="${pageContext.request.contextPath}/">Go to home ---> </a>
</body>
</html>
