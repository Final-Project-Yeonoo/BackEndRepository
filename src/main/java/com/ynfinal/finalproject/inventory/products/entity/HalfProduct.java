package com.ynfinal.finalproject.inventory.products.entity;

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
@Table(name = "HALF_PRODUCT")
public class HalfProduct {


    @Id
    @Column(length = 20)
    private String halfCode;

    @Column(length = 20)
    @NotNull
    private String halfName;

    @Column(length = 8)
    private int halfCount = 0;

    @CreationTimestamp
    private LocalDateTime halfRegDate;

    @CreationTimestamp
    private LocalDateTime halfRegUpdate;

    @Column(columnDefinition = "INT CHECK (halfPrice >= 0)", length = 10)
    private int halfPrice;


    @JoinColumn(name = "STORE_HOUSE", nullable = false, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private String storehouseCode;

    @JoinColumn(name = "HR_EMPLOYEES", nullable = false, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Long empNo;

}
