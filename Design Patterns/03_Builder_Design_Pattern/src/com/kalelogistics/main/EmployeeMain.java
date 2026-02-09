package com.kalelogistics.main;

import com.kalelogistics.main.domain.Address;
import com.kalelogistics.main.domain.Employee;

public class EmployeeMain {
	public static void main(String[] args) {

		// Create employee object and set values
		Employee employee = new Employee();
		employee.setEmployeeId(101);
		employee.setName("Seema");
		employee.setSalary(90000);

		Address address = new Address();
		address.setAddressId("A3001");
		address.setBlock("Casa Belvedere - G wing");
		address.setStreet("M.G. Road");
		address.setHouseNumber("1233");
		address.setCity("Mumbai");
		address.setPin("4000012");

		employee.setAddress(address);

		System.out.println(employee);

	}
}
