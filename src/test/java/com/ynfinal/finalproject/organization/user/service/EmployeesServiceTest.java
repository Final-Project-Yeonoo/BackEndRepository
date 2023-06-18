package com.ynfinal.finalproject.organization.user.service;

import com.ynfinal.finalproject.organization.user.dto.request.EmployeesLoginRequestDto;
import com.ynfinal.finalproject.organization.user.dto.request.EmployeesSignUpRequestDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Base64;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback
class EmployeesServiceTest {


    @Autowired
    EmployeesService employeesService;

    @Test
    @DisplayName("중복된 아이디(이메일)로 회원가입을 시도하면 Exception이 발생한다" )
    void validdateIdTest(){

        String empId = "camp@camp.com";

        EmployeesSignUpRequestDto dto = EmployeesSignUpRequestDto.builder()
                .empId(empId)
                .empPassword("aaa111!!!")
                .empName("John Doe")
                .empHiredDate(LocalDateTime.now())
                .empPhone("123-456-7890")
                .empExtension("123")
                .empProfile("profile.png")
                .build();

        assertThrows(RuntimeException.class,
                () -> {employeesService.create(dto);});


    }


    @Test
    @DisplayName("토큰 서명 해시값 생성하기")
    void makeSecretKey(){
        SecureRandom random = new SecureRandom();
        byte[] key = new byte[64];  // 64byte = 512bit
        random.nextBytes(key);
        String encodedKey = Base64.getEncoder().encodeToString(key);
        System.out.println("\n\n\n");
        System.out.println(encodedKey);
        System.out.println("\n\n\n");

    }
}