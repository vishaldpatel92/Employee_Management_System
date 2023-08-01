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

@WebServlet("/UpdateEmployee")
public class UpdateEmployeeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String E_Name = req.getParameter("E_Name");
		String E_Address = req.getParameter("E_Address");
		int E_Gender = req.getIntHeader("E_Gender");
		int E_Salary = req.getIntHeader("E_Salary");
		String E_DOB = req.getParameter("E_DOB");
		int E_ID = Integer.parseInt(req.getParameter("E_ID"));
		Employee Employee = new Employee(E_ID, E_Name, E_Address, E_Gender, E_Salary, E_DOB);

		System.out.println(Employee);

		EmployeeDAO dao = new EmployeeDAO(DBConnect.getConn());

		HttpSession session = req.getSession();

		boolean f = dao.UpdateEmployee(Employee);

		if (f) {
			session.setAttribute("SuccessMsg", "Employee updated successfully");
			resp.sendRedirect("index.jsp");
		} else {
			session.setAttribute("ErrorMsg", "Error updating the Employee!");
			resp.sendRedirect("index.jsp");
			// System.out.println("Data not added!");
		}
	}
}
