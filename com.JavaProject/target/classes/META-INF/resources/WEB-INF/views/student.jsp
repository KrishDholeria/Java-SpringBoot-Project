<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title>Java Project</title>
	<style>
		h2 {
			color: #FF0000;
			text-align: center;
			font-size: 24px;
			font-family: sans-serif;
		}
		
		table {
			border-collapse: collapse;
			width: 80%;
			margin: auto;
			text-align: center;
			font-family: sans-serif;
			box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
			border-radius: 5px;
		}
		
		th, td {
			border: 1px solid #ddd;
			padding: 12px;
			font-size: 18px;
		}
		
		tr:nth-child(even) {
			background-color: #f2f2f2;
		}
		
		th {
			background-color: #4CAF50;
			color: white;
		}
	</style>
</head>
<body>
	<h2>Student Details</h2>
	<table>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Roll No.</th>
			<th>Result</th>
			<th>Courses</th>
		</tr>
		<tr>
			<td>${student.id}</td>
			<td>${student.name}</td>
			<td>${student.rollno}</td>
			<td>CPI:${student.result.cpi}<br> SPI:${student.result.spi}</td>
			<td>
				<ul>
				<c:set var="size" value="${student.courses.size()}" />
				<c:choose>
					<c:when test="${size != 0}">
					<c:forEach items="${student.courses}" var="c">
						<li><a href="">${c.name}</a></li>
					</c:forEach>
					</c:when>
					<c:otherwise>
						<li>No courses opted, please add course first</li>
					</c:otherwise>
				</c:choose>
				</ul>
			</td>
		</tr>
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td>
				<form action="<%=request.getContextPath()%>/student/${student.id}" method="POST">
					<select name="course_id">
						<c:forEach items="${courses}" var="c1">
							<option value="${c1.id}">${c1.name}</option>
						</c:forEach>
					</select>
					<input type="submit" value="Add Course"/>
				</form>
			</td>
		</tr>
	</table>
</body>
</html>