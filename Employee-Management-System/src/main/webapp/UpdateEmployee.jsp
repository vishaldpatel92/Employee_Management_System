<%@page import="com.conn.DBConnect"%>
<%@page import="com.dao.EmployeeDAO"%>
<%@page import="com.entity.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Employee Details</title>
<%@include file="CommonCSS.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>

</head>
<body class="bg-light">
	<%@include file="Navbar.jsp"%>
	<h3 class="col-md-5 offset-md-4">Update Employee details below</h3>

	<div class="container">
		<div class="row">
			<div class="col-md-5 offset-md-3">
				<div class="card">
					<div class="card-body">
						<c:if test="${not empty SuccessMsg}">
							<p class="text-center text-success">${SuccessMsg}</p>
							<c:remove var="SuccessMsg" />
						</c:if>
						<c:if test="${not empty Error}">
							<p class="text-center text-success">${ErrorMsg}</p>
							<c:remove var="ErrorMsg" />
						</c:if>
						<%
						/* String idString = request.getParameter("id");
						int id = 0; // Default value if the string is null

						if (idString != null) {
						    id = Integer.parseInt(idString);
						}  */
			int id = Integer.parseInt(request.getParameter("id")) ;
			EmployeeDAO dao = new EmployeeDAO(DBConnect.getConn());
			//System.out.println("DB call from JSP");
			Employee e = dao.getEmployeeById(id);
			%>
						<form action="UpdateEmployee" method="post">
							<div class="d-grid gap-3" style="width: 500px;">
								<div class="col-md-auto">
									<label class="form-label">Employee Name</label> <input
										class="form-control" name="E_Name" type="text" value = "<%e.getEmployeeName(); %>"
										placeholder="Name">
								</div>
								<div class="col-md-auto">
									<label class="form-label">Address</label> <input
										class="form-control" name="E_Address" type="text" value = "<%e.getEmployeeAddress(); %>"
										placeholder="Address">
								</div>
								<label class="form-label">Select Gender</label>
								<div class="form-check">
									<input class="form-check-input" type="radio"
										name="E_Gender" id="E_Male" value="1" checked> 
									<label class="form-check-label" for="E_Male">
										Male </label>
								</div>
								<div class="form-check">
									<input class="form-check-input" type="radio"
										name="E_Gender" id="E_Female" value="2">
									<label class="form-check-label" for="E_Female">
										Female </label>
								</div>
								<div class="col-md-auto">
									<label class="form-label">Salary</label> <input
										class="form-control" name="E_Salary" type="text" value = "<%e.getEmployeeSalary(); %>"
										placeholder="Salary">
								</div>
								<div class="col-md-auto">
									<label class="form-label">Date of Birth</label> <input
										id="endDate" class="form-control" name="E_DOB" type="date" value = "<%e.getEmployeeDOB(); %>"/>
									<span id="E_DOB"></span>
								</div>
								
								<input type="hidden" name="E_ID" value="<%=e.getEmployeeID()%>">

								<button type="submit" class="btn btn-primary col-md-auto">Update
									Employee</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>