package com.ynfinal.finalproject.config;

import com.ynfinal.finalproject.organization.user.filter.JwtAuthFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.filter.CorsFilter;

@EnableWebSecurity // 웹보안 관련 설정을 이파일을 기반으로 적용
@RequiredArgsConstructor
public class SecurityConfig {


    private final JwtAuthFilter jwtAuthFilter;

    // 비밀번호 암호화 객체 빈 등록
    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }


    // 시큐리티 기본 설정을 처리하는 빈 등록
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // 시큐리티 설치 시 초기에 뜨는 강제 인증을 해제
        http
                .cors()
                .and()
                .csrf().disable()
                .httpBasic()
                .and()
                .sessionManagement() // 세션 인증은 사용하지 않겠다
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
               // .antMatchers(HttpMethod.PUT, "/api/auth/promote").authenticated()
               // .antMatchers("/api/auth/load-profile").authenticated()
               // .antMatchers("/*", "/api/auth/**").permitAll()
//                .anyRequest().authenticated();
                .anyRequest().permitAll();

         // 토큰인증 필터 연결
            http.addFilterAfter(
                    jwtAuthFilter
                    , CorsFilter.class
            );


        return http.build();
    }

}
