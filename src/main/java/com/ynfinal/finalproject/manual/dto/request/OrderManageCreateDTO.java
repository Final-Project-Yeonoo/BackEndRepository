package com.ynfinal.finalproject.manual.dto.request;

import com.ynfinal.finalproject.manual.entity.Estimate;
import com.ynfinal.finalproject.manual.entity.OrderManage;
import com.ynfinal.finalproject.manual.entity.OrderType;
import com.ynfinal.finalproject.manual.entity.Project;
import com.ynfinal.finalproject.organization.user.entity.Employees;
import lombok.*;

import java.util.Date;
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderManageCreateDTO {
    private Long orderCode;
    private String orderEtc;
    private Date orderDate;
    private OrderType orderType;
    private Long projectCode;
    private Long empNo;
    private Long estimateCode;

    public OrderManage toEntity() {
        OrderManage orderManage = new OrderManage();
        orderManage.setOrderCode(this.orderCode);
        orderManage.setOrderEtc(this.orderEtc);
        orderManage.setOrderDate(this.orderDate);
        orderManage.setOrderType(this.orderType);
        orderManage.setProject(Project.builder().projectCode(this.projectCode).build());
        orderManage.setEmployees(Employees.builder().empNo(this.empNo).build());
        orderManage.setEstimate(Estimate.builder().estimateCode(this.estimateCode).build());
        return orderManage;
    }

}
