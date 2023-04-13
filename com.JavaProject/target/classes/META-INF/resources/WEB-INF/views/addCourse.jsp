<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<style>
h2 {
  font-family: sans-serif;
  color: #0077B5;
  font-size: 24px;
}

h3 {
  font-family: sans-serif;
  color: #0077B5;
  font-size: 20px;
}

form {
  font-family: sans-serif;
  font-size: 14px;
}

input {
  font-family: sans-serif;
  font-size: 14px;
  border: 1px solid #0077B5;
  padding: 5px;
  margin-bottom: 10px;
}

input[type="submit"] {
  background-color: #0077B5;
  color: white;
  font-weight: bold;
  font-family: sans-serif;
  font-size: 14px;
  border: 1px solid #0077B5;
  padding: 5px;
  margin-bottom: 10px;
  cursor: pointer;
}

</style>
</head>
<title>Java Project</title>
<body>
	<h2>Add Course</h2>
	<c:if test="${not empty msg}">
        ${msg}
    </c:if>
	<form method="POST" name="add_course"
		action="<%=request.getContextPath()%>/add/course">
		Name: <input name="name" value="${name}" type="text" /> <br /> <br />
		Course Description: <input name="description" value="${description}" type="text" />
		<br /> <br />
		<input value="Add Course" type="submit" />
	</form>
</body>
</html>