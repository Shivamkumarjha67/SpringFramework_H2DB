package com.bridgelabz.employeepayrollapp.dto;

import lombok.Getter;
import lombok.Setter;

// Adding the Getter and Setter using annotation from lambok library
@Getter
@Setter
public class EmployeeDTO {
	private Long id;
    private String name;
    private String gender;
    private String department;
    private double salary;
}
