package com.kalelogistics.main.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.kalelogistics.main.domain.Employee;
import com.kalelogistics.main.exception.ResourceNotFoundException;
import com.kalelogistics.main.rowmapper.EmployeeRowMapper;

@Component
public class EmployeeRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final static String INSERT_EMPLOYEE = "INSERT INTO employee_details(name,salary) VALUES(?,?)";
	private final static String UPDATE_EMPLOYEE = "UPDATE employee_details SET name=?,salary=? WHERE employee_id=?";
	private final static String DELETE_EMPLOYEE = "DELETE FROM employee_details WHERE employee_id=?";
	private final static String SELECT_ALL = "SELECT * FROM employee_details";
	private final static String SELECT_ONE = "SELECT * FROM employee_details WHERE employee_id=?";

	public int deleteEmployee(int employeeId) {
		int deleteRowCount = jdbcTemplate.update(DELETE_EMPLOYEE, employeeId);
		return deleteRowCount;
	}

	public int updateEmployee(Employee employee) {
		int updateRowCount = jdbcTemplate.update(UPDATE_EMPLOYEE, employee.getName(), employee.getSalary(),
				employee.getEmployeeId());
		return updateRowCount;
	}

	public int addNewEmployee(Employee employee) {
		int insertRowCount = jdbcTemplate.update(INSERT_EMPLOYEE, employee.getName(), employee.getSalary());
		return insertRowCount;
	}

	public Employee getOneEmployee(int employeeId) {
		EmployeeRowMapper employeeRowMapper = new EmployeeRowMapper();
		try {
			Employee employee = jdbcTemplate.queryForObject(SELECT_ONE, employeeRowMapper, employeeId);
			return employee;
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Employee", "employeeId", "" + employeeId);
		}
	}

	public List<Employee> getAllEmployees() {
		EmployeeRowMapper employeeRowMapper = new EmployeeRowMapper();
		List<Employee> allEmployee = jdbcTemplate.query(SELECT_ALL, employeeRowMapper);
		return allEmployee;
	}
}
