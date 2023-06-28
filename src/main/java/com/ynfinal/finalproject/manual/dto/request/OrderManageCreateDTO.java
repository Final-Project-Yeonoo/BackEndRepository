package com.ynfinal.finalproject.manual.dto.request;

import com.ynfinal.finalproject.manual.entity.*;
import com.ynfinal.finalproject.organization.company.entity.TradeCompany;
import com.ynfinal.finalproject.organization.user.entity.Employees;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private OrderType orderType = OrderType.저장;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private EstimateOrderType estimateOrderType = EstimateOrderType.OEM;
    private Long projectCode;
    private Long empNo;
    private String empId;
    private Long estimateCode;
    private Date estimateDate;
    private Long trCompCode;


    public OrderManage toEntity() {
        OrderManage orderManage = new OrderManage();
        orderManage.setOrderCode(this.orderCode);
        orderManage.setOrderEtc(this.orderEtc);
        orderManage.setOrderDate(this.orderDate);
        orderManage.setOrderType(this.orderType);
        orderManage.setEstimateOrderType(this.estimateOrderType);
        orderManage.setProject(Project.builder().projectCode(this.projectCode).build());
        orderManage.setEmployees(Employees.builder().empId(this.empId).empNo(this.empNo).build());
        orderManage.setEstimateDate(this.estimateDate);
        orderManage.setTradeCompany(TradeCompany.builder().trCompCode(trCompCode).build());
        return orderManage;
    }

}
