package com.ynfinal.finalproject.manual.dto.response;

import com.ynfinal.finalproject.manual.entity.EstimateOrderType;
import com.ynfinal.finalproject.manual.entity.OrderManage;
import com.ynfinal.finalproject.manual.entity.OrderType;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
    @Enumerated(EnumType.STRING)
    private OrderType orderType;
    private Long projectCode;
    private String projectName;
    private Long empNo;
    private String empId;
    private String empName;
    private Date estimateDate;
    @Enumerated(EnumType.STRING)
    private EstimateOrderType estimateOrderType;

    private Long trCompCode;
    private String trCompName;




    public OrderManageResponseDTO(OrderManage orderManage) {
        this.orderCode = orderManage.getOrderCode();
        this.orderEtc = orderManage.getOrderEtc();
        this.orderDate = orderManage.getOrderDate();
        this.orderType = orderManage.getOrderType();
        this.projectCode = orderManage.getProject().getProjectCode();
        this.projectName = orderManage.getProject().getProjectName();
        this.empNo = orderManage.getEmployees().getEmpNo();
        this.empId = orderManage.getEmployees().getEmpId();
        this.empName = orderManage.getEmployees().getEmpName();
        this.estimateDate = orderManage.getEstimateDate();
        this.estimateOrderType = orderManage.getEstimateOrderType();
        this.trCompName = orderManage.getTradeCompany().getTrCompName();
        this.trCompCode = orderManage.getTradeCompany().getTrCompCode();
    }



}
