package com.project.empmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.empmanagement.entity.Employee;

public interface EmployeeRepository  extends JpaRepository<Employee, Long>{

	@Query("""
			SELECT
			e from Employee e WHERE e.salary>= :salary
			""")
	List<Employee> findEmployeesWithSalaryGreeaterThan(@Param("salary") Double 	salary);
}
