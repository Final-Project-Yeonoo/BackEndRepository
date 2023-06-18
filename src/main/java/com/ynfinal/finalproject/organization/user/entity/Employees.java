package com.ynfinal.finalproject.organization.user.entity;


import com.ynfinal.finalproject.organization.company.entity.Company;
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
    @Builder.Default
    private boolean empValidate = false;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dept_code", nullable = false, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    Department department;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comp_code", nullable = false, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    Company company;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pos_code", nullable = false, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    Position position;




}
