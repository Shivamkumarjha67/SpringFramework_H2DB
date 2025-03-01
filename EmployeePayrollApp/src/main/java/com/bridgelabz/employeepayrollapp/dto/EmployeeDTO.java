package com.bridgelabz.employeepayrollapp.dto;

import lombok.Getter;
import lombok.Setter;

// Added the getters and setters for the DTO attributes using the Lombok library
@Getter
@Setter
public class EmployeeDTO {
	private Long id;
    private String name;
    private String gender;
    private String department;
    private double salary;
}
