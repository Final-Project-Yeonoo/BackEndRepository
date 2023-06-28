package com.ynfinal.finalproject.organization.user.api;

import com.ynfinal.finalproject.organization.user.dto.request.EmployeesLoginRequestDto;
import com.ynfinal.finalproject.organization.user.dto.request.EmployeesModifyDTO;
import com.ynfinal.finalproject.organization.user.dto.request.EmployeesSignUpRequestDto;
import com.ynfinal.finalproject.organization.user.dto.request.MypageModifyDTO;
import com.ynfinal.finalproject.organization.user.dto.response.EmployeesResponseDTO;
import com.ynfinal.finalproject.organization.user.dto.response.EmployeesSignUpResponseDTO;
import com.ynfinal.finalproject.organization.user.dto.response.LoginResponseDTO;
import com.ynfinal.finalproject.organization.user.dto.response.MypageResponseDTO;
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

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/ynfinal/employee")
//@CrossOrigin("*")
@RequiredArgsConstructor
public class EmployeesController {


    private final EmployeesService employeesService;


    //    @GetMapping
//    @PostMapping
//    @PutMapping
//    @DeleteMapping


//    사용자 조회

    @GetMapping
    public ResponseEntity<?> handleEmployeesGetRequest(){
        List<EmployeesResponseDTO> responseDTOList = employeesService.findAll();

        return ResponseEntity.ok(responseDTOList);
    }

    @GetMapping("/mypage/{empNo}")
    public ResponseEntity<?> handleMyPageEmployeesGetRequest(@PathVariable("empNo")Long empNo){
        MypageResponseDTO mypageResponseDTO = employeesService.findMyPage(empNo);

        return ResponseEntity.ok(mypageResponseDTO);
    }


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
    @PostMapping
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

    @PostMapping("/{empNo}")
    public ResponseEntity<?> modify(
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


    @PatchMapping("/mypage")
    public ResponseEntity<?> handleMyPageEmployeesGetRequest(@Validated @RequestBody MypageModifyDTO modifyDTO){
        MypageResponseDTO mypageResponseDTO = employeesService.updateMyPage(modifyDTO);

        return ResponseEntity.ok(mypageResponseDTO);
    }

    @PatchMapping
    public ResponseEntity<?> modifyEmployee (@RequestBody List<EmployeesModifyDTO> list){
        employeesService.updateEmployee(list);
        return ResponseEntity.ok("ok!");
    }
}

