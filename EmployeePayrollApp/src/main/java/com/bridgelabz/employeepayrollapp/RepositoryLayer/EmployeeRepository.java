package com.bridgelabz.employeepayrollapp.RepositoryLayer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.employeepayrollapp.Model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}