package com.project.empmanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.empmanagement.dto.EmployeeReqDto;
import com.project.empmanagement.dto.EmployeeResDto;
import com.project.empmanagement.entity.Department;
import com.project.empmanagement.entity.Employee;
import com.project.empmanagement.repository.DepartmentRepository;
import com.project.empmanagement.repository.EmployeeRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository employeeRepository;

	private final DepartmentRepository departmentRepository;

	private EmployeeResDto mapToDto(Employee employee) {
		return EmployeeResDto.builder().name(employee.getName()).email(employee.getEmail()).salary(employee.getSalary())
				.department_name(employee.getDepartment().getName()).build();
	}

	@Override
	public EmployeeResDto createEmployee(EmployeeReqDto employeeReqDto) {

		Department department = departmentRepository.findById(employeeReqDto.getDepartment_id())
				.orElseThrow(() -> new RuntimeException("Department not foud"));

		Employee create = Employee.builder().name(employeeReqDto.getName()).email(employeeReqDto.getEmail())
				.salary(employeeReqDto.getSalary()).department(department).build();

		return mapToDto(employeeRepository.save(create));
	}

	@Override
	public EmployeeResDto getEmployeeById(Long id) {
		return mapToDto(employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found")));
	}

	@Override
	public List<EmployeeResDto> findEmployeesWithSalaryGreaterThan(Double salary) {
		List<Employee> list = employeeRepository.findEmployeesWithSalaryGreeaterThan(salary);

		return list.stream().map(emp -> EmployeeResDto.builder().name(emp.getName()).email(emp.getEmail())
				.salary(emp.getSalary()).department_name(emp.getDepartment().getName()).build()).toList();
		
	}

}
