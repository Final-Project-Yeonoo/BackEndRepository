package com.ynfinal.finalproject.inventory.storeHouse.entity;



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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inputProductCode;

    @CreationTimestamp
    @NotNull
    private LocalDateTime inputProductDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ITEM_ORDER_CODE", nullable = true, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private ItemOrder itemOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ITEM_ORDER_DETAIL_CODE", nullable = true, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private ItemOrderDetail itemOrderDetail;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STOREHOUSE_CODE", nullable = true, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private StoreHouse storeHouse;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EMP_NO", nullable = true, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Employees employees ;
}
