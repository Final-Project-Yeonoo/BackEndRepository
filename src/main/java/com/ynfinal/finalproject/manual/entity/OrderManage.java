package com.ynfinal.finalproject.manual.entity;

import com.ynfinal.finalproject.organization.company.entity.TradeCompany;
import com.ynfinal.finalproject.organization.user.entity.Employees;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

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
@Table(name = "ORDER_MANAGE")
public class OrderManage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_CODE")
    private Long orderCode;

    @Column(name = "ORDER_ETC", length = 200)
    private String orderEtc;

    @Column(name = "ORDER_DATE")
    private Date orderDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "ORDER_TYPE")
    private OrderType orderType = OrderType.저장;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROJECT_CODE")
    private Project project;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TR_COMP_CODE")
    private TradeCompany tradeCompany;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EMP_NO")
    private Employees employees;
    @CreationTimestamp
    private Date estimateDate;
    @Enumerated(EnumType.STRING)
    private EstimateOrderType estimateOrderType;

}
