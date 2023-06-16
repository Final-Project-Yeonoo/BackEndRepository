package com.ynfinal.finalproject.organization.user.entity;

import com.ynfinal.finalproject.organization.user.repository.EmployeesRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback
class EmployeesTest {

    @Autowired
    EmployeesRepository employeesRepository;


    @Test
    @DisplayName("조인 테스트")
    public void test(){
        Employees employees1 = employeesRepository.findById(1L).orElseThrow();
        System.out.println(employees1.company);
        System.out.println(employees1.position);
        System.out.println(employees1.department);
    }




}