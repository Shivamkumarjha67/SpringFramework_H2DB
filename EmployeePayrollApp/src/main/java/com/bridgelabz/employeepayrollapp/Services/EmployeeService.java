package com.bridgelabz.employeepayrollapp.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.employeepayrollapp.Model.Employee;
import com.bridgelabz.employeepayrollapp.RepositoryLayer.EmployeeRepository;
import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public String saveEmployee(EmployeeDTO employeeDto) {
		Employee employee = new Employee();
		employee.setName(employeeDto.getName());
		employee.setGender(employeeDto.getGender());
		employee.setDepartment(employeeDto.getDepartment());
		employee.setSalary(employeeDto.getSalary());
		
		employeeRepository.save(employee);
		return "Employee added successfully...";
	}

	public List<EmployeeDTO> getAllEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		List<EmployeeDTO> result = new ArrayList<>();
		
		for(Employee employee : employees) {
			EmployeeDTO employeeDTO = new EmployeeDTO();
			employeeDTO.setName(employee.getName());
			employeeDTO.setGender(employee.getGender());
			employeeDTO.setDepartment(employee.getDepartment());
			employeeDTO.setSalary(employee.getSalary());
			
			result.add(employeeDTO);
		}
		
		return result;
	}

	public EmployeeDTO getEmployeeById(Long id) {
		Employee employee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Some problem occured!"));
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setId(employee.getId());
		employeeDTO.setName(employee.getName());
		employeeDTO.setGender(employee.getGender());
		employeeDTO.setDepartment(employee.getDepartment());
		employeeDTO.setSalary(employee.getSalary());
		
		return employeeDTO;
	}

	public String deleteEmployee(Long id) {
		employeeRepository.deleteById(id);
		return "Successfully deleted.";
	}
}