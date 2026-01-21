package com.kalelogistics.main.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kalelogistics.main.domain.Address;
import com.kalelogistics.main.domain.Employee;
import com.kalelogistics.main.domain.Project;

@Configuration
public class SpringConfiguration {

	public SpringConfiguration() {
		System.out.println("Default constructor of SpringConfiguration");
	}

	@Bean
	public Employee getEmployee() {
		System.out.println("creating employee object");
		Address address = getAddress();
		Project project = getProject();
		Employee employee = new Employee(0, null, 0, address, project);
		return employee;
	}

	@Bean
	public Address getAddress() {
		System.out.println("Creating address object");
		return new Address();
	}

	@Bean
	public Project getProject() {
		System.out.println("Creating Project object");
		return new Project();
	}

}
