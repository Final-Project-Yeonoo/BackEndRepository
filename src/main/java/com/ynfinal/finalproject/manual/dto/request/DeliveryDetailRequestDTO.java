package com.ynfinal.finalproject.manual.dto.request;

import com.ynfinal.finalproject.inventory.products.entity.FinishedProduct;
import com.ynfinal.finalproject.manual.entity.DeliveryDetail;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeliveryDetailRequestDTO {
    private Long deliveryDetailCode;
    private Long deliveryDetailQuantity;
    private Long deliveryDetailUnitprice;
    private Float deliveryDetailTaxcode;
    private Float deliveryDetailVat;
    private Long finishedCode;

    public DeliveryDetail toEntity() {
        DeliveryDetail deliveryDetail = new DeliveryDetail();
        deliveryDetail.setDeliveryDetailCode(this.deliveryDetailCode);
        deliveryDetail.setDeliveryDetailQuantity(this.deliveryDetailQuantity);
        deliveryDetail.setDeliveryDetailUnitprice(this.deliveryDetailUnitprice);
        deliveryDetail.setDeliveryDetailTaxcode(this.deliveryDetailTaxcode);
        deliveryDetail.setDeliveryDetailVat(this.deliveryDetailVat);
        deliveryDetail.setFinishedProduct(FinishedProduct.builder().finishedCode(this.finishedCode).build());
        return deliveryDetail;
    }
}
