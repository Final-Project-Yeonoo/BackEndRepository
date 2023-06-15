package com.ynfinal.finalproject.organization.company.entity;


import com.ynfinal.finalproject.util.Check;
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
    private Check trBuy = Check.N;
    private Check trSell = Check.N;
    private LocalDateTime trStartDate;
    private LocalDateTime trEndDate;
    private LocalDateTime trRegDate;
    private LocalDateTime trUpdateDate;
    @Column(nullable = false)
    private String trAddr;

//    private String storehouseCode;
//    private Long empNo;

}
