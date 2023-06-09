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
@Table(name = "half_product")
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
    @Column(length = 100, nullable = true)
    private String halfComment;

    @Column(length = 10)
    private int halfPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "storehouse_code", nullable = true, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private StoreHouse storeHouse;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emp_no", nullable = true, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Employees employees;

}
