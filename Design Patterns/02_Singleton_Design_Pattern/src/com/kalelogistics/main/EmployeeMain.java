package com.kalelogistics.main;

import com.kalelogistics.main.domain.Employee;

public class EmployeeMain {
	public static void main(String[] args) {
		System.out.println("main is creating object of Employee class");
		Employee employee1 = new Employee(101, "Dipak", 10000);
		Employee employee2 = new Employee(102, "Suman", 10000);

		System.out.println(employee1.hashCode());
		System.out.println(employee2.hashCode());

		System.out.println(employee1.equals(employee2)); //false
	}
}
