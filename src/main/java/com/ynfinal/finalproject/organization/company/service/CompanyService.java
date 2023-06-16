package com.ynfinal.finalproject.organization.company.service;

import com.ynfinal.finalproject.organization.company.entity.Company;
import com.ynfinal.finalproject.organization.company.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CompanyService {

    CompanyRepository companyRepository;

    public List<Company> findAll(){
        return companyRepository.findAll();
    }



}
