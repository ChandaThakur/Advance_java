<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Welcome to Employee CURD Application</h2>
<%String result=(String) session.getAttribute("username"); %>
<h4>You are logged in as:
<%=result %></h4>

<a href="addEmployeeForm.jsp">Click here to Add a new Employee</a>
<br><br>
<a href="getAllEmployees?requestAction=viewAll">Click here to view all Employee</a>
<br><br>
<a href="updateEmployee?requestAction=logout">LogOut</a>
</body>
</html>