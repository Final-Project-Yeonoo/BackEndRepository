package com.ynfinal.finalproject.company.repository;

import com.ynfinal.finalproject.company.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyRepository
                extends JpaRepository<Company, String> {

}
