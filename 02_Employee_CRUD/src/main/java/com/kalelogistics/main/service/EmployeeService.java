package com.kalelogistics.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kalelogistics.main.domain.Employee;
import com.kalelogistics.main.repository.EmployeeRepository;

@Component
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public int deleteEmployee(int employeeId) {
		return employeeRepository.deleteEmployee(employeeId);
	}

	public int updateEmployee(Employee employee) {
		return employeeRepository.updateEmployee(employee);
	}

	public int addNewEmployee(Employee employee) {
		return employeeRepository.addNewEmployee(employee);
	}

	public Employee selectOneEmployee(int employeeId) {
//		Employee employee = employeeRepository.getEmployee(employeeId);
//		return employee;
		return employeeRepository.getEmployee(employeeId);
	}

	public List<Employee> selectAllEmployees() {
//		List<Employee> allEmployees = employeeRepository.getAllEmployees();
//		return allEmployees;

		return employeeRepository.getAllEmployees();
	}
}
