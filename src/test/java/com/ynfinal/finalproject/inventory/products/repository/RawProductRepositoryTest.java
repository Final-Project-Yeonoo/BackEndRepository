package com.ynfinal.finalproject.inventory.products.repository;

import com.ynfinal.finalproject.inventory.products.dto.request.RawProductInsertRequestDTO;
import com.ynfinal.finalproject.inventory.products.dto.request.RawProductModifyRequestDTO;
import com.ynfinal.finalproject.inventory.products.entity.RawProduct;
import com.ynfinal.finalproject.inventory.products.service.RawProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class RawProductRepositoryTest {

    @Autowired
    RawProductRepository repository;
    @Autowired
    RawProductService service;

    @Test
    @DisplayName("원자재를 등록한다")
    void insertTest() {

        // given
//        RawProductInsertRequestDTO dto = RawProductInsertRequestDTO.builder()
//                .rawCount(100)
//                .rawPrice(1000)
//                .rawName("원자재1")
//                .build();

//        RawProduct rawProduct = dto.toEntity();
//        System.out.println(dto);
//        System.out.println(rawProduct);

        // when
//        RawProduct save = null;
//        try {
//            save = repository.save(rawProduct);
//            System.out.println("save = " + save);
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        }

        // then


    }

    @Test
    @DisplayName("원자재를 삭제한다")
    void deleteRawTest(){
        // given
        long target = 1L;

        // when
        repository.deleteById(target);

        // then

    }
}