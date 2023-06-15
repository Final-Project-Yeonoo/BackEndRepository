package com.ynfinal.finalproject.inventory.orders.entity;

import com.ynfinal.finalproject.utils.Check;
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
public class ItemOrder {


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


    @JoinColumn(name = "TRADING_COMPANY", nullable = false, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private String trCompCode;


    @JoinColumn(name = "HR_EMPLOYEES", nullable = false, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Long empNo;

}
