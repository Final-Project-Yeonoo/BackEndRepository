package com.ynfinal.finalproject.manual.dto.request;

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
public class JobOrderRequestDTO {
    private Long jobOrderCode;
    @Enumerated(EnumType.STRING)
    private OrderType jobOrderStatus;
    @Enumerated(EnumType.STRING)
    private Status jobOrderType;
    private Date jobOrderInstructDate;
    private Date jobOrderFinishedDate;
    private Long jobOrderQuantity;
    private Long finishedCode;
    private Long projectCode;
    private Long storehouseCode;

    public JobOrder toEntity() {
        JobOrder jobOrder = new JobOrder();
        jobOrder.setJobOrderCode(this.jobOrderCode);
        jobOrder.setJobOrderStatus(this.jobOrderStatus);
        jobOrder.setJobOrderType(this.jobOrderType);
        jobOrder.setJobOrderInstructDate(this.jobOrderInstructDate);
        jobOrder.setJobOrderFinishedDate(this.jobOrderFinishedDate);
        jobOrder.setJobOrderQuantity(this.jobOrderQuantity);
        jobOrder.setFinishedProduct(FinishedProduct.builder().finishedCode(finishedCode).build());
        jobOrder.setProject(Project.builder().projectCode(projectCode).build());
        jobOrder.setStoreHouse(StoreHouse.builder().storehouseCode(storehouseCode).build());
        return jobOrder;
    }
}
