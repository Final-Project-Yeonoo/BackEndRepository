package com.ynfinal.finalproject.organization.user.service;

import com.ynfinal.finalproject.organization.user.auth.TokenProvider;
import com.ynfinal.finalproject.organization.user.dto.request.EmployeesLoginRequestDto;
import com.ynfinal.finalproject.organization.user.dto.request.EmployeesSignUpRequestDto;
import com.ynfinal.finalproject.organization.user.dto.response.EmployeesSignUpResponseDTO;
import com.ynfinal.finalproject.organization.user.dto.response.LoginResponseDTO;
import com.ynfinal.finalproject.organization.user.entity.Employees;
import com.ynfinal.finalproject.organization.user.exception.DuplicatedEmpIdExpcetion;
import com.ynfinal.finalproject.organization.user.exception.NoRegisteredArgumentsException;
import com.ynfinal.finalproject.organization.user.repository.EmployeesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class EmployeesService {

    private final EmployeesRepository employeesRepository;
    private final PasswordEncoder encoder;
    private final TokenProvider tokenProvider;
    // 회원가입 처리
    public EmployeesSignUpResponseDTO create(EmployeesSignUpRequestDto dto)
    throws RuntimeException{

        if(dto == null){
            throw new NoRegisteredArgumentsException("가입 정보가 없습니다.");
        }

        String empId = dto.getEmpId();

        if(isDuplicate(empId)){
            log.warn("이메일이 중복되었습니다. {}", empId );

            throw new DuplicatedEmpIdExpcetion("중복된 사원아이디입니다.");
        }

        // 패스워드 인코딩
        String encoded = encoder.encode(dto.getEmpPassword());
        dto.setEmpPassword(encoded);

        // 사원 엔터티로 변환
        Employees employees = dto.toEntity();
        Employees saved = employeesRepository.save(employees);
        log.info("회원가입 정상 수행!!! -- save user {}", saved);

        return new EmployeesSignUpResponseDTO(saved);

    }
    public boolean isDuplicate(String empId) {
        return employeesRepository.existsByEmpId(empId);
    }

    // 사원 인증
    public LoginResponseDTO authenticate(final EmployeesLoginRequestDto dto){

        // 사원 아이디를 통해 회원 정보 조회
        Employees employees = employeesRepository.findByEmpId(dto.getEmpId())
                .orElseThrow(
                        () -> new RuntimeException("가입된 사원이 아닙니다")
                );

        // 패스워드 검증
        String rawPassword = dto.getEmpPassword();
        String encodedPassword = employees.getEmpPassword();

        if (!encoder.matches(rawPassword, encodedPassword)){
            throw new RuntimeException("비밀번호가 틀렸습니다.");
        }

        log.info("{}님 로그인 성공!!", employees.getEmpName());
        // 로그인 성공 후에 클라이언트에 리턴된 값, 토큰 인증 방식
        // Jwt를 클라이언트에게 발급
        String token = tokenProvider.createToken(employees);

        return new LoginResponseDTO(employees, token);


    }

}
