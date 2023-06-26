package com.ynfinal.finalproject.manual.dto.response;

import com.ynfinal.finalproject.manual.entity.OrderDetail;
import lombok.*;

import java.math.BigDecimal;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDetailResponseDTO {
    private Long orderDetailSeq;
    private Long orderDetailQuantity;
    private Long orderDetailUnitPrice;
    private Float orderDetailTaxCode;
    private Float orderDetailVat;
    private String orderDetailEtc;
    private Long finishedCode;
    private String finishedName;
    private Long orderCode;


    public OrderDetailResponseDTO(OrderDetail orderDetail) {
        this.orderDetailSeq = orderDetail.getOrderDetailSeq();
        this.orderDetailQuantity = orderDetail.getOrderDetailQuantity();
        this.orderDetailUnitPrice = orderDetail.getOrderDetailUnitPrice();
        this.orderDetailTaxCode = orderDetail.getOrderDetailTaxCode();
        this.orderDetailVat = orderDetail.getOrderDetailVAT();
        this.orderDetailEtc = orderDetail.getOrderDetailEtc();
        this.finishedCode = orderDetail.getFinishedProduct().getFinishedCode();
        this.finishedName = orderDetail.getFinishedProduct().getFinishedName();
        this.orderCode = orderDetail.getOrderManage().getOrderCode();
    }

}
