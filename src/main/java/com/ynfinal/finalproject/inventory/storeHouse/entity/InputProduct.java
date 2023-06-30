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
@Table(name = "input_product")
public class InputProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inputProductCode;

    @CreationTimestamp
    @NotNull
    private LocalDateTime inputProductDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_order_code", nullable = true, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private ItemOrder itemOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_order_detail_code", nullable = true, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private ItemOrderDetail itemOrderDetail;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "storehouse_code", nullable = true, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private StoreHouse storeHouse;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emp_no", nullable = true, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Employees employees ;
}
