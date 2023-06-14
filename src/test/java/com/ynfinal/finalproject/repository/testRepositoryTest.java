package com.ynfinal.finalproject.repository;

import com.ynfinal.finalproject.entity.TestEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@Rollback(value = false)
class testRepositoryTest {


    @Autowired
    TestRepository testRepository;

    @BeforeEach
    void insertInfo() {
        TestEntity test = TestEntity.builder().name("test").build();
        testRepository.save(test);

    }

    @Test
    @DisplayName("")
    void test() {
        //given
        System.out.println("test");
        //when

        //then
    }


}