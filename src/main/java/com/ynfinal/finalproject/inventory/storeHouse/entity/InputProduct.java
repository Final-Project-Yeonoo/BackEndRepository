package com.ynfinal.finalproject.inventory.storeHouse.entity;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
@Table(name = "INPUT_PRODUCT")
public class InputProduct {

    @Id
    @Column(length = 20)
    private String inputProductCode;

    @CreationTimestamp
    @NotNull
    private LocalDateTime inputProductDate;

    @JoinColumn(name = "ITEM_ORDER", nullable = false, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private String itemOrderCode;

    @JoinColumn(name = "STORE_HOUSE", nullable = false, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private String storehouseCode;

    @JoinColumn(name = "HR_EMPLOYEES", nullable = false, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Long empNo;
}
