package com.project.empmanagement.restcontroller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.empmanagement.dto.EmployeeReqDto;
import com.project.empmanagement.dto.EmployeeResDto;
import com.project.empmanagement.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/emp")
@RequiredArgsConstructor
public class EmployeeRestController {

	private final EmployeeService employeeService;
	
	@PostMapping
	public EmployeeResDto createEmployee(@RequestBody EmployeeReqDto employeeReqDto) {
		 return employeeService.createEmployee(employeeReqDto);
	}
	
	@GetMapping("/{id}")
	public EmployeeResDto getEmployee(@PathVariable Long id) {
		return employeeService.getEmployeeById(id);
	}
	
	@GetMapping("/salary")
	public ResponseEntity<List<EmployeeResDto>> getEmployeedBySalary(@RequestParam Double salary){
		return ResponseEntity.ok(employeeService.findEmployeesWithSalaryGreaterThan(salary));
	}
}
