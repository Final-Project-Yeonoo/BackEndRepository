package com.ynfinal.finalproject.organization.company.repository;

import com.ynfinal.finalproject.organization.company.entity.TradeCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TradeCompanyRepository
    extends JpaRepository<TradeCompany, Long> {

    @Query("SELECT tc FROM TradeCompany tc WHERE tc.trCompCode = :trCompCode")
    TradeCompany findByTrCompCode(Long trCompCode);

}
