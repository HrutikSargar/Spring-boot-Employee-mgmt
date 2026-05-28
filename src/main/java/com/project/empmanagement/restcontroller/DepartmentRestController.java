package com.project.empmanagement.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.empmanagement.dto.DepartmentReqDto;
import com.project.empmanagement.dto.DepartmentResDto;
import com.project.empmanagement.service.DepartmentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/dept")
@RequiredArgsConstructor
public class DepartmentRestController {

	private final DepartmentService departmentService;
	
	@PostMapping
	public DepartmentResDto createDept(@RequestBody DepartmentReqDto departmentReqDto) {
		return departmentService.createDepartment(departmentReqDto);
	}
	
	@GetMapping("/{id}")
	public DepartmentResDto getDept(@PathVariable  Long  id) {
		return departmentService.getDepartment(id);
	}
}
