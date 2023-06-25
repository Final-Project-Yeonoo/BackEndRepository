package com.ynfinal.finalproject.manual.entity;

import com.ynfinal.finalproject.organization.company.entity.TradeCompany;
import com.ynfinal.finalproject.organization.user.entity.Employees;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
@Table(name = "ESTIMATE")
public class Estimate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ESTIMATE_CODE")
    private Long estimateCode;

    @Column(name = "ESTIMATE_DATE")
    private Date estimateDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "ESTIMATE_ORDER_TYPE")
    private EstimateOrderType estimateOrderType= EstimateOrderType.OEM;

    @Enumerated(EnumType.STRING)
    @Column(name = "ESTIMATE_PAYMENT")
    private EstimatePayment estimatePayment = EstimatePayment.카드;

    @Column(name = "ESTIMATE_ETC")
    private String estimateEtc;

    @Column(name = "PROJECT_REG_DATE")
    private Date projectRegDate;

    @Column(name = "PROJECT_UPDATE_DATE")
    private Date projectUpdateDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EMP_NO")
    private Employees employees;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROJECT_CODE")
    private Project project;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TR_COMP_CODE")
    private TradeCompany tradeCompany;


}