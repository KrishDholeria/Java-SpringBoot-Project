<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
	<title>Java Project</title>
	<style>
		h2 {
			color: black;
			font-size: 30px;
		}
		table {
			border-collapse: collapse;
			width: 100%;
		}
		th, td {
			text-align: left;
			padding: 10px;
		}
		th {
			background-color: #F08080;
			color: white;
		}
		tr:nth-child(even){background-color: #FFA500}
	</style>
</head>
<body>
	<h2>All Courses</h2>
	<a href="<%=request.getContextPath()%>/addCourse"><button>Add</button></a>
	<c:if test="${not empty msg}">
        ${msg}
    </c:if>
	<c:choose>
		<c:when test="${courses != null}">
			<h3>List of Courses</h3>
			<table cellpadding="5" cellspacing="5">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Description</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="c" items="${courses}">
						<tr>
							<td>${c.id}</td>
							<td>${c.name}</td>
							<td>${c.description}</td>
							<td><a
								href="<%=request.getContextPath()%>/course/${c.id}">Details</a>
								&nbsp;<a
								href="<%=request.getContextPath()%>/update/course/${c.id}">Update</a>
								&nbsp; <a
								href="<%=request.getContextPath()%>/delete/course/${c.id}"
								onclick="return confirm('Do you really want to delete?')">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:when>
		<c:otherwise>
        No User found in the DB!
        </c:otherwise>
	</c:choose>
</body>
</html>