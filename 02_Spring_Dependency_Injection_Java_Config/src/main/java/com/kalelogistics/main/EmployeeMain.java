package com.kalelogistics.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kalelogistics.main.config.SpringConfiguration;
import com.kalelogistics.main.domain.Employee;

public class EmployeeMain {
	public static void main(String[] args) {
		// 1. Create spring container - Spring Factory
		System.out.println("Spring Container - start");
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
		System.out.println("Spring Container - end");

		System.out.println();
		Employee employee = applicationContext.getBean(Employee.class);

		System.out.println();
		System.out.println(employee);
	}
}
