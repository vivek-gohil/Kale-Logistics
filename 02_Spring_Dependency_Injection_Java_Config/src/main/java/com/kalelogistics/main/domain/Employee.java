package com.kalelogistics.main.domain;

//Every employee has a address
//Every employee has a project
public class Employee {
	private int employeeId;
	private String name;
	private double salary;

	private Address address;

	private Project project;

	public Employee() {
		System.out.println("Default constructor of Employee");
	}

	public Employee(int employeeId, String name, double salary, Address address, Project project) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.salary = salary;
		this.address = address;
		this.project = project;
		System.out.println("Overloaded constructor of Employee");
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", salary=" + salary + ", address=" + address
				+ ", project=" + project + "]";
	}

}
