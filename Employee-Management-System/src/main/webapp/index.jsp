<%@page import="com.conn.DBConnect"%>
<%@page import="com.dao.EmployeeDAO"%>
<%@page import="com.entity.Employee"%>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Management System</title>
<%@include file="CommonCSS.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
</head>
<body class="bg-light">
<%@include file="Navbar.jsp"%>
<h1 class="text-center">Welcome to EMS</h1>
	<div class="container p-5">
		<c:if test="${not empty SuccessMsg}">
			<p class="text-center text-success">${SuccessMsg}</p>
			<c:remove var="SuccessMsg" />
		</c:if>
		<c:if test="${not empty Error}">
			<p class="text-center text-success">${ErrorMsg}</p>
			<c:remove var="ErrorMsg" />
		</c:if>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">Employee Name</th>
					<th scope="col">Address</th>
					<th scope="col">Gender</th>
					<th scope="col">Salary</th>
					<th scope="col">Date of Birth</th>
				</tr>
			</thead>
			<tbody>
				<%
				EmployeeDAO dao = new EmployeeDAO(DBConnect.getConn());
				List<Employee> list = dao.getAllEmployees();
				for (Employee e : list) {
				%>
				<tr>
					<th scope="row"><%=e.getEmployeeName()%></th>
					<td><%=e.getEmployeeAddress()%></td>
					<td><%=e.getEmployeeGender()==1 ? "Male" : "Female" %> </td>
					<td><%=e.getEmployeeSalary()%></td>
					<td><%=e.getEmployeeDOB()%></td>
					<td><a href="UpdateEmployee.jsp?id=<%=e.getEmployeeID()%>"
						class="btn btn-sm btn-primary">Edit</a> <a
						href="DeleteEmployee?id=<%=e.getEmployeeID()%>"
						class="btn btn-sm btn-danger ms-1" onclick='return  checkDelete()'>Delete</a></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</div>
	<script>
		function checkDelete()
		{
			confirm("Are you sure you want to delete this data?");
		}
	</script>
</body>
</html>