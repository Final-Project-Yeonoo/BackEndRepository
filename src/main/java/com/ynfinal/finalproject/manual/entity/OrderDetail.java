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
@Table(name = "ORDER_DETAIL")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_DETAIL_SEQ")
    private Long orderDetailSeq;

    @Column(name = "ORDER_DETAIL_QUANTITY")
    private Long orderDetailQuantity;

    @Column(name = "ORDER_DETAIL_UNITPRICE")
    private Long orderDetailUnitPrice;

    @Column(name = "ORDER_DETAIL_TAXCODE", columnDefinition = "FLOAT(10,2) DEFAULT 0.1")
    private float orderDetailTaxCode;

    @Formula("ORDER_DETAIL_UNITPRICE * ORDER_DETAIL_QUANTITY * ORDER_DETAIL_TAXCODE + ORDER_DETAIL_UNITPRICE * ORDER_DETAIL_QUANTITY")
    private float orderDetailVAT;

    @Column(name = "ORDER_DETAIL_ETC", length = 200)
    private String orderDetailEtc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FINISHED_CODE", nullable = true, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private FinishedProduct finishedProduct;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_CODE", nullable = true, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private OrderManage orderManage;

}
