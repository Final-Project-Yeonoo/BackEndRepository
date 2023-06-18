package com.ynfinal.finalproject.organization.user.repository;

import com.ynfinal.finalproject.organization.user.entity.Employees;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Rollback
@Transactional
class EmployeesRepositoryTest {

    @Autowired
    EmployeesRepository employeesRepository;

    @Autowired
    PasswordEncoder encoder;

    @Test
    @DisplayName("1번 회원의 중복체크 여부를 확인한다.")
    void existsByIdTest(){
        Long empNo = 1L;
        boolean b = employeesRepository.existsById(empNo);
        assertTrue(b);
    }

    @Test
    @DisplayName("사원을 등록을 성공해야 한다.")
    void registerTest(){
        Employees employees = Employees.builder()
                .empId("camp@camp.com")
                .empPassword(encoder.encode("aaa111!!!"))
                .empName("안녕안녕")
                .empHiredDate(LocalDateTime.now())
                .empPhone("010-1111-1111")
                .empExtension("1111")
                .build();

        Employees employees1 = employeesRepository.save(employees);
        assertEquals("camp@camp.com", employees1.getEmpId());

    }

    @Test
    @DisplayName("비밀번호 암호화 테스트")
    void encodingTest(){

        String rawPassword = "aaa111!!!";
        String encodePassword = encoder.encode(rawPassword);
        System.out.println("rawPassword = " + rawPassword);
        System.out.println("encodePassword = " + encodePassword);

    }


}