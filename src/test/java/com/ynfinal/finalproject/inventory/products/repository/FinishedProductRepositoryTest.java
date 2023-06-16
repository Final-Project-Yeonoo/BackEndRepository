package com.ynfinal.finalproject.inventory.products.repository;

import com.ynfinal.finalproject.inventory.products.entity.FinishedProduct;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FinishedProductRepositoryTest {


    @Autowired
    private FinishedProductRepository repository;

    @Test
    @DisplayName("finished repository를 전체조회한다")
    void findAllTest(){

        List<FinishedProduct> all = repository.findAll();

        System.out.println("\n\n\n\n");
        System.out.println("all = " + all);
        System.out.println("\n\n\n\n");


    }

}