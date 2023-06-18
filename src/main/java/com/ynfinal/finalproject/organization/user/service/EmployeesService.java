package com.ynfinal.finalproject.organization.user.service;

import com.ynfinal.finalproject.organization.user.dto.request.EmployeesRequestSignUpDto;
import com.ynfinal.finalproject.organization.user.entity.Employees;
import com.ynfinal.finalproject.organization.user.repository.EmployeesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class EmployeesService {

    private final EmployeesRepository employeesRepository;
    private final PasswordEncoder encoder;

    // 회원가입 처리
    public void create(EmployeesRequestSignUpDto dto){

    }





    public boolean isDuplicate(String empId) {
        return employeesRepository.existsByEmpId(empId);
    }
}
