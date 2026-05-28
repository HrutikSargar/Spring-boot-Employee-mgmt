package com.project.empmanagement.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "employees")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;

	@Column(unique = true)
	private String email;

	private Double salary;
	
//	MANY EMPLOYEED BELONGS TO ONE DEPARTMENT
	@ManyToOne( fetch = FetchType.LAZY)
	@JoinColumn(name = "department_id")
	private Department department;
	
	
//	ONE EMPLOYEE HAS ONE PROFILE
	@OneToOne(mappedBy = "employee" , cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private EmployeeProfile employeeProfile;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "employee_projects", joinColumns = @JoinColumn(name = "employee_id"), inverseJoinColumns = @JoinColumn(name ="project_id"))
	private List<Project> projects = new ArrayList<>();
}


