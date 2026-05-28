package com.project.empmanagement.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeReqDto {

	@NotBlank(message  = "Name is req")
	private String name;
	
	@Email
	@NotBlank(message = "email is req")
	private String email;
	
	@NotNull( message = "salary is req")
	@Min(value = 1)
	private Double salary;
	
	
//	DEPARTMENT FOREIGN KEY
	@NotNull(message = "department id is req")
	private Long department_id ;
}
