package com.ynfinal.finalproject.organization.user.repository;

import com.ynfinal.finalproject.organization.user.entity.Department;
import com.ynfinal.finalproject.organization.user.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;



public interface DepartmentRepository
        extends JpaRepository<Department, Long> {



}
