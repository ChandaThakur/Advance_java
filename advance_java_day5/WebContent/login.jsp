<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Employee LogIn</h2>

<form action="login" method="get">
<input type="hidden" name="requestAction" value="login" />
<table>
	<tr>
		<td> User Name: </td>
		<td> <input type="text" name="username" /></td>
	</tr>
	<tr>
		<td> Password: </td>
		<td> <input type="password" name="password" /></td>
	</tr>
	<tr>
		<td> &nbsp; </td>
		<td> <input type="submit" value="Log In" /></td>
	</tr>
</table>
<% if(request.getParameter("loginStatus")!=null) {
	if(request.getParameter("loginStatus").equals("fail")){
%>
<p><%="Invalid Credentials !" %></p>
<%
	}
}
%>
<% if(request.getParameter("logoutStatus")!=null) {
	if(request.getParameter("logoutStatus").equals("yes")){
%>
<p><%="You have logged out successfully" %></p>
<%
	}
}
%>

</form>
</body>
</html>