package com.kalelogistics.main;

import com.kalelogistics.main.builder.EmployeeBuilder;
import com.kalelogistics.main.domain.Employee;

public class EmployeeBuilderMain {
	public static void main(String[] args) {
		Employee employee = new EmployeeBuilder().employeeId(101).name("Vivek").salary(1000).addressId("B2002")
				.block("Casa Belvedere").street("M. G. Raod").city("Mumbai").pin("400012").build();

		System.out.println(employee);

		System.out.println("---------------------");

		Employee employee2 = new EmployeeBuilder().employeeId(102).name("Dipak").addressId("B2003").city("Chennai")
				.build();
		System.out.println(employee2);
	}
}
