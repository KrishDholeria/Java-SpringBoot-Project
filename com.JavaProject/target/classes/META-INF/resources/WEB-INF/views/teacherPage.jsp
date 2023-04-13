<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
    h2 {
        color: #3498db;
        font-size: 30px;
        font-family: sans-serif;
        text-align: center;
    }
    h3 {
        color: #3498db;
        font-size: 25px;
        font-family: sans-serif;
        text-align: center;
    }
    button {
        background-color: #3498db;
        color: #fff;
        font-size: 18px;
        padding: 10px;
        border-radius: 5px;
        width: 150px;
        outline: none;
        border: none;
        margin-left: 15px;
    }
</style>
</head>
<body>
<h3>Teacher</h3>
<h2>Name: ${teacher.name}</h2>
<table width=80% align="center">
<tr>
<th>
<a href="<%=request.getContextPath()%>/students"><button>View All Students</button></a>
</th><th>
<a href="<%=request.getContextPath()%>/addStudent"><button>Add Student</button></a>
</th><th>
<a href="<%=request.getContextPath()%>/addResult"><button>Add Result</button></a>
</th><th>
<a href="<%=request.getContextPath()%>/addCourse"><button>Add Course</button></a>
</th>
</tr>
</table>
</body>
</html>