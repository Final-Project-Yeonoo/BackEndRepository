package com.ynfinal.finalproject.manual.repository;

import com.ynfinal.finalproject.manual.entity.JobOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobOrderRepository extends JpaRepository<JobOrder, Long> {
}
