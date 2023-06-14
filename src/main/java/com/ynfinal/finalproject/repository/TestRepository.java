package com.ynfinal.finalproject.repository;

import com.ynfinal.finalproject.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<TestEntity,Integer> {

}
