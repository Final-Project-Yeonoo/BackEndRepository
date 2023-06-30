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
@Setter
@Table(name = "finished_product")
public class FinishedProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long finishedCode;

    @Column(length = 20, nullable = false)
    private String finishedName;

    @Column(length = 8)
    @Builder.Default
    private int finishedCount = 0;

    @Column(length = 100, nullable = true)
    private String finishedSize;

    @CreationTimestamp
    private LocalDateTime finishedRegDate;

    @CreationTimestamp
    private LocalDateTime finishedRegUpdate;

    @Column(length = 10)
    private int finishedPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "storehouse_code", nullable = true, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private StoreHouse storeHouse;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emp_no", nullable = true, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Employees employees;

}
