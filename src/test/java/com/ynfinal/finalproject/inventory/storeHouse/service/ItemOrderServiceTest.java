//package com.ynfinal.finalproject.inventory.storeHouse.service;
//
//import com.ynfinal.finalproject.inventory.storeHouse.dto.request.ItemOrderInputRequestDTO;
//import com.ynfinal.finalproject.inventory.storeHouse.entity.ItemOrder;
//import com.ynfinal.finalproject.inventory.storeHouse.repository.ItemOrderDetailRepository;
//import com.ynfinal.finalproject.inventory.storeHouse.repository.ItemOrderRepository;
//import com.ynfinal.finalproject.util.Check;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.util.Date;
//
//import static java.time.LocalDate.now;
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//class ItemOrderServiceTest {
//
//
//    @Autowired
//    private ItemOrderRepository itemOrderRepository;
//    private ItemOrderDetailRepository detailRepository;
//
//
//    @Test
//    @DisplayName("발주서 등록하기")
//    void insertOrderTest() {
//
//
//        ItemOrderInputRequestDTO build = ItemOrderInputRequestDTO.builder()
//                .itemOrderUpdate(LocalDateTime.now())
//                .itemOrderCheck(Check.N)
//                .itemOrderUpdate(LocalDateTime.now())
//                .build();
//
//
//    }
//
//    @Test
//    @DisplayName("발주서 등록하기")
//    void insertOrderTest() {
//        LocalDateTime now = LocalDateTime.now(); // 현재 시간을 가져옴
//
//        ItemOrderInputRequestDTO build = ItemOrderInputRequestDTO.builder()
//                .itemOrderCheck(Check.N)
//                .itemOrderStart(new Date()) // 적절한 값으로 설정
//                .itemOrderReg(now)
//                .itemOrderUpdate(now)
//                .empNo(1234L) // 적절한 값으로 설정
//                .empName("John Doe") // 적절한 값으로 설정
//                .trCompCode(5678L) // 적절한 값으로 설정
//                .trCompName("Trade Company") // 적절한 값으로 설정
//                .build();
//
//        // itemOrderRepository에 insert 수행
//        ItemOrder itemOrder = build.toEntity(tradeCompany, employees);
//        itemOrderRepository.save(itemOrder);
//
//        // itemOrderDetailRepository에 insert 수행
//        // ...
//
//        // 추가적인 테스트 코드 작성
//        // ...
//    }
//
//}