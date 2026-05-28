package com.project.empmanagement.service;

import org.springframework.stereotype.Service;

import com.project.empmanagement.dto.DepartmentReqDto;
import com.project.empmanagement.dto.DepartmentResDto;
import com.project.empmanagement.entity.Department;
import com.project.empmanagement.repository.DepartmentRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DepartmentServiceImpl implements DepartmentService{

	private final DepartmentRepository departmentRepository;
	
	private DepartmentResDto mapToDto(Department department) {
		return DepartmentResDto.builder().name(department.getName()).id(department.getId()).build();
	}
	@Override
	public DepartmentResDto createDepartment(DepartmentReqDto departmentReqDto) {
		Department department = Department.builder().name(departmentReqDto.getName()).build();
		
		return mapToDto(departmentRepository.save(department));
		
	}
	@Override
	public DepartmentResDto getDepartment(Long id) {
		
		 return mapToDto( departmentRepository.findById(id).orElseThrow(()-> new RuntimeException(" No deprt found")));
	}

	
}
