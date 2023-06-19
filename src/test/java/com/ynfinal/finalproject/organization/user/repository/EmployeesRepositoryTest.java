package com.ynfinal.finalproject.organization.user.repository;

import com.ynfinal.finalproject.organization.user.entity.Authorization;
import com.ynfinal.finalproject.organization.user.entity.Employees;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Rollback
@Transactional
class EmployeesRepositoryTest {

    @Autowired
    EmployeesRepository employeesRepository;
    @Autowired
    AuthorizationRepository authorizationRepository;

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
    @DisplayName("사원아이디 중복체크를 하면 중복이 되어야함")
    void empId(){
        String empId = "camp@camp.com";

        boolean flag = employeesRepository.existsByEmpId(empId);
        assertTrue(flag);
    }


    @Test
    @DisplayName("이메일로 회원조회")
    void findId(){

        //given
        String empId = "camp@camp.com";

        Optional<Employees> employeesOptional = employeesRepository.findByEmpId(empId);

        assertTrue(employeesOptional.isPresent());
        Employees employees = employeesOptional.get();
        assertEquals("안녕안녕", employees.getEmpName());

    }

    @Test
    @DisplayName("사원을 등록을 성공해야 한다.")
    void registerTest(){
        Employees employees = Employees.builder()
                .empId("camping@camp.com")
                .empPassword(encoder.encode("aaa111!!!"))
                .empName("안녕안녕")
                .empHiredDate(LocalDateTime.now())
                .empPhone("010-1111-1112")
                .empExtension("1112")
                .build();

        Employees employees1 = employeesRepository.save(employees);
        assertEquals("camping@camp.com", employees1.getEmpId());

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