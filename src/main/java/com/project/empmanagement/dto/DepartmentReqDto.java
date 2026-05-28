package com.project.empmanagement.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class DepartmentReqDto{
	
	@NotBlank(message =  "dept name is req")
	private String name;

}
