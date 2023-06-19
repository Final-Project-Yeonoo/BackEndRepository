package com.ynfinal.finalproject.organization.company.service;

import com.ynfinal.finalproject.organization.company.dto.request.CompanyModifyRequestDTO;
import com.ynfinal.finalproject.organization.company.dto.request.CompanyPostRequestDTO;
import com.ynfinal.finalproject.organization.company.entity.Company;
import com.ynfinal.finalproject.organization.company.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class CompanyService {

    private final CompanyRepository companyRepository;

    public List<Company> findAll(){
        return companyRepository.findAll();
    }


    public Company findOne(Long compCode) {
        return companyRepository.findByCompCode(compCode).orElseThrow();
    }

    public Company insertOne(CompanyPostRequestDTO companyPostRequestDTO) {
        Company company = companyPostRequestDTO.toEntity();
        return companyRepository.save(company);
    }

    public List<Company> modifyAll(@Validated List<CompanyModifyRequestDTO> companyModifyRequestDTOList) {


        for (CompanyModifyRequestDTO companyModifyRequestDTO : companyModifyRequestDTOList) {
            Optional<Company> companyEntity = companyRepository.findByCompCode(companyModifyRequestDTO.getCompCode());
            companyEntity.ifPresent(entity -> {
                entity.setCompName(companyModifyRequestDTO.getCompName());
                entity.setCompCeo(companyModifyRequestDTO.getCompCeo());
                entity.setCompPhone(companyModifyRequestDTO.getCompPhone());
                if (companyModifyRequestDTO.getCompRegNo() != null) {
                    entity.setCompRegNo(companyModifyRequestDTO.getCompRegNo());
                }
                companyRepository.save(entity);
            });
        }
        return findAll();

    }

    public List<Company> deleteOne(Long compCode) {
         companyRepository.deleteById(compCode);
         return findAll();
    }
}
