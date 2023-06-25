package com.ynfinal.finalproject.manual.dto.request;


import com.ynfinal.finalproject.inventory.products.entity.FinishedProduct;
import com.ynfinal.finalproject.manual.entity.OrderDetail;
import com.ynfinal.finalproject.manual.entity.OrderManage;
import lombok.*;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDetailCreateDTO {
    private Long orderDetailSeq;
    private Long orderDetailQuantity;
    private Long orderDetailUnitPrice;
    private Float orderDetailTaxCode;
    private String orderDetailEtc;
    private Long finishedCode;
    private Long orderCode;

    public OrderDetail toEntity() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderDetailSeq(orderDetailSeq);
        orderDetail.setOrderDetailQuantity(orderDetailQuantity);
        orderDetail.setOrderDetailUnitPrice(orderDetailUnitPrice);
        orderDetail.setOrderDetailTaxCode(orderDetailTaxCode);
        orderDetail.setOrderDetailEtc(orderDetailEtc);
        orderDetail.setFinishedProduct(FinishedProduct.builder().finishedCode(finishedCode).build());
        orderDetail.setOrderManage(OrderManage.builder().orderCode(orderCode).build());
        return orderDetail;
    }


}
