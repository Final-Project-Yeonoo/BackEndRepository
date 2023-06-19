package com.ynfinal.finalproject.organization.user.repository;

import com.ynfinal.finalproject.organization.user.entity.Authorization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorizationRepository
        extends JpaRepository<Authorization, Integer> {

    Authorization findByAuthCode(Long authCode);
    Authorization findByEmployees_EmpNo(Long empNo);
}
