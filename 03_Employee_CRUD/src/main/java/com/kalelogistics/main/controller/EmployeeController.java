package com.kalelogistics.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kalelogistics.main.dto.EmployeeDTO;
import com.kalelogistics.main.dto.ResponseDTO;
import com.kalelogistics.main.service.EmployeeService;

import jakarta.validation.Valid;

//http://localhost:8080/employeecrudapi
@Validated
@RestController
@RequestMapping("employeecrudapi")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@DeleteMapping("employees/{employeeId}")
	public ResponseEntity<ResponseDTO> deleteEmployee(@PathVariable int employeeId) {
		int deleteRowCount = employeeService.deleteEmployee(employeeId);
		if (deleteRowCount > 0) {
			ResponseDTO successResponseDTO = new ResponseDTO("Employee " + employeeId + " deleted successfully");
			return ResponseEntity.status(HttpStatus.OK).body(successResponseDTO);
		} else {
			ResponseDTO failResponseDTO = new ResponseDTO("Employee with employeeId = " + employeeId + " not found!");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(failResponseDTO);
		}
	}

	@PutMapping("employees")
	public ResponseEntity<ResponseDTO> updateEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
		int updateRowCount = employeeService.updateEmployee(employeeDTO);
		if (updateRowCount > 0) {
			ResponseDTO successResponseDTO = new ResponseDTO(
					"Employee " + employeeDTO.getEmployeeId() + " updated successfully");
			return ResponseEntity.status(HttpStatus.OK).body(successResponseDTO);
		} else {
			ResponseDTO failResponseDTO = new ResponseDTO(
					"Employee with employeeId = " + employeeDTO.getEmployeeId() + " not found!");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(failResponseDTO);
		}
	}

	// http://localhost:8080/employeecrudapi/employees
	@PostMapping("employees")
	public ResponseEntity<ResponseDTO> addNewEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
		int insertRowCount = employeeService.addNewEmployee(employeeDTO);
		if (insertRowCount > 0) {
			ResponseDTO successResponseDTO = new ResponseDTO("Employee added successfully");
			return ResponseEntity.status(HttpStatus.OK).body(successResponseDTO);
		} else {
			ResponseDTO failResponseDTO = new ResponseDTO("Faile to add new employee");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(failResponseDTO);
		}
	}

	@GetMapping("employees/{employeeId}")
	public ResponseEntity<EmployeeDTO> getOneEmployee(@PathVariable int employeeId) {
		EmployeeDTO employeeDTO = employeeService.getOneEmployee(employeeId);
		return ResponseEntity.status(HttpStatus.OK).body(employeeDTO);
	}

	// http://localhost:8080/employeecrudapi/employees
	@GetMapping("employees")
	public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
		return ResponseEntity.status(HttpStatus.OK).body(employeeService.getAllEmployees());
	}
}
