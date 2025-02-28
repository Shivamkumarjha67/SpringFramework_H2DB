package com.bridgelabz.employeepayrollapp.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "employee_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // value maintained by database, not spring
    private Long id;

    private String name;
    private String gender;
    private String department;
    private double salary;
}







//@Entity
//@Table(name = "employee_details")
//public class Employee {
//    public Employee() {
//		super();
//	}
//	public Long getId() {
//		return id;
//	}
//	public void setId(Long id) {
//		this.id = id;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getGender() {
//		return gender;
//	}
//	public void setGender(String gender) {
//		this.gender = gender;
//	}
//	public String getDepartment() {
//		return department;
//	}
//	public void setDepartment(String department) {
//		this.department = department;
//	}
//	public double getSalary() {
//		return salary;
//	}
//	public void setSalary(double salary) {
//		this.salary = salary;
//	}
//	
//	@Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)     // value maintained by database, not spring
//    private Long id;
//
//    private String name;
//    private String gender;
//    private String department;
//    private double salary;
//}