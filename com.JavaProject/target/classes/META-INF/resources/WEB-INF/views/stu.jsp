<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
h2 {
  color: #2196F3;
  font-family: verdana;
  font-size: 300%;
  text-align: center;
}

input[type=number] {
  width: 30%;
  padding: 12px 20px;
  margin: 8px 0;
  box-sizing: border-box;
  border: 3px solid #ccc;
  -webkit-transition: 0.5s;
  transition: 0.5s;
  outline: none;
}

input[type=number]:focus {
  border: 3px solid #555;
}

input[type=submit] {
  width: 25%;
  background-color: #2196F3;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}

.form-style {
  width: 500px;
  padding: 20px;
  border: 1px solid #f1f1f1;
  margin: 0 auto;
  box-sizing: border-box;
  font-family: Georgia, "Times New Roman", Times, serif;
}
</style>
<meta charset="ISO-8859-1">
<title>Java Project</title>
</head>
<body>
<h2>Student</h2>
<div class="form-style">
<form action="<%=request.getContextPath()%>/enter/student" method="POST">
	ID: <input type="number" name = "id" >
	<input type="submit" value="Enter">
</form>
</div>
</body>
</html>