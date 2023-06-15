package com.ynfinal.finalproject.inventory.products.entity;

import com.ynfinal.finalproject.inventory.storeHouse.entity.StoreHouse;
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
@Table(name = "FINISHED_PRODUCT")
public class FinishedProduct {

    @Id
    @Column(length = 20)
    private String finishedCode;

    @Column(length = 20)
    @NotNull
    private String finishedName;

    @Column(length = 8)
    private int finishedCount = 0;

    @CreationTimestamp
    private LocalDateTime finishedRegDate;

    @CreationTimestamp
    private LocalDateTime finishedRegUpdate;

    @Column(columnDefinition = "INT CHECK (finishedPrice >= 0)", length = 10)
    private int finishedPrice;

    @ManyToOne // 체크 할것
    @JoinColumn(name = "STORE_HOUSE", nullable = false, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private StoreHouse storeHouse;


    @JoinColumn(name = "HR_EMPLOYEES", nullable = false, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Long empNo;

}
