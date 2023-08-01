package com.entity;

public class Employee {
	private int employeeID;
	private String employeeName;
	private String employeeAddress;
	private Integer employeeGender;
	private Integer employeeSalary;
	private String employeeDOB;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String employeeName, String employeeAddress, Integer employeeGender, Integer employeeSalary,
			String employeeDOB) {
		super();
		this.employeeName = employeeName;
		this.employeeAddress = employeeAddress;
		this.employeeGender = employeeGender;
		this.employeeSalary = employeeSalary;
		this.employeeDOB = employeeDOB;
	}

	public Employee(int employeeID, String employeeName, String employeeAddress, Integer employeeGender,
			Integer employeeSalary, String employeeDOB) {
		super();
		this.employeeID = employeeID;
		this.employeeName = employeeName;
		this.employeeAddress = employeeAddress;
		this.employeeGender = employeeGender;
		this.employeeSalary = employeeSalary;
		this.employeeDOB = employeeDOB;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeAddress() {
		return employeeAddress;
	}

	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}

	public Integer getEmployeeGender() {
		return employeeGender;
	}

	public void setEmployeeGender(Integer employeeGender) {
		this.employeeGender = employeeGender;
	}

	public Integer getEmployeeSalary() {
		return employeeSalary;
	}

	public void setEmployeeSalary(Integer employeeSalary) {
		this.employeeSalary = employeeSalary;
	}

	public String getEmployeeDOB() {
		return employeeDOB;
	}

	public void setEmployeeDOB(String employeeDOB) {
		this.employeeDOB = employeeDOB;
	}

}