package com.kalelogistics.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kalelogistics.main.domain.Employee;

public class EmployeeInjectionMain {
	public static void main(String[] args) {
		// 1. Create spring container object - so that we can inject objects into
		// application
		System.out.println("ApplicationContext - Spring Container - start");
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.kalelogistics.main");
		System.out.println("ApplicationContext - Spring Container - end");

		System.out.println();
		// 2. Inject required objects - Address and Employee
//		System.out.println("Address object injection start");
//		Address address = applicationContext.getBean("address", Address.class);
//		System.out.println("Address object injection end");

		System.out.println();

		System.out.println("Employee object injection start");
		Employee employee = applicationContext.getBean("employee", Employee.class);
		System.out.println("Employee object injection end");

		System.out.println();
		// 3. Print injected objects
		System.out.println(employee);
	}
}
