package com.project.empmanagement.service;

import java.util.List;

import com.project.empmanagement.dto.EmployeeReqDto;
import com.project.empmanagement.dto.EmployeeResDto;

public interface EmployeeService {

	EmployeeResDto createEmployee(EmployeeReqDto employeeReqDto);
	
	
	EmployeeResDto getEmployeeById(Long id);
	
	 List<EmployeeResDto>
	    findEmployeesWithSalaryGreaterThan(Double salary);
}
