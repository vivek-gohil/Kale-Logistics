package com.kalelogistics.main;

import com.kalelogistics.main.domain.Address;
import com.kalelogistics.main.domain.Employee;

public class EmployeeMain {
	public static void main(String[] args) {
		//Dependent object
		
		// Create address object by passing parameters - overloaded constructor
		Address address = new Address(101, "B-212 Woodland Park", "Sardar Patel Road", "Baroda", 400123);
		// print address object using sysout
		System.out.println(address);

		
		//Employee is depend on Address 
		//If you want Employee object you need to create Address object first and then create Employee object.
		// Create employee object by passing parameters - overloaded constructor
		//Employee employee = new Employee(1, "Dipak Ragiya", 9000000, address);
		// print employee object using sysout
		//System.out.println(employee);

	}
}
