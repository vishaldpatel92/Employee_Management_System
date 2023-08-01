<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Employee</title>
<%@include file="CommonCSS.jsp"%>

</head>
<body class="bg-light">
	<%@include file="Navbar.jsp"%>
	<h3 class="col-md-5 offset-md-4">Add Employee details below</h3>

	<div class="container">
		<div class="row">
			<div class="col-md-5 offset-md-3">
				<div class="card">
					<div class="card-body">
						<%-- <c:if test="${not empty SuccessMsg}">
							<p class="text-center text-success">${SuccessMsg}</p>
							<c:remove var="SuccessMsg" />
						</c:if>
						<c:if test="${not empty Error}">
							<p class="text-center text-success">${ErrorMsg}</p>
							<c:remove var="ErrorMsg" />
						</c:if> --%>

						<form action="AddEmployee" method="post">
							<div class="d-grid gap-3" style="width: 500px;">
								<div class="col-md-auto">
									<label class="form-label">Employee Name</label> <input
										class="form-control" name="E_Name" type="text"
										placeholder="Name">
								</div>
								<div class="col-md-auto">
									<label class="form-label">Address</label> <input
										class="form-control" name="E_Address" type="text"
										placeholder="Address">
								</div>
								<label class="form-label">Select Gender</label>
								<div class="form-check">
									<input class="form-check-input" type="radio"
										name="Gender" id="E_Male" value="1" checked> 
									<label class="form-check-label" for="E_Gender">
										Male </label>
								</div>
								<div class="form-check">
									<input class="form-check-input" type="radio"
										name="Gender" id="E_Female" value="2">
									<label class="form-check-label" for="E_Gender">
										Female </label>
								</div>
								<div class="col-md-auto">
									<label class="form-label">Salary</label> <input
										class="form-control" name="E_Salary" type="text"
										placeholder="Salary">
								</div>
								<div class="col-md-auto">
									<label class="form-label">Date of Birth</label> <input
										id="endDate" class="form-control" name="E_DOB" type="date" />
									<span id="E_DOB"></span>
								</div>
								<button type="submit" class="btn btn-primary col-md-auto">Submit</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>
