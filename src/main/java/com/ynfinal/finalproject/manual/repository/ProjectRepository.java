package com.ynfinal.finalproject.manual.repository;

import com.ynfinal.finalproject.manual.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    Project findByProjectCode(@Param("projectCode") Long projectCode);

}
