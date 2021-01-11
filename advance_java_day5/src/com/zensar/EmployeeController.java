package com.zensar;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.*;

import com.zensar.beans.Employee;

public class EmployeeController extends HttpServlet{
	
	public  void doGet(HttpServletRequest request,HttpServletResponse response) {
		
		String requestAction=request.getParameter("requestAction");
		
		if(requestAction.equalsIgnoreCase("viewAll")) {
			System.out.println("in DoGet method");
			EmployeeRepository eR= new EmployeeRepository();
			List<Employee> listOfAllEmployee=eR.getAllEmployees();
			
			System.out.println(listOfAllEmployee);
			
			RequestDispatcher rd=request.getRequestDispatcher("viewAllEmployees.jsp");
			request.setAttribute("listOfAllEmployees", listOfAllEmployee);
			try{
				rd.forward(request, response);
			}catch(Exception e) {
				System.out.println("Exceprion occured"+e);  
			}
		}else if(requestAction.equalsIgnoreCase("delete")) {
			
			System.out.println("Going to delete an employee");
			EmployeeRepository er =new EmployeeRepository();
			int employeeId = Integer.parseInt(request.getParameter("employeeId"));
			er.deleteEmployee(employeeId);
			
			//RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
			// we have removed request dispature becoz after deletion when we do refresh it perform deletion again n again on refresh
			try{
				//rd.forward(request, response);
				
				response.sendRedirect("index.jsp");
			}catch (Exception e) {
				System.out.println("Exception Occured" +e);
			}
			
		}else if(requestAction.equalsIgnoreCase("openUpdateForm")) {
			int employeeId = Integer.parseInt(request.getParameter("employeeId"));
			
			//connect to db using repository and fetch the data
			EmployeeRepository er=new EmployeeRepository();
			Employee employee=er.getEmployee(employeeId);
			
			RequestDispatcher rd= request.getRequestDispatcher("updateEmployeeForm.jsp");
			request.setAttribute("employee", employee);
			try {
			rd.forward(request, response);
			
			}catch(Exception e) {
				System.out.println("Exception Occured:" + e);
			}
		}else if(requestAction.equalsIgnoreCase("update")) {
			int employeeId = Integer.parseInt(request.getParameter("employeeId"));
			String employeeName = request.getParameter("employeeName");
			String designation = request.getParameter("designation");
			int salary = Integer.parseInt(request.getParameter("salary"));
			String gender= request.getParameter("gender");
			String city = request.getParameter("city");
			
			EmployeeRepository er=new EmployeeRepository();
			Employee employee=new Employee(employeeId, employeeName, designation, salary, gender, city);
			er.updateEmployee(employee);
			
			try {
				response.sendRedirect("index.jsp");
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}else if(requestAction.equalsIgnoreCase("add")) {
			
			int employeeId = Integer.parseInt(request.getParameter("employeeId"));
			String employeeName = request.getParameter("employeeName");
			String designation = request.getParameter("designation");
			int salary = Integer.parseInt(request.getParameter("salary"));
			String gender= request.getParameter("gender");
			String city = request.getParameter("city");

			System.out.println("employeeId:"+employeeId);
			System.out.println("employeeName:"+employeeName);
			System.out.println("designation:"+designation);
			System.out.println("salary:"+salary);
			System.out.println("gender:"+gender);
			System.out.println("city:"+city);
			
			EmployeeRepository er=new EmployeeRepository();
			
			Employee employee=new Employee(employeeId, employeeName, designation, salary, gender, city);
			er.addEmployee(employee);
			
			
			//RequestDispatcher rd=request.getRequestDispatcher("result.jsp");
			try{
				//rd.forward(request, response);
				
				response.sendRedirect("index.jsp");
			}catch (Exception e) {
				System.out.println("Exception Occured" +e);
			}
		}
		
		else if(requestAction.equalsIgnoreCase("login")){
		
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			
			HttpSession session=request.getSession();
			session.setAttribute("username", username);
			
			EmployeeRepository er=new EmployeeRepository();
			boolean loginResult=er.checkLogin(username, password);
			if(loginResult) {
				System.out.println("Login Successful");
				try {
					response.sendRedirect("index.jsp");
					
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			}else {
				System.out.println("Login Failed");
				try {
					response.sendRedirect("login.jsp?loginStatus=fail");
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			}
		}else if(requestAction.equalsIgnoreCase("logout")) {
			try {
				response.sendRedirect("login.jsp?logoutStatus=yes");
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) {
		
		doGet(request,response);
	}

}
