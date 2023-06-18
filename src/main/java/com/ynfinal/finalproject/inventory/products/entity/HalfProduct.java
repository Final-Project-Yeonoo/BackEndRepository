package com.ynfinal.finalproject.inventory.products.entity;

import com.ynfinal.finalproject.inventory.storeHouse.entity.StoreHouse;
import com.ynfinal.finalproject.organization.user.entity.Employees;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long halfCode;

    @Column(length = 20, nullable = false)
    private String halfName;

    @Column(length = 8)
    @Builder.Default
    private int halfCount = 0;

    @CreationTimestamp
    private LocalDateTime halfRegDate;

    @CreationTimestamp
    private LocalDateTime halfRegUpdate;

    @Column(columnDefinition = "INT CHECK (halfPrice >= 0)", length = 10)
    private int halfPrice;


    @ManyToOne // 체크 할것
    @JoinColumn(name = "STORE_HOUSE", nullable = true, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private StoreHouse storeHouse;

    @ManyToOne
    @JoinColumn(name = "HR_EMPLOYEES", nullable = true, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Employees employees;

}
