package com.project.empmanagement.service;

import java.util.List;

import com.project.empmanagement.dto.DepartmentReqDto;
import com.project.empmanagement.dto.DepartmentResDto;

public interface DepartmentService {

	DepartmentResDto createDepartment(DepartmentReqDto departmentReqDto);
	
	DepartmentResDto getDepartment(Long id);
}
