package com.kalelogistics.main.builder;

import com.kalelogistics.main.domain.Address;
import com.kalelogistics.main.domain.Employee;

public class EmployeeBuilder {
	private Employee employee;

	public EmployeeBuilder() {
		employee = new Employee();
		Address address = new Address();
		employee.setAddress(address);
	}

	public EmployeeBuilder employeeId(int employeeId) {
		employee.setEmployeeId(employeeId);
		return this;
	}

	public EmployeeBuilder name(String name) {
		employee.setName(name);
		return this;
	}

	public EmployeeBuilder salary(double salary) {
		employee.setSalary(salary);
		return this;
	}

	public EmployeeBuilder addressId(String addressId) {
		employee.getAddress().setAddressId(addressId);
		return this;
	}

	public EmployeeBuilder houseNumber(String houseNumber) {
		employee.getAddress().setHouseNumber(houseNumber);
		return this;
	}

	public EmployeeBuilder block(String block) {
		employee.getAddress().setBlock(block);
		return this;
	}

	public EmployeeBuilder street(String street) {
		employee.getAddress().setStreet(street);
		return this;
	}

	public EmployeeBuilder pin(String pin) {
		employee.getAddress().setPin(pin);
		return this;
	}

	public EmployeeBuilder city(String city) {
		employee.getAddress().setCity(city);
		return this;
	}

	public Employee build() {
		return employee;
	}
}
