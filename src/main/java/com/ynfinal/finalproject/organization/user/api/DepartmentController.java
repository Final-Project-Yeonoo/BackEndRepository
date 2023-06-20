package com.ynfinal.finalproject.organization.user.api;


import com.ynfinal.finalproject.organization.user.dto.response.DepartmentResponseDTO;
import com.ynfinal.finalproject.organization.user.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/ynfinal/department")
@RequiredArgsConstructor
public class DepartmentController {


    private final DepartmentService departmentService;


    //    @GetMapping 부서 목록을 전체 조회한다
    @GetMapping
    public ResponseEntity<?> handleDepartmentGetRequest(){

        List<DepartmentResponseDTO> departmentResponseDTOList = departmentService.findAll();

        return ResponseEntity.ok(departmentResponseDTOList);
    }



//    @PostMapping
//    @PutMapping
//    @DeleteMapping
}
