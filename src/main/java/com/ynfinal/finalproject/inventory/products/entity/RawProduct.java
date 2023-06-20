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
@Table(name = "RAW_PRODUCT")
public class RawProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rawCode;

    @Column(length = 20, nullable = false)
    private String rawName;

    @Column(length = 8)
    @Builder.Default
    private int rawCount = 0;

    @CreationTimestamp
    private LocalDateTime rawRegDate;

    @CreationTimestamp
    private LocalDateTime rawRegUpdate;

    @Column(columnDefinition = "INT CHECK (rawPrice >= 0)", length = 10)
    private int rawPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STOREHOUSE_CODE", nullable = true, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private StoreHouse storeHouse;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EMP_NO", nullable = true, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Employees employees;
}
