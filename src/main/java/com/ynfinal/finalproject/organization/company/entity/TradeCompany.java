package com.ynfinal.finalproject.organization.company.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ynfinal.finalproject.inventory.storeHouse.entity.StoreHouse;
import com.ynfinal.finalproject.organization.user.entity.Employees;
import com.ynfinal.finalproject.util.Check;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "trading_company")
public class TradeCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trCompCode;
    @Column(nullable = false)
    private String trCompName;
    @Column(nullable = true)
    private String trCompRegNo;
    @Column(nullable = true)
    private String trCompCeo;
    private String trCompPhone;
    @Builder.Default
    @Enumerated(EnumType.STRING)
    private Check trBuy = Check.N;
    @Builder.Default
    @Enumerated(EnumType.STRING)
    private Check trSell = Check.N;
    @CreationTimestamp
    private LocalDate trStartDate;
    @CreationTimestamp
    private LocalDate trEndDate;
    @CreationTimestamp
    private LocalDate trRegDate;
    @CreationTimestamp
    private LocalDate trUpdateDate;

    private String trAddr;
    private String trEtc;

//    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "storehouse_code", nullable = true, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private StoreHouse storeHouse;

//    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emp_no", nullable = true, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Employees employees;




}
