package com.ynfinal.finalproject.organization.company.entity;


import com.ynfinal.finalproject.inventory.storeHouse.entity.StoreHouse;
import com.ynfinal.finalproject.organization.user.entity.Employees;
import com.ynfinal.finalproject.util.Check;
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
@Table(name = "TRADING_COMPANY")
public class TradeCompany {
    @Id
    private String trCompCode;
    @Column(nullable = false)
    private String trCompName;
    @Column(nullable = false)
    private String trCompRegNo;
    @Column(nullable = false)
    private String trCompCeo;
    private String trCompPhone;
    private Check trBuy = Check.N;
    private Check trSell = Check.N;
    private LocalDateTime trStartDate;
    private LocalDateTime trEndDate;
    private LocalDateTime trRegDate;
    private LocalDateTime trUpdateDate;
    @Column(nullable = false)
    private String trAddr;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_house_code", nullable = false, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private StoreHouse storeHouse;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emp_no", nullable = false, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Employees employees;


}
