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
@Table(name = "delivery")
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deliveryCode;
    @Enumerated(EnumType.STRING)
    private OrderType deliveryStatus;
    @Enumerated(EnumType.STRING)
    private Charge deliveryCharge;
    @CreationTimestamp
    private Date deliveryDate;
    @CreationTimestamp
    private Date deliveryRegDate;
    @CreationTimestamp
    private Date deliveryModifyDate;



    @ManyToOne
    @JoinColumn(name = "tr_comp_code", nullable = true, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private TradeCompany tradeCompany;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emp_no", nullable = true, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Employees employees;
}
