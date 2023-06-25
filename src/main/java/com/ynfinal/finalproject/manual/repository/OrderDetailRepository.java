package com.ynfinal.finalproject.manual.repository;

import com.ynfinal.finalproject.manual.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
}
