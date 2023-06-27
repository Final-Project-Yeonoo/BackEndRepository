package com.ynfinal.finalproject.manual.dto.response;

import com.ynfinal.finalproject.manual.entity.Charge;
import com.ynfinal.finalproject.manual.entity.Delivery;
import com.ynfinal.finalproject.manual.entity.OrderType;
import com.ynfinal.finalproject.organization.company.entity.TradeCompany;
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
@Builder
public class DeliveryResponseDTO {
    private Long deliveryCode;
    @Enumerated(EnumType.STRING)
    private OrderType deliveryStatus;
    @Enumerated(EnumType.STRING)
    private Charge deliveryCharge;
    private Date deliveryDate;
    private Date deliveryRegDate;
    private Date deliveryModifyDate;
    private Long trCompCode;
    private String trCompName;
    private Long empNo;
    private String empId;

    public DeliveryResponseDTO(Delivery delivery){
        this.deliveryCode = delivery.getDeliveryCode();
        this.deliveryStatus = delivery.getDeliveryStatus();
        this.deliveryCharge = delivery.getDeliveryCharge();
        this.deliveryDate = delivery.getDeliveryDate();
        this.deliveryRegDate = delivery.getDeliveryRegDate();
        this.deliveryModifyDate = delivery.getDeliveryModifyDate();
        this.trCompCode = delivery.getTradeCompany().getTrCompCode();
        this.trCompName = delivery.getTradeCompany().getTrCompName();
        this.empNo = delivery.getEmployees().getEmpNo();
        this.empId = delivery.getEmployees().getEmpId();
    }
}
