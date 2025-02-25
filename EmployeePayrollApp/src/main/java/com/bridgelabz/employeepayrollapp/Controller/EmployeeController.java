package com.bridgelabz.employeepayrollapp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bridgelabz.employeepayrollapp.Model.Employee;
import com.bridgelabz.employeepayrollapp.Services.EmployeeService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		Employee employee2 =  employeeService.saveEmployee(employee);
		return ResponseEntity.ok(employee2);
		
//		try {
//			Employee employee2 =  employeeService.saveEmployee(employee);
//			return ResponseEntity.ok(employee2);
//		} catch (RuntimeException e) {
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
//		}
	}

	@GetMapping
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	@GetMapping("/{id}")
	public Optional<Employee> getEmployeeById(@PathVariable Long id) {
		return employeeService.getEmployeeById(id);
	}

	@DeleteMapping("/{id}")
	public void deleteEmployee(@PathVariable Long id) {
		employeeService.deleteEmployee(id);
	}
}