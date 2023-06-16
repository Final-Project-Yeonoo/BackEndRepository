package com.ynfinal.finalproject.organization.company.repository;

import com.ynfinal.finalproject.organization.company.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository
                extends JpaRepository<Company, String> {


}
