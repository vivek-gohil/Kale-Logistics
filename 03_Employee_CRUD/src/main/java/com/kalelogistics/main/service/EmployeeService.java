package com.kalelogistics.main.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kalelogistics.main.domain.Employee;
import com.kalelogistics.main.dto.EmployeeDTO;
import com.kalelogistics.main.mapper.EmployeeMapper;
import com.kalelogistics.main.repository.EmployeeRepository;

@Component
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public int deleteEmployee(int employeeId) {
		return employeeRepository.deleteEmployee(employeeId);
	}

	public int updateEmployee(EmployeeDTO employeeDTO) {
		Employee employee = EmployeeMapper.mapToEmployee(employeeDTO, new Employee());
		return employeeRepository.updateEmployee(employee);
	}

	public int addNewEmployee(EmployeeDTO employeeDTO) {
		Employee employee = EmployeeMapper.mapToEmployee(employeeDTO, new Employee());
		return employeeRepository.addNewEmployee(employee);
	}

	public EmployeeDTO getOneEmployee(int employeeId) {
		Employee employee = employeeRepository.getOneEmployee(employeeId);
		EmployeeDTO employeeDTO = EmployeeMapper.mapToEmployeeDTO(employee, new EmployeeDTO());
		return employeeDTO;
	}

	public List<EmployeeDTO> getAllEmployees() {
		List<Employee> employeeList = employeeRepository.getAllEmployees();
		List<EmployeeDTO> employeeDTOList = new ArrayList<EmployeeDTO>();

		for (Employee employee : employeeList) {
			employeeDTOList.add(EmployeeMapper.mapToEmployeeDTO(employee, new EmployeeDTO()));
		}
		return employeeDTOList;
	}

}
