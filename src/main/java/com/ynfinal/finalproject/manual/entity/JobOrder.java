package com.ynfinal.finalproject.manual.entity;

import com.ynfinal.finalproject.inventory.products.entity.FinishedProduct;
import com.ynfinal.finalproject.inventory.storeHouse.entity.StoreHouse;
import com.ynfinal.finalproject.organization.user.entity.Employees;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
@Table(name = "job_order")
public class JobOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jobOrderCode;
    @Enumerated(EnumType.STRING)
    private OrderType jobOrderStatus;
    @Enumerated(EnumType.STRING)
    private Status jobOrderType;
    @CreationTimestamp
    private Date jobOrderInstructDate;
    @CreationTimestamp
    private Date jobOrderFinishedDate;
    private Long jobOrderQuantity;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "finished_code", nullable = true, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private FinishedProduct finishedProduct;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_code", nullable = true, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Project project;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "storehouse_code", nullable = true, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private StoreHouse storeHouse;
}
