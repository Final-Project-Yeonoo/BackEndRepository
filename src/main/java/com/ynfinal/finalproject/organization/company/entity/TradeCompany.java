package com.ynfinal.finalproject.organization.company.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ynfinal.finalproject.inventory.storeHouse.entity.StoreHouse;
import com.ynfinal.finalproject.organization.user.entity.Employees;
import com.ynfinal.finalproject.util.Check;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "TRADING_COMPANY")
public class TradeCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trCompCode;
    @Column(nullable = false)
    private String trCompName;
    @Column(nullable = false)
    private String trCompRegNo;
    @Column(nullable = false)
    private String trCompCeo;
    private String trCompPhone;
    @Builder.Default
    @Enumerated(EnumType.STRING)
    private Check trBuy = Check.N;
    @Builder.Default
    @Enumerated(EnumType.STRING)
    private Check trSell = Check.N;
    @CreationTimestamp
    private LocalDateTime trStartDate;
    @CreationTimestamp
    private LocalDateTime trEndDate;
    @CreationTimestamp
    private LocalDateTime trRegDate;
    @CreationTimestamp
    private LocalDateTime trUpdateDate;
    @Column(nullable = false)
    private String trAddr;


    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "storehouse_code", nullable = false, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private StoreHouse storeHouse;

//    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emp_no", nullable = false, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Employees employees;




}
