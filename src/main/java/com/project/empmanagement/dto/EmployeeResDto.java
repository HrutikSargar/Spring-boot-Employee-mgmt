package com.project.empmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class EmployeeResDto {

	private String name;
	

	private String email;

	private Double salary;
	
	private String  department_name;
}