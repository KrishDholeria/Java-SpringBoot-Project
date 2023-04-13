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
	<h2>All Students</h2>
	<a href="<%=request.getContextPath()%>/addStudent"><button>Add</button></a>
	<c:if test="${not empty msg}">
        ${msg}
    </c:if>
	<c:choose>
		<c:when test="${students != null}">
			<h3>List of Students</h3>
			<table cellpadding="5" cellspacing="5">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Roll No.</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="s" items="${students}">
						<tr>
							<td>${s.id}</td>
							<td>${s.name}</td>
							<td>${s.rollno}</td>
							<td><a
								href="<%=request.getContextPath()%>/students/${s.id}">Details</a>
								&nbsp;<a
								href="<%=request.getContextPath()%>/update/student/${s.id}">Update</a>
								&nbsp; <a
								href="<%=request.getContextPath()%>/delete/student/${s.id}"
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
	<a href="<%=request.getContextPath()%>/teacher"><button>Back</button></a>
</body>
</html>