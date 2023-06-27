package com.ynfinal.finalproject.manual.dto.response;

import com.ynfinal.finalproject.inventory.products.entity.FinishedProduct;
import com.ynfinal.finalproject.inventory.storeHouse.entity.StoreHouse;
import com.ynfinal.finalproject.manual.entity.JobOrder;
import com.ynfinal.finalproject.manual.entity.OrderType;
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
public class JobOrderResponseDTO {
    private Long jobOrderCode;
    @Enumerated(EnumType.STRING)
    private OrderType jobOrderStatus;
    @Enumerated(EnumType.STRING)
    private Status jobOrderType;
    private Date jobOrderInstructDate;
    private Date jobOrderFinishedDate;
    private Long jobOrderQuantity;

    private Long finishedCode;
    private String finishedName;
    private Long projectCode;
    private String projectName;
    private Long storehouseCode;
    private String storehouseName;

    public JobOrderResponseDTO(JobOrder jobOrder){
        this.jobOrderCode = jobOrder.getJobOrderCode();
        this.jobOrderStatus = jobOrder.getJobOrderStatus();
        this.jobOrderType = jobOrder.getJobOrderType();
        this.jobOrderInstructDate = jobOrder.getJobOrderInstructDate();
        this.jobOrderFinishedDate = jobOrder.getJobOrderFinishedDate();
        this.jobOrderQuantity = jobOrder.getJobOrderQuantity();

        this.finishedCode = jobOrder.getFinishedProduct().getFinishedCode();
        this.finishedName = jobOrder.getFinishedProduct().getFinishedName();
        this.projectCode = jobOrder.getProject().getProjectCode();
        this.projectName = jobOrder.getProject().getProjectName();
        this.storehouseCode = jobOrder.getStoreHouse().getStorehouseCode();
        this.storehouseName = jobOrder.getStoreHouse().getStorehouseName();
    }
}
