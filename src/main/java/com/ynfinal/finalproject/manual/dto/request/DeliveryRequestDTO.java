package com.ynfinal.finalproject.manual.dto.request;

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
public class DeliveryRequestDTO {
    private Long deliveryCode;
    @Enumerated(EnumType.STRING)
    private OrderType deliveryStatus;
    @Enumerated(EnumType.STRING)
    private Charge deliveryCharge;
    private Date deliveryDate;
    private Date deliveryRegDate;
    private Date deliveryModifyDate;
    private Long trCompCode;
    private String empId;

    public Delivery toEntity() {
        Delivery delivery = new Delivery();
        delivery.setDeliveryCode(this.deliveryCode);
        delivery.setDeliveryStatus(this.deliveryStatus);
        delivery.setDeliveryCharge(this.deliveryCharge);
        delivery.setDeliveryDate(this.deliveryDate);
        delivery.setDeliveryRegDate(this.deliveryRegDate);
        delivery.setDeliveryModifyDate(this.deliveryModifyDate);
        delivery.setTradeCompany(TradeCompany.builder().trCompCode(trCompCode).build());
        delivery.setEmployees(Employees.builder().empId(empId).build());
        return delivery;
    }
}
