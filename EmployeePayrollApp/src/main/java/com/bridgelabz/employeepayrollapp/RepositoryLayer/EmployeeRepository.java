package com.bridgelabz.employeepayrollapp.RepositoryLayer;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bridgelabz.employeepayrollapp.Model.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}