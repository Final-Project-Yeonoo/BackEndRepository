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

    @ManyToOne // 체크 할것
    @JoinColumn(name = "STORE_HOUSE", nullable = true, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private StoreHouse storeHouse;

    @ManyToOne
    @JoinColumn(name = "HR_EMPLOYEES", nullable = true, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Employees employees;

}
