package com.ynfinal.finalproject.inventory.storeHouse.repository;

import com.ynfinal.finalproject.inventory.storeHouse.entity.ItemOrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemOrderDetailRepository extends JpaRepository<ItemOrderDetail, Long> {


}
