package com.ynfinal.finalproject.inventory.products.repository;

import com.ynfinal.finalproject.inventory.products.entity.RawProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RawProductRepository extends JpaRepository<RawProduct, String> {

    @Override
    List<RawProduct> findAll();


}
