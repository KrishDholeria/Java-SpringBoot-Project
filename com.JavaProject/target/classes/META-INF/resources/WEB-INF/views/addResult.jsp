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
	<h2>Add Result</h2>
	<c:if test="${not empty msg}">
        ${msg}
    </c:if>
	<form method="POST" name="add_result"
		action="<%=request.getContextPath()%>/add/result">
		Select Student:
		<select name="student_id">
			<c:forEach items="${students}" var="s">
				<option value="${s.id}">${s.rollno}-${s.name}</option>
			</c:forEach>
		</select>
		<br>
		CPI: <input name="cpi" value="${cpi}" type="number" /> <br /> <br />
		SPI: <input name="spi" value="${spi}" type="number" />
		<br /> <br />
		<input value="Add Result" type="submit" />
	</form>
</body>
</html>