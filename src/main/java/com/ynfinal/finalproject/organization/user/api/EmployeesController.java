package com.ynfinal.finalproject.organization.user.api;

import com.ynfinal.finalproject.organization.user.dto.request.EmployeesLoginRequestDto;
import com.ynfinal.finalproject.organization.user.dto.request.EmployeesSignUpRequestDto;
import com.ynfinal.finalproject.organization.user.dto.response.EmployeesSignUpResponseDTO;
import com.ynfinal.finalproject.organization.user.dto.response.LoginResponseDTO;
import com.ynfinal.finalproject.organization.user.entity.Employees;
import com.ynfinal.finalproject.organization.user.exception.DuplicatedEmpIdExpcetion;
import com.ynfinal.finalproject.organization.user.exception.NoRegisteredArgumentsException;
import com.ynfinal.finalproject.organization.user.service.EmployeesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/ynfinal/employee")
//@CrossOrigin("*")
@RequiredArgsConstructor
public class EmployeesController {


    private final EmployeesService employeesService;

    // empId 중복체크 GET:  /ynfinal/employee/check?empId=aaa@aaa.com
    @GetMapping("/check")
    public ResponseEntity<?> check(String empId){

        if(empId.trim().equals("")){
            return ResponseEntity.badRequest()
                    .body("사원 이메일이 없습니다.");
        }


        boolean resultFlag = employeesService.isDuplicate(empId);

        return ResponseEntity.ok().body(resultFlag);

    }


    // 회원가입 요청처리
    // POST : /ynfinal/employee
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> signUp(
            @Validated @RequestBody EmployeesSignUpRequestDto dto,
            BindingResult result
    ){
        log.info("/api/auth POST! - {}", dto);

        if( result.hasErrors()){
            log.warn(result.toString());
            return ResponseEntity.badRequest()
                    .body(result.getFieldError());
        }

        EmployeesSignUpResponseDTO responseDTO = employeesService.create(dto);
            return ResponseEntity.ok()
                    .body(responseDTO);
    }

    // 로그인 요청 처리
    @PostMapping("/signin")
    public ResponseEntity<?> signIn(
            @Validated @RequestBody EmployeesLoginRequestDto dto
            ) {

        LoginResponseDTO loginResponseDTO = employeesService.authenticate(dto);

        return ResponseEntity.ok().body(loginResponseDTO);


    }

}

