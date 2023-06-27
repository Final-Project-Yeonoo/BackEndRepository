package com.ynfinal.finalproject.manual.dto.request;

import com.ynfinal.finalproject.inventory.products.entity.FinishedProduct;
import com.ynfinal.finalproject.manual.entity.JobOrder;
import com.ynfinal.finalproject.manual.entity.Performance;
import com.ynfinal.finalproject.manual.entity.Project;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PerformanceRequestDTO {
    private Long performanceCode;
    private Long performanceGoodCnt;
    private Long performanceBadCnt;
    private Date performanceStartdate;
    private Date performanceEnddate;
    private Long jobOrderCode;
    private Long finishedCode;
    private Long projectCode;

    public Performance toEntity() {
        Performance performance = new Performance();
        performance.setPerformanceCode(this.performanceCode);
        performance.setPerformanceGoodCnt(this.performanceGoodCnt);
        performance.setPerformanceBadCnt(this.performanceBadCnt);
        performance.setPerformanceStartdate(this.performanceStartdate);
        performance.setPerformanceEnddate(this.performanceEnddate);
        performance.setJobOrder(JobOrder.builder().jobOrderCode(jobOrderCode).build());
        performance.setFinishedProduct(FinishedProduct.builder().finishedCode(finishedCode).build());
        performance.setProject(Project.builder().projectCode(projectCode).build());
        return performance;
    }
}
