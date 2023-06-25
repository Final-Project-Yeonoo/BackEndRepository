package com.ynfinal.finalproject.manual.dto.response;

import com.ynfinal.finalproject.manual.entity.EstimateOrderType;
import com.ynfinal.finalproject.manual.entity.OrderManage;
import com.ynfinal.finalproject.manual.entity.OrderType;
import lombok.*;

import java.util.Date;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderManageResponseDTO {
    private Long orderCode;
    private String orderEtc;
    private Date orderDate;
    private OrderType orderType;
    private Long projectCode;
    private String projectName;
    private Long empNo;
    private String empName;
    private Date estimateDate;
    private EstimateOrderType estimateOrderType;
    private String trCompName;

    public OrderManageResponseDTO(OrderManage orderManage) {
        this.orderCode = orderManage.getOrderCode();
        this.orderEtc = orderManage.getOrderEtc();
        this.orderDate = orderManage.getOrderDate();
        this.orderType = orderManage.getOrderType();
        this.projectCode = orderManage.getProject().getProjectCode();
        this.projectName = orderManage.getProject().getProjectName();
        this.empNo = orderManage.getEmployees().getEmpNo();
        this.empName = orderManage.getEmployees().getEmpName();
        this.estimateDate = orderManage.getEstimate().getEstimateDate();
        this.estimateOrderType = orderManage.getEstimate().getEstimateOrderType();
        this.trCompName = orderManage.getEstimate().getTradeCompany().getTrCompName();
    }



}
