package com.ynfinal.finalproject.organization.user.service;

import com.ynfinal.finalproject.organization.user.dto.request.EmployeesSignUpRequestDto;
import com.ynfinal.finalproject.organization.user.dto.response.EmployeesSignUpResponseDTO;
import com.ynfinal.finalproject.organization.user.entity.Employees;
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

    // 회원가입 처리
    public EmployeesSignUpResponseDTO create(EmployeesSignUpRequestDto dto){

        if(dto == null){
            throw new RuntimeException("가입 정보가 없습니다.");
        }

        String empId = dto.getEmpId();

        if(employeesRepository.existsByEmpId(empId)){
            log.warn("이메일이 중복되었습니다. {}", empId );

            throw new RuntimeException("중복된 이메일입니다.");
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
}
