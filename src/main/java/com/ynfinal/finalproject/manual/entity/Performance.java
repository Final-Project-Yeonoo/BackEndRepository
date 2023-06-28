package com.ynfinal.finalproject.manual.entity;

import com.ynfinal.finalproject.inventory.products.entity.FinishedProduct;
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
@Table(name = "PERFORMANCE")
public class Performance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long performanceCode;
    private Long performanceGoodCnt;
    private Long performanceBadCnt;
    @CreationTimestamp
    private Date performanceStartdate;
    @CreationTimestamp
    private Date performanceEnddate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_order_code")
    private JobOrder jobOrder;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "finished_code")
    private FinishedProduct finishedProduct;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_code", nullable = true, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Project project;
}
