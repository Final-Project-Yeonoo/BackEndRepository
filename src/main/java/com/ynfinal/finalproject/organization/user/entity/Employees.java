package com.ynfinal.finalproject.organization.user.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ynfinal.finalproject.organization.company.entity.Company;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
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
    private Long empNo;         // 1, 2, 3, 4, 5, 6
    @Column(nullable=false, unique=true)    // 변경 못하게
    private String empId;
//    @Column(nullable=false)
    private String empPassword;
//    @Column(nullable=false)
    private String empName;
    @CreationTimestamp
    private LocalDate empHiredDate;
//    @Column(unique=true)
    private String empPhone;
//    @Column(unique=true)
    private String empExtension;

    private String empAddress;

    private String empProfile;
    @Builder.Default
    private boolean empValidate = false;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dept_code", nullable = true, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    Department department;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comp_code", nullable = true, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    Company company;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pos_code", nullable = true, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    Position position;




}
