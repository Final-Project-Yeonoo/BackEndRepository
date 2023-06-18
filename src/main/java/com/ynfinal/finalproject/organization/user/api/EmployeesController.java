package com.ynfinal.finalproject.organization.user.api;

import com.ynfinal.finalproject.organization.user.entity.Employees;
import com.ynfinal.finalproject.organization.user.service.EmployeesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/ynfinal/employee")
@CrossOrigin("*")
@RequiredArgsConstructor
public class EmployeesController {


    private final EmployeesService employeesService;

    // empId 중복체크
    @GetMapping("/check")
    public ResponseEntity<?> check(String empId){

        if(empId.trim().equals("")){
            return ResponseEntity.badRequest()
                    .body("사원 이메일이 없습니다.");
        }


        boolean resultFlag = employeesService.isDuplicate(empId);

        return ResponseEntity.ok().body(resultFlag);

    }





}

