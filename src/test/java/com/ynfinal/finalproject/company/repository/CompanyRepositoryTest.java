package com.ynfinal.finalproject.company.repository;

import com.ynfinal.finalproject.company.entity.Company;
import com.ynfinal.finalproject.util.Utility;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;


@Rollback(value = false)
@Transactional
@SpringBootTest
class CompanyRepositoryTest {

    @Autowired
    CompanyRepository companyRepository;

    @BeforeEach
    void bulkInsert(){
        for (int i = 1; i < 10; i++) {
            companyRepository.save(
                    Company.builder()
                            .compCode("comp" + Utility.convertSerial(i))
                            .compCeo("강남이" + i)
                            .compName("강남회사" + i)
                            .compPhone("010-1234-12"+i)
                            .compRegNo("774-88-012" + i) // 774-88-01234
                            .build()
            );
        }
    }

    @Test
    @DisplayName("회사 정보 조회")
    void testFindCompany(){
        // given
        List<Company> companyList = companyRepository.findAll();
        // when

        // then
        for (Company company : companyList) {
            System.out.println(company.getCompName());
        }

    }




}