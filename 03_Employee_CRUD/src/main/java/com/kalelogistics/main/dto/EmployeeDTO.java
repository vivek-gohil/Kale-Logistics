package com.kalelogistics.main.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class EmployeeDTO {
	private int employeeId;

	@NotBlank(message = "Employee name cannot be blank or null")
	private String name;

	@Min(value = 5000, message = "Employee salary must be greater than 5000")
	private double salary;

	public EmployeeDTO() {
		// TODO Auto-generated constructor stub
	}

	public EmployeeDTO(int employeeId, String name, double salary) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.salary = salary;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "EmployeeDTO [employeeId=" + employeeId + ", name=" + name + ", salary=" + salary + "]";
	}

}
