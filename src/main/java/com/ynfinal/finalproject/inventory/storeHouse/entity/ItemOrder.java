package com.ynfinal.finalproject.inventory.storeHouse.entity;


import com.ynfinal.finalproject.organization.company.entity.TradeCompany;
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
@Table(name = "item_order")
public class ItemOrder {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemOrderCode;

    // 발주서의 저장, 확정 확인
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private Check itemOrderCheck = Check.N;

    // 입고예정일
    @CreatedDate
    private Date itemOrderStart;

    // 발주서 유효기간
    @CreatedDate
    private Date itemOrderEnd;

    // 발주서 등록일
    @CreationTimestamp
    private LocalDateTime itemOrderReg;

    // 발주서 수정일
    @CreationTimestamp
    private LocalDateTime itemOrderUpdate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tr_comp_code", nullable = true, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private TradeCompany tradeCompany;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emp_no", nullable = true, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Employees employees;

}
