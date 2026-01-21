package com.kalelogistics.main.contrller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kalelogistics.main.domain.Employee;
import com.kalelogistics.main.service.EmployeeService;

//http://localhost:8080/employeecrudapi
@RestController
@RequestMapping("employeecrudapi")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	// http://localhost:8080/employeecrudapi/employees
	@GetMapping("employees") // Select
	public List<Employee> getAllEmployees() {
		return employeeService.selectAllEmployees();
	}

	// http://localhost:8080/employeecrudapi/employees/{employeeId}
	@GetMapping("employees/{employeeId}") // Select
	public Employee getOneEmployee(@PathVariable int employeeId) {
		return employeeService.selectOneEmployee(employeeId);
	}

	// http://localhost:8080/employeecrudapi/employees
	@PostMapping("employees") // Insert
	public int addNewEmployee(@RequestBody Employee employee) {
		return employeeService.addNewEmployee(employee);
	}

	// Create put mapping to update employee name and salary
	@PutMapping("employees")
	public int updateEmployee(@RequestBody Employee employee) {
		return employeeService.updateEmployee(employee);
	}
	// Create delete mapping to delete employee

	@DeleteMapping("employees/{employeeId}") //
	public int deleteEmployeeByEmployeeId(@PathVariable int employeeId) {
		return employeeService.deleteEmployee(employeeId);
	}

}
