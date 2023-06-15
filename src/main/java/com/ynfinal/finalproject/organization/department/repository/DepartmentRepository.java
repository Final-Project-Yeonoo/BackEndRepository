package com.ynfinal.finalproject.organization.department.repository;

import com.ynfinal.finalproject.organization.department.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository
        extends JpaRepository<Department, String> {

}
