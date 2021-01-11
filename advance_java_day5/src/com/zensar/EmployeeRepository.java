package com.zensar;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.zensar.beans.Employee;

import utility.DBUtil;

public class EmployeeRepository {
	
	public boolean checkLogin(String username,String password) {
		System.out.println("in Respsitory");
		boolean result=true;
		Connection con=DBUtil.getMySqlDbConnection();
		
		String sql="select * from log_in where username=?";
		try {
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, username);
			ResultSet rs=pst.executeQuery();
			System.out.println(username +password);
			
			while(rs.next()) {
				String passwordCheck=rs.getString("password");
				if(password.equals(passwordCheck)) {
					result=true;
				}else {
					result=false;
				}
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return result;
		
		}
		
	public void addEmployee(Employee employee){
		
		Connection con=DBUtil.getMySqlDbConnection();
		String sql="insert into employee value(?,?,?,?,?,?) ";
		
		
		try {
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(1,employee.getEmployeeId());
			pst.setString(2, employee.getEmployeeName());
			pst.setString(3, employee.getDesignation());
			pst.setInt(4,employee.getSalary());
			pst.setString(5, employee.getGender());
			pst.setString(6, employee.getCity());
			
			int result=pst.executeUpdate();
			if(result==0) {
				System.out.println("Failled");
			}else {
				System.out.println("Inserted Successfully");
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public List<Employee> getAllEmployees(){
		List<Employee> listOfAllEmpoyees=new ArrayList<Employee>();

		//JDBC code
		
		Connection con=DBUtil.getMySqlDbConnection();
		String sql="select * from employee";
		try {
			PreparedStatement pst=con.prepareStatement(sql);
			ResultSet rs= pst.executeQuery();
			while(rs.next()) {
				int employeeId = rs.getInt("employee_id");
				String employeeName = rs.getString("employee_name");
				String designation = rs.getString("designation");
				int salary = rs.getInt("salary");
				String gender = rs.getString("gender");
				String city = rs.getString("city");
				Employee employee = new Employee(employeeId, employeeName, designation, salary, gender, city);
				listOfAllEmpoyees.add(employee);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return listOfAllEmpoyees;	
	}
	
	public void deleteEmployee(int employeeId) {
		
		Connection con =DBUtil.getMySqlDbConnection();
		String sql="delete from employee where employee_id=?";
		
		try {
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(1, employeeId);
			int result = pst.executeUpdate();
			
			if(result==0) {
				System.out.println("Deletion Failed");
			}else {
				System.out.println("Deleted Succesfully");
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	
	public Employee getEmployee(int employeeId) {
		Employee employee=null;
		//jdbc code to connect to db and fetch employee details with this id
		
		Connection con =DBUtil.getMySqlDbConnection();
		String sql="select * from employee where employee_id=?";
		try {
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(1, employeeId);
			
			ResultSet rs=pst.executeQuery();
			if(rs.next()) {
				String employeeName = rs.getString("employee_name");
				String designation = rs.getString("designation");
				int salary = rs.getInt("salary");
				String gender = rs.getString("gender");
				String city = rs.getString("city");

				employee = new Employee(employeeId, employeeName, designation, salary, gender, city);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return employee;
	}
	
	public void updateEmployee(Employee employee) {
		Connection con= DBUtil.getMySqlDbConnection();
		String sql = "update employee set employee_name=?, designation=?, salary=?, gender=?, city=? where employee_id=?";
		try {
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, employee.getEmployeeName());
			pst.setString(2, employee.getDesignation());
			pst.setInt(3,employee.getSalary());
			pst.setString(4, employee.getGender());
			pst.setString(5, employee.getCity());
			pst.setInt(6,employee.getEmployeeId());
			
			int result=pst.executeUpdate();
			if(result==0) {
				System.out.println("Failled");
			}else {
				System.out.println("updated Successfully");
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	

}
