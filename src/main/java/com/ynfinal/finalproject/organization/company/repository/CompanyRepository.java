package com.ynfinal.finalproject.organization.company.repository;

import com.ynfinal.finalproject.organization.company.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository
                extends JpaRepository<Company, Long> {

    Optional<Company> findByCompCode(long compCode);
}
