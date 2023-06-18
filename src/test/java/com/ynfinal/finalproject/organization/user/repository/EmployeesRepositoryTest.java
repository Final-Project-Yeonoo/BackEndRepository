package com.ynfinal.finalproject.organization.user.repository;

import com.ynfinal.finalproject.organization.user.entity.Employees;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Rollback
@Transactional
class EmployeesRepositoryTest {

    @Autowired
    EmployeesRepository employeesRepository;

    @Test
    @DisplayName("1번 회원의 중복체크 여부를 확인한다.")
    void existsByIdTest(){
        Long empNo = 1L;
        boolean b = employeesRepository.existsById(empNo);
        assertTrue(b);
    }

}