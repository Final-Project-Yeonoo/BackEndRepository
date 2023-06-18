package com.ynfinal.finalproject.organization.user.service;

import com.ynfinal.finalproject.organization.user.repository.EmployeesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class EmployeesService {

    private final EmployeesRepository employeesRepository;


    public boolean isDuplicate(String empId) {
        return employeesRepository.existsByEmpId(empId);
    }
}
