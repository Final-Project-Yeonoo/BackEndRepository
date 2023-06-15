package com.ynfinal.finalproject.organization.user.entity;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "HR_EMPLOYEES")
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empNo;
    @Column(nullable=false, unique=true)
    private String empId;
    @Column(nullable=false)
    private String empPassword;
    @Column(nullable=false)
    private String empName;

    private LocalDateTime empHiredDate;
    @Column(unique=true)
    private String empPhone;
    @Column(unique=true)
    private String empExtension;

    private String empProfile;

    private boolean empValidate = false;
    private String deptCode;
    private String compCode;
    private String posCode;
}
