package com.project.empmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.empmanagement.entity.Department;

public interface DepartmentRepository  extends JpaRepository<Department, Long>{

}
