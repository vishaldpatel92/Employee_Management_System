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

@WebServlet("/DeleteEmployee")
public class DeleteEmployeeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int E_ID = Integer.parseInt(req.getParameter("id"));
		EmployeeDAO dao = new EmployeeDAO(DBConnect.getConn());
		boolean f = dao.DeleteEmployee(E_ID);
		HttpSession session = req.getSession();

		if (f) {
			resp.sendRedirect("index.jsp");
		} else {
			session.setAttribute("ErrorMsg", "Error deleting the Employee!");
			resp.sendRedirect("index.jsp");
			// System.out.println("Data not added!");
		}
	}

}
