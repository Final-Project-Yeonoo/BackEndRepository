package com.ynfinal.finalproject.inventory.storeHouse.entity;



import com.ynfinal.finalproject.inventory.orders.entity.ItemOrder;
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
@Table(name = "INPUT_PRODUCT")
public class InputProduct {

    @Id
    @Column(length = 20)
    private String inputProductCode;

    @CreationTimestamp
    @NotNull
    private LocalDateTime inputProductDate;

    @ManyToOne
    @JoinColumn(name = "ITEM_ORDER", nullable = true, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private ItemOrder itemOrder;

    @ManyToOne
    @JoinColumn(name = "STORE_HOUSE", nullable = true, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private StoreHouse storeHouse;

    @ManyToOne
    @JoinColumn(name = "HR_EMPLOYEES", nullable = true, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Employees employees ;
}
