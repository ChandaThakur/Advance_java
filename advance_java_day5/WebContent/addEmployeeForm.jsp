<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Employee</title>
</head>
<body>
<h2>Add Employee</h2>
<%String result=(String) session.getAttribute("username"); %>
<h4>You are logged in as:
<%=result %></h4>

<form action="addEmployee" method="post">
<input type="hidden" name="requestAction" value="add" />

<table>
	<tr>
		<td> Employee Id: </td>
		<td> <input type="text" name="employeeId" /></td>
	</tr>
	<tr>
		<td> Employee Name: </td>
		<td> <input type="text" name="employeeName" /></td>
	</tr>
	<tr>
		<td> Designation: </td>
		<td> <input type="text" name="designation" /></td>
	</tr>
	<tr>
		<td> Salary: </td>
		<td> <input type="text" name="salary" /></td>
	</tr>
	<tr>
		<td> Gender: </td>
		<td> Female <input type="radio" id= "female" name="gender" value="Female" /></td>
		<td> Male <input type="radio" id= "male" name="gender" value="Male" /></td>
		<td> Others <input type="radio" id= "others" name="gender" value="Others" /></td>	
	</tr>
	<tr>
		<td>City:</td>
		<td>
			<select name="city">
			<option value="Pune" label="Pune" />
			<option value="Mumbai" label="Mumbai" />
			<option value="Nagpur" label="Nagpur"/>
			<option value="Konkan" label="Konkan"/>
			<option value="Bhopal" label="Bhopal"/>
			
			</select>
		</td>
   </tr>
	<tr>
		<td> &nbsp; </td>
		<td> <input type="submit" value="Add Employee" /></td>

	</tr>
</table>
<br><br>
<a href="addEmployee?requestAction=logout">LogOut</a>
</form>
</body>
</html>