package com.ynfinal.finalproject.organization.company.entity;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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
    //TODO ENUM 타입으로 바꿀것 trBuy trSell
    private boolean trBuy = false;
    private boolean trSell = false;
    private LocalDateTime trStartDate;
    private LocalDateTime trEndDate;
    private LocalDateTime trRegDate;
    private LocalDateTime trUpdateDate;
    @Column(nullable = false)
    private String trAddr;

//    private String storehouseCode;
//    private Long empNo;

}
