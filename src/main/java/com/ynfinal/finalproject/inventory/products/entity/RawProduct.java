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
@Table(name = "RAW_PRODUCT")
public class RawProduct {

    @Id
    @Column(length = 20)
    private String rawCode;

    @Column(length = 20)
    @NotNull
    private String rawName;

    @Column(length = 8)
    private int rawCount = 0;

    @CreationTimestamp
    private LocalDateTime rawRegDate;

    @CreationTimestamp
    private LocalDateTime rawRegUpdate;

    @Column(columnDefinition = "INT CHECK (rawPrice >= 0)", length = 10)
    private int rawPrice;


    @JoinColumn(name = "STORE_HOUSE", nullable = false, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private String storehouseCode;

    @JoinColumn(name = "HR_EMPLOYEES", nullable = false, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Long empNo;

}
