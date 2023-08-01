package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.conn.DBConnect;
import com.dao.EmployeeDAO;
import com.entity.Employee;

@WebServlet("/AddEmployee")
public class Register extends HttpServlet {

	// private static final long serialVersionUID = 1L;

	// @Override
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String E_Name = req.getParameter("E_Name");
		String E_Address = req.getParameter("E_Address");
		Integer E_Gender = Integer.parseInt(req.getParameter("E_Gender"));
		Integer E_Salary = Integer.parseInt(req.getParameter("E_Salary"));
		String E_DOB = req.getParameter("E_DOB");
		Employee Employee = new Employee(E_Name, E_Address, E_Gender, E_Salary, E_DOB);

		System.out.println(Employee);

		EmployeeDAO dao = new EmployeeDAO(DBConnect.getConn());

		HttpSession session = req.getSession();

		boolean f = dao.AddEmployee(Employee);

		if (f) {
			session.setAttribute("SuccessMsg", "Employee added successfully");
			resp.sendRedirect("AddEmployee.jsp");
		} else {
			session.setAttribute("ErrorMsg", "Error adding the Employee!");
			resp.sendRedirect("AddEmployee.jsp");
			// System.out.println("Data not added!");
		}
	}
}