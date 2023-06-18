package com.ynfinal.finalproject.organization.user.repository;

import com.ynfinal.finalproject.organization.user.entity.Authorization;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Rollback
@Transactional
class AuthorizationRepositoryTest {
    
    @Autowired
    AuthorizationRepository authorizationRepository;
    
    @Test
    void test(){
        List<Authorization> all = authorizationRepository.findAll();

        Authorization byEmployeesEmpNo = authorizationRepository.findByEmployees_EmpNo(1L);
        
        
//        for (Authorization authorization : all) {
//            System.out.println(authorization);
//        }
        System.out.println("byEmployeesEmpNo = " + byEmployeesEmpNo);
        System.out.println("byEmployeesEmpNo.getEmployees() = " + byEmployeesEmpNo.getEmployees());
    }
    
    
    
}