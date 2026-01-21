package com.kalelogistics.main.mapper;

import com.kalelogistics.main.domain.Employee;
import com.kalelogistics.main.dto.EmployeeDTO;

public class EmployeeMapper {
	private EmployeeMapper() {
	}

	public static Employee mapToEmployee(EmployeeDTO employeeDTO, Employee employee) {
		if (employeeDTO != null) {
			employee.setEmployeeId(employeeDTO.getEmployeeId());
			employee.setName(employeeDTO.getName());
			employee.setSalary(employeeDTO.getSalary());
			return employee;
		}
		return null;
	}

	public static EmployeeDTO mapToEmployeeDTO(Employee employee, EmployeeDTO employeeDTO) {
		if (employee != null) {
			employeeDTO.setEmployeeId(employee.getEmployeeId());
			employeeDTO.setName(employee.getName());
			employeeDTO.setSalary(employee.getSalary());
			return employeeDTO;
		}
		return null;
	}
}
