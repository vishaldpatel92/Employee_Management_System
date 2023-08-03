package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Employee;

public class EmployeeDAO {
	private Connection conn;

	public EmployeeDAO(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean AddEmployee(Employee Employee) {
		boolean f = false;

		try {
			PreparedStatement stmt = conn.prepareStatement(
					"INSERT INTO Employee(Name, Address, Gender, Salary, Birthdate) VALUES (?, ?, ?, ?, ?)");
			stmt.setString(1, Employee.getEmployeeName());
			stmt.setString(2, Employee.getEmployeeAddress());
			stmt.setInt(3, Employee.getEmployeeGender());
			stmt.setInt(4, Employee.getEmployeeSalary());
			stmt.setString(5, Employee.getEmployeeDOB());
			int i = stmt.executeUpdate();

			if (i == 1) {
				f = true;
			}
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public List<Employee> getAllEmployees() {
		List<Employee> Employees = new ArrayList<Employee>();
		try {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Employee");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Employee Employee = new Employee();
				Employee.setEmployeeID(rs.getInt("employeeId"));
				Employee.setEmployeeName(rs.getString("Name"));
				Employee.setEmployeeAddress(rs.getString("Address"));
				Employee.setEmployeeGender(rs.getInt("Gender"));
				Employee.setEmployeeSalary(rs.getInt("Salary"));
				Employee.setEmployeeDOB(rs.getString("Birthdate"));
				Employees.add(Employee);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Employees;
	}

	public Employee getEmployeeById(int id) {
		Employee Employee = null;

		try {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Employee WHERE employeeId = ?");
			stmt.setInt(1, id);
			System.out.println("Id is:" + id);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				Employee = new Employee();
				Employee.setEmployeeID(rs.getInt("employeeId"));
				Employee.setEmployeeName(rs.getString("Name"));
				Employee.setEmployeeAddress(rs.getString("Address"));
				Employee.setEmployeeGender(rs.getInt("Gender"));
				Employee.setEmployeeSalary(rs.getInt("Salary"));
				Employee.setEmployeeDOB(rs.getString("Birthdate"));
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Employee;
	}

	public boolean UpdateEmployee(Employee Employee) {
		boolean f = false;

		try {
			PreparedStatement stmt = conn.prepareStatement(
					"UPDATE Employee SET Name = ?, Address = ?, Gender = ?, Salary = ?, Birthdate = ? WHERE employeeId = ?");
			stmt.setString(1, Employee.getEmployeeName());
			stmt.setString(2, Employee.getEmployeeAddress());
			stmt.setInt(3, Employee.getEmployeeGender());
			stmt.setInt(4, Employee.getEmployeeSalary());
			stmt.setString(5, Employee.getEmployeeDOB());
			stmt.setInt(6, Employee.getEmployeeID());
			int i = stmt.executeUpdate();
			System.out.println("Update executed");

			if (i == 1) {
				f = true;
			}
			// stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public boolean DeleteEmployee(int id) {
		boolean f = false;
		try {
			PreparedStatement stmt = conn.prepareStatement("DELETE FROM Employee WHERE employeeId = ?");
			stmt.setInt(1, id);
			int i = stmt.executeUpdate();
			System.out.println("Update executed");

			if (i == 1) {
				f = true;
			}
			stmt.executeUpdate();
			stmt.close();
		} catch (

		SQLException e) {
			e.printStackTrace();
		}
		return f;
	}

}