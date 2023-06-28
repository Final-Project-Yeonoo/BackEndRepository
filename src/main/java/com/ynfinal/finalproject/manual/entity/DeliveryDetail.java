package com.ynfinal.finalproject.manual.entity;

import com.ynfinal.finalproject.inventory.products.entity.FinishedProduct;
import com.ynfinal.finalproject.organization.user.entity.Employees;
import lombok.*;
import org.apache.ibatis.annotations.Many;

import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
@Table(name = "DELIVERY_DETAIL")
public class DeliveryDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deliveryDetailCode;
    private Long deliveryDetailQuantity;
    private Long deliveryDetailUnitprice;
    private Float deliveryDetailTaxcode;
    private Float deliveryDetailVat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_code", nullable = true, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Delivery delivery;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "finished_code", nullable = true, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private FinishedProduct finishedProduct;

}
