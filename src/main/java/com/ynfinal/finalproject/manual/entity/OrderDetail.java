package com.ynfinal.finalproject.manual.entity;

import com.ynfinal.finalproject.inventory.products.entity.FinishedProduct;
import lombok.*;
import org.hibernate.annotations.Formula;

import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
@Table(name = "order_detail")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderDetailSeq;

    private Long orderDetailQuantity;
    private Long orderDetailUnitPrice;

    @Column(name = "order_detail_taxcode", columnDefinition = "FLOAT(10,2) DEFAULT 0.1")
    private float orderDetailTaxCode;

    @Formula("order_detail_unit_price * order_detail_quantity * order_detail_taxcode + order_detail_unit_price * order_detail_quantity")
    private float orderDetailVAT;

    @Column(name = "order_detail_etc", length = 200)
    private String orderDetailEtc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "finished_code", nullable = true, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private FinishedProduct finishedProduct;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_code", nullable = true, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private OrderManage orderManage;

}
