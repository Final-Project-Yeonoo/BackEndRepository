package com.ynfinal.finalproject.inventory.products.repository;

import com.ynfinal.finalproject.inventory.products.entity.HalfProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HalfProductRepository extends JpaRepository<HalfProduct, Long> {

}
