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
        // when
        List<Company> companyList = companyRepository.findAll();
        // then
        for (Company company : companyList) {
            System.out.println(company.getCompName());
        }
    }


    @Test
    @DisplayName("comp000003을 조회하면 대표이름이 강남이3 이어야 한다")
    void testFindOne(){
        // given
        String compCode = "comp000003";
        // when
        Company company = companyRepository.findById(compCode)
                .orElseThrow(
                        () -> new RuntimeException("회사 정보가 없음")
                );
        // then
        assertEquals(company.getCompCeo(), "강남이3");
        assertEquals(company.getCompPhone(), "010-1234-123");
    }


    @Test
    @DisplayName("comp000003의 회사 대표명 강남이3을 여누3으로 수정한다")
    void testUpdate(){
        // given
        String compCode = "comp000003";
        // when


        // then

    }



}