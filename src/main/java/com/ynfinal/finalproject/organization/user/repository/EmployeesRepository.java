package com.ynfinal.finalproject.organization.user.repository;

import com.ynfinal.finalproject.organization.user.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeesRepository
        extends JpaRepository<Employees, Long> {



}
