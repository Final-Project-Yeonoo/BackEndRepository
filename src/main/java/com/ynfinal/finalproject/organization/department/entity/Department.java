package com.ynfinal.finalproject.organization.department.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "HR_DEPARTMENT")
public class Department {
    @Id
    private String deptCode;
    @Column(nullable = false)
    private String deptName;
    @Column(nullable = false)
    private String deptSuperCode;
}
