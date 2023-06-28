package com.ynfinal.finalproject.manual.dto.response;

import com.ynfinal.finalproject.inventory.products.entity.FinishedProduct;
import com.ynfinal.finalproject.manual.entity.DeliveryDetail;
import com.ynfinal.finalproject.manual.entity.Estimate;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeliveryDetailResponseDTO {
    private Long deliveryDetailCode;
    private Long deliveryDetailQuantity;
    private Long deliveryDetailUnitprice;
    private Float deliveryDetailTaxcode;
    private Float deliveryDetailVat;
    private Long finishedCode;
    private String finishedName;
    private Long deliveryCode;
    public DeliveryDetailResponseDTO(DeliveryDetail deliveryDetail) {
        this.deliveryDetailCode = deliveryDetail.getDeliveryDetailCode();
        this.deliveryDetailQuantity = deliveryDetail.getDeliveryDetailQuantity();
        this.deliveryDetailUnitprice = deliveryDetail.getDeliveryDetailUnitprice();
        this.deliveryDetailTaxcode = deliveryDetail.getDeliveryDetailTaxcode();
        this.deliveryDetailVat = deliveryDetail.getDeliveryDetailVat();
        this.finishedCode = deliveryDetail.getFinishedProduct().getFinishedCode();
        this.finishedName = deliveryDetail.getFinishedProduct().getFinishedName();
        this.deliveryCode = deliveryDetail.getDelivery().getDeliveryCode();
    }
}
