package com.ynfinal.finalproject.inventory.orders.entity;

import com.ynfinal.finalproject.organization.tradecompany.entity.TradeCompany;
import com.ynfinal.finalproject.organization.user.entity.Employees;
import com.ynfinal.finalproject.util.Check;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
@Table(name = "ITEM_ORDER")
public class  ItemOrder {


    @Id
    @Column(length = 20)
    private String itemOrderCode;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private Check itemOrderCheck = Check.N;

    @CreatedDate
    private Date itemOrderStart;

    @CreatedDate
    private Date itemOrderEnd;

    @CreationTimestamp
    private LocalDateTime itemOrderReg;

    @CreationTimestamp
    private LocalDateTime itemOrderUpdate;

    @ManyToOne
    @JoinColumn(name = "TRADING_COMPANY", nullable = true, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private TradeCompany tradeCompany;

    @ManyToOne
    @JoinColumn(name = "HR_EMPLOYEES", nullable = true, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Employees employees;

}
