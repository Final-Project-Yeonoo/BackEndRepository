package com.ynfinal.finalproject.organization.user.auth;

// 토큰 발급, 서명 위조 검사 객체

import com.ynfinal.finalproject.organization.user.entity.Employees;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TokenProvider {


    // 서명에 사용할 값, 512바이트 랜덤문자열
    @Value("${jwt.secret}")
    private String SECRET_KEY;


    // 토큰 생성 메서드

    /**
     * Json Web Token을 생성하는 메서드
     * @param employeesEntity  - 토큰의 내용(클레임) 에 포함될 사원 정보
     * @return - 생성된 json을 암호화한 토큰값
     */
    public String createToken(Employees employeesEntity){
        return "";
    }





}
