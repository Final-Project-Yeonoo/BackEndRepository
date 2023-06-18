package com.ynfinal.finalproject.organization.user.auth;

// 토큰 발급, 서명 위조 검사 객체

import com.ynfinal.finalproject.organization.user.entity.Employees;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
        // 토큰 생성
        /*
            {
                "iss" "aaa",
                "exp": "2023-07-12",
                "iat": "2023-06-12",
                "email": "로그인한사람 이메일"
                "role" : "Premium"

                == 서명
            }
         */

        // 토큰 만료시간 생성

        Date expiry = Date.from(
                                Instant.now().plus(1, ChronoUnit.DAYS)
                        );

        // 추가 클레임 정의
        Map<String, String> claims = new HashMap<>();
        claims.put("empId", employeesEntity.getEmpId());
        claims.put("empName", employeesEntity.getEmpName());


        return Jwts.builder()
                // token header에 들어갈 서명
                .signWith(
                        Keys.hmacShaKeyFor(SECRET_KEY.getBytes()),
                        SignatureAlgorithm.HS512
                )
                // token payload에 들어갈 클레임 생성
                .setIssuer("여누솔루션") // iss : 발급자 정보
                .setIssuedAt(new Date()) // iat: 발급시간
                .setExpiration(expiry) // exp: 만료시간
                .setSubject(employeesEntity.getEmpId()) // 토큰을 식별할 수 있는 주요
                .setClaims(claims)
                .compact();
    }





}
