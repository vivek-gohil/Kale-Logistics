package com.kalelogistics.main.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.kalelogistics.main.domain.Employee;

@Component
public class EmployeeRepository {
	private String url = "jdbc:oracle:thin:@localhost:1521/FREEPDB1";
	private String username = "springtraining";
	private String password = "springtraining";
	private String driverClass = "oracle.jdbc.driver.OracleDriver";

	private String selectAllEmployees = "SELECT * FROM employee_details";
	private String selectOneEmployee = "SELECT * FROM employee_details where employee_id=?";
	private String addNewEmployee = "INSERT INTO employee_details(name,salary) VALUES(?,?)";
	private String deleteEmployee = "DELETE FROM employee_details WHERE employee_id=?";
	private String updateEmployee = "UPDATE employee_details SET name=?,salary=? WHERE employee_id=?";
	
	// Connect database
	private Connection connection = null;
	// Write/Store and execute SQL Query
	private PreparedStatement preparedStatement = null;
	// Store Data retrived
	private ResultSet resultSet = null;

	// add new employee
	public int addNewEmployee(Employee employee) {
		try {
			// 1. Load Driver
			Class.forName(driverClass);
			System.out.println("Driver Loaded Successfully!!");

			// 2. Connect Database
			connection = DriverManager.getConnection(url, username, password);
			if (connection != null) {
				System.out.println("Connection successfull");
				preparedStatement = connection.prepareStatement(addNewEmployee);
				preparedStatement.setString(1, employee.getName());
				preparedStatement.setDouble(2, employee.getSalary());

				int numberOfRowsInserted = preparedStatement.executeUpdate();
				return numberOfRowsInserted;
			}

		} catch (ClassNotFoundException e) {
			System.out.println("Failed to load driver");
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println("Failed to connect database");
			System.out.println(e.getMessage());
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
					System.out.println("Failed to close connection");
				}
		}
		return 0;
	}

	// update employee
	public int updateEmployee(Employee employee) {
		try {
			// 1. Load Driver
			Class.forName(driverClass);
			System.out.println("Driver Loaded Successfully!!");

			// 2. Connect Database
			connection = DriverManager.getConnection(url, username, password);
			if (connection != null) {
				System.out.println("Connection successfull");
				preparedStatement = connection.prepareStatement(updateEmployee);
				preparedStatement.setString(1, employee.getName());
				preparedStatement.setDouble(2, employee.getSalary());
				preparedStatement.setInt(3, employee.getEmployeeId());

				int numberOfRowsUpdated = preparedStatement.executeUpdate();
				return numberOfRowsUpdated;
			}

		} catch (ClassNotFoundException e) {
			System.out.println("Failed to load driver");
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println("Failed to connect database");
			System.out.println(e.getMessage());
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
					System.out.println("Failed to close connection");
				}
		}
		return 0;
	}

	// delete employee
	public int deleteEmployee(int employeeId) {
		try {
			// 1. Load Driver
			Class.forName(driverClass);
			System.out.println("Driver Loaded Successfully!!");

			// 2. Connect Database
			connection = DriverManager.getConnection(url, username, password);
			if (connection != null) {
				System.out.println("Connection successfull");
				preparedStatement = connection.prepareStatement(deleteEmployee);
				preparedStatement.setInt(1, employeeId);

				int numberOfRowsDeleted = preparedStatement.executeUpdate();
				return numberOfRowsDeleted;
			}

		} catch (ClassNotFoundException e) {
			System.out.println("Failed to load driver");
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println("Failed to connect database");
			System.out.println(e.getMessage());
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
					System.out.println("Failed to close connection");
				}
		}
		return 0;
	}

	// select all employees
	public List<Employee> getAllEmployees() {

		try {
			// 1. Load Driver
			Class.forName(driverClass);
			System.out.println("Driver Loaded Successfully!!");

			// 2. Connect Database
			connection = DriverManager.getConnection(url, username, password);
			if (connection != null) {
				System.out.println("Connection successfull");
				preparedStatement = connection.prepareStatement(selectAllEmployees);
				resultSet = preparedStatement.executeQuery();

				// Empty list
				List<Employee> employeeList = new ArrayList<Employee>();
				while (resultSet.next()) {

					int employeeId = resultSet.getInt("employee_id");
					String name = resultSet.getString("name");
					double salary = resultSet.getDouble("salary");
					Employee employee = new Employee(employeeId, name, salary);
					employeeList.add(employee);
				}
				return employeeList;
			}

		} catch (ClassNotFoundException e) {
			System.out.println("Failed to load driver");
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println("Failed to connect database");
			System.out.println(e.getMessage());
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
					System.out.println("Failed to close connection");
				}
		}
		return null;
	}

	// select one employee
	public Employee getEmployee(int employeeId) {
		try {
			// 1. Load Driver
			Class.forName(driverClass);
			System.out.println("Driver Loaded Successfully!!");

			// 2. Connect Database
			connection = DriverManager.getConnection(url, username, password);
			if (connection != null) {
				System.out.println("Connection successfull");
				preparedStatement = connection.prepareStatement(selectOneEmployee);
				preparedStatement.setInt(1, employeeId);

				resultSet = preparedStatement.executeQuery();

				if (resultSet.next()) {
					employeeId = resultSet.getInt("employee_id");
					String name = resultSet.getString("name");
					double salary = resultSet.getDouble("salary");

					Employee employee = new Employee(employeeId, name, salary);
					return employee;
				}
			}

		} catch (ClassNotFoundException e) {
			System.out.println("Failed to load driver");
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println("Failed to connect database");
			System.out.println(e.getMessage());
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
					System.out.println("Failed to close connection");
				}
		}
		return null;
	}
}
