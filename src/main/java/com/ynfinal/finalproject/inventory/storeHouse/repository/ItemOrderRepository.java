package com.ynfinal.finalproject.inventory.storeHouse.repository;

import com.ynfinal.finalproject.inventory.storeHouse.entity.ItemOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemOrderRepository extends JpaRepository<ItemOrder, Long> {
}
