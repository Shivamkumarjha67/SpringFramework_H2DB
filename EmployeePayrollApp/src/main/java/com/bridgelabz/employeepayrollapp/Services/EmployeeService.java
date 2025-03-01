package com.bridgelabz.employeepayrollapp.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.employeepayrollapp.Exception.EmployeeNotFoundException;
import com.bridgelabz.employeepayrollapp.Model.Employee;
import com.bridgelabz.employeepayrollapp.RepositoryLayer.EmployeeRepository;
import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	ArrayList<EmployeeDTO> employeesList = new ArrayList<>();
	
	public String saveEmployee(EmployeeDTO employeeDto) {
		employeesList.add(employeeDto);
		
		Employee employee = new Employee();
		employee.setName(employeeDto.getName());
		employee.setGender(employeeDto.getGender());
		employee.setDepartment(employeeDto.getDepartment());
		employee.setSalary(employeeDto.getSalary());
		
		employeeRepository.save(employee);
		log.info("Employee added to database {} ...", employee.getName());
		return "Employee added successfully...";
	}
	
	public String updateEmployee(EmployeeDTO employeeDto) {
		Optional<Employee> existingEmployee = employeeRepository.findById(employeeDto.getId());

        if (existingEmployee.isPresent()) {
            Employee employee = existingEmployee.get();
            employee.setName(employeeDto.getName());
            employee.setGender(employeeDto.getGender());
            employee.setSalary(employeeDto.getSalary());
            employee.setId(employeeDto.getId());
            employee.setDepartment(employeeDto.getDepartment());
            
            employeeRepository.save(employee);
            return "Employee updated successfully.";
        } else {
            return "Employee not found with ID: " + employeeDto.getId();
        }
	}

	public List<EmployeeDTO> getAllEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		List<EmployeeDTO> result = new ArrayList<>();
		
		log.info("All Employees are retrieved and showed name one by one: ");
		for(Employee employee : employees) {
			EmployeeDTO employeeDTO = new EmployeeDTO();
			employeeDTO.setName(employee.getName());
			employeeDTO.setGender(employee.getGender());
			employeeDTO.setDepartment(employee.getDepartment());
			employeeDTO.setSalary(employee.getSalary());
			
			log.info("Name is: " + employee.getName());
			
			result.add(employeeDTO);
		}
		
		return result;
	}

	public EmployeeDTO getEmployeeById(Long id) {
		Employee employee = employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));
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
		
		for(int i=0; i<employeesList.size(); i++) {
			EmployeeDTO employeeDTO = employeesList.get(i);
			
			if(employeeDTO.getId() == id) {
				employeesList.remove(i);
				log.info("Employee deleted having id {}.", id);
				break;
			}
		}
		
		return "Successfully deleted.";
	}
}