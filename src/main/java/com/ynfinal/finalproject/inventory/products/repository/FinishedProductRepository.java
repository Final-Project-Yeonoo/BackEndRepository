package com.ynfinal.finalproject.inventory.products.repository;

import com.ynfinal.finalproject.inventory.products.entity.FinishedProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FinishedProductRepository
        extends JpaRepository<FinishedProduct, String> {


    List<FinishedProduct> findAll();



}
