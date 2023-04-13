<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<title>Java Project</title>
<body>
	<c:if test="${not empty msg}">
        ${msg}
    </c:if>
	<h3>Add Teacher</h3>
	<form method="POST" name="add_teacher"
		action="<%=request.getContextPath()%>/add/teacher">
		Name: <input name="name" value="${name}" type="text" /> <br /> <br />
		<input value="Add Teacher" type="submit" />
	</form>
</body>
</html>