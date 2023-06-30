package com.ynfinal.finalproject.organization.user.repository;

import com.ynfinal.finalproject.organization.user.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeesRepository
        extends JpaRepository<Employees, Long> {


    // 사원 아이디로 회원정보 조회
    Optional<Employees> findByEmpId(String empId);
    Employees findByEmpNo(Long empNo);


    // 중복체크 기능
    @Override
    boolean existsById(Long empNo);
    boolean existsByEmpId(String empId);
    boolean existsByEmpExtension(String empExtension);
    boolean existsByEmpPhone(String empPhone);



}
