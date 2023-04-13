<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<style>
h2{
	font-family: sans-serif;
	color: #b51a00;
	text-align: left;
	font-size: 24px
}
input{
	width: auto;
	padding: 8px 10px;
	font-size: 16px;
	margin-bottom: 15px;
	border: 1px solid #ccc;
	border-radius: 5px;
}
</style>
<title>Java Project</title>
</head>
<body>
	<h2>Update Course</h2>
	<c:if test="${not empty msg}">
        ${msg}
    </c:if>
	<form method="POST" name="update_course"
		action="<%=request.getContextPath()%>/update/course">
		<input hidden="hidden" name="id" value="${id}" type="text" /> Name: <input
			name="name" value="${course.name}" type="text" /> <br /> <br />
		Course Description: <input name="description" value="${course.description}"
			type="text" /> <br /> <br /> <input value="Update User"
			type="submit" />
	</form>
</body>
</html>