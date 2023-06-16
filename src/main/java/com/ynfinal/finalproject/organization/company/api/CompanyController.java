package com.ynfinal.finalproject.organization.company.api;

import com.ynfinal.finalproject.organization.company.entity.Company;
import com.ynfinal.finalproject.organization.company.service.CompanyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/ynfinal/comp")
public class CompanyController {
    private final CompanyService companyService;

    @GetMapping
    public ResponseEntity<?> companyRender(){
        log.info("/ynfinal/comp GET!!");
        List<Company> companyList = companyService.findAll();
        for (Company company : companyList) {
            log.info("compnay {}", company);
        }
        return ResponseEntity.ok().body(companyList);
    }




}
