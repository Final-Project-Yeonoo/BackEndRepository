package com.ynfinal.finalproject.inventory.storeHouse.entity;

import com.ynfinal.finalproject.inventory.storeHouse.entity.ItemOrder;
import com.ynfinal.finalproject.inventory.storeHouse.entity.StoreHouse;
import lombok.*;

import javax.persistence.*;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
@Table(name = "ITEM_ORDER_DETAIL")
public class ItemOrderDetail {

    @Id
    @Column(length = 20)
    private Long itemOrderDetailCode;

    @Column(length = 50)
    private String itemOrderDetailName;

    @Column(length = 8)
    private int itemOrderDetailPrice;

    @Column(length = 8)
    private int itemOrderDetailCount;

    @Builder.Default
    private double taxCode = 0.1;

    @ManyToOne
    @JoinColumn(name = "ITEM_ORDER_CODE", nullable = true, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private ItemOrder itemOrder;

    @ManyToOne
    @JoinColumn(name = "STOREHOUSE_CODE", nullable = true, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private StoreHouse storeHouse;




}
