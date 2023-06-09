package com.ynfinal.finalproject.organization.user.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "hr_department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deptCode;
    @Column(nullable = false)
    private String deptName;
    private Long deptSuperCode;


}
