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
@Table(name = "order_manage")
public class OrderManage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderCode;

    private String orderEtc;

    private Date orderDate;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private OrderType orderType = OrderType.저장;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_code",  foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Project project;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tr_comp_code")
    private TradeCompany tradeCompany;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emp_no", nullable = true, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Employees employees;
    @CreationTimestamp
    private Date estimateDate;
    @Enumerated(EnumType.STRING)
    private EstimateOrderType estimateOrderType;

}
