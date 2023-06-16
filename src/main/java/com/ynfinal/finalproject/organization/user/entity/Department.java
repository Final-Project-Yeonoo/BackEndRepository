package com.ynfinal.finalproject.organization.user.entity;

import lombok.*;

import javax.persistence.*;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deptCode;
    @Column(nullable = false)
    private String deptName;
    @Column(nullable = false)
    private String deptSuperCode;


}
