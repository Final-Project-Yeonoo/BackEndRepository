package com.ynfinal.finalproject.inventory.products.service;

import com.ynfinal.finalproject.inventory.storeHouse.dto.response.ItemOrderListResponseDTO;
import com.ynfinal.finalproject.inventory.storeHouse.entity.ItemOrder;
import com.ynfinal.finalproject.inventory.storeHouse.repository.ItemOrderRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ProductServiceTest {

    @Autowired
    private ItemOrderRepository repository;

    @Test
    @DisplayName("dd")
    void selectallTest(){
        List<ItemOrder> all = repository.findAll();

        System.out.println("all = " + all);

    }
}