package com.ynfinal.finalproject.manual.dto.response;

import com.ynfinal.finalproject.inventory.products.entity.FinishedProduct;
import com.ynfinal.finalproject.manual.entity.JobOrder;
import com.ynfinal.finalproject.manual.entity.Performance;
import com.ynfinal.finalproject.manual.entity.Project;
import com.ynfinal.finalproject.manual.entity.Status;
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
public class PerformanceResponseDTO {
    private Long performanceCode;
    private Long performanceGoodCnt;
    private Long performanceBadCnt;
    private Date performanceStartdate;
    private Date performanceEnddate;
    private Date jobOrderInstructDate;
    private Long jobOrderCode;
    private Long jobOrderQuantity;
    private Long finishedCode;
    private String finishedName;
    private Long projectCode;
    private String projectName;
    @Enumerated(EnumType.STRING)
    private Status jobOrderType;

    public PerformanceResponseDTO(Performance performance) {
        this.performanceCode = performance.getPerformanceCode();
        this.performanceGoodCnt = performance.getPerformanceGoodCnt();
        this.performanceBadCnt = performance.getPerformanceBadCnt();
        this.performanceStartdate = performance.getPerformanceStartdate();
        this.performanceEnddate = performance.getPerformanceEnddate();
        this.jobOrderInstructDate = performance.getJobOrder().getJobOrderInstructDate();
        this.jobOrderCode = performance.getJobOrder().getJobOrderCode();
        this.jobOrderQuantity = performance.getJobOrder().getJobOrderQuantity();
        this.jobOrderType = performance.getJobOrder().getJobOrderType();
        this.finishedCode = performance.getFinishedProduct().getFinishedCode();
        this.finishedName = performance.getFinishedProduct().getFinishedName();
        this.projectCode = performance.getProject().getProjectCode();
        this.projectName = performance.getProject().getProjectName();
    }

}
