package com.ynfinal.finalproject.inventory.storeHouse.repository;

import com.ynfinal.finalproject.inventory.storeHouse.entity.ItemOrder;
import com.ynfinal.finalproject.organization.company.entity.TradeCompany;
import com.ynfinal.finalproject.organization.user.entity.Employees;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemOrderRepository extends JpaRepository<ItemOrder, Long> {



}
