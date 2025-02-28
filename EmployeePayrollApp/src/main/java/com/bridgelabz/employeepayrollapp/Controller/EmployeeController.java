package com.bridgelabz.employeepayrollapp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bridgelabz.employeepayrollapp.Services.EmployeeService;
import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/post")
	public ResponseEntity<String> addEmployee(@RequestBody EmployeeDTO employeeDto) {
		try {
			return ResponseEntity.ok(employeeService.saveEmployee(employeeDto));
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

	@GetMapping("/getAll")
	public List<EmployeeDTO> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(employeeService.getEmployeeById(id));
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(employeeService.deleteEmployee(id));
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
}