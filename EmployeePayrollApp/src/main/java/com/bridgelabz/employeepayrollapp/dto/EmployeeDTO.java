package com.bridgelabz.employeepayrollapp.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

// Added the getters and setters for the DTO attributes using the Lombok library
@Getter
@Setter
public class EmployeeDTO {
	private Long id;
	@NotBlank(message = "Name can't remain blank")
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Invalid name entered.")
    private String name;
    private String gender;
    private String department;
    private double salary;
}
