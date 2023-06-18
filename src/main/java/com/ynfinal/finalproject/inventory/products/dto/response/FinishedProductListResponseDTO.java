package com.ynfinal.finalproject.inventory.products.dto.response;

import com.ynfinal.finalproject.inventory.products.entity.FinishedProduct;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class FinishedProductListResponseDTO {

    private Long finishedCode;
    private String finishedName;
    private int finishedCount;
    private LocalDateTime finishedRegDate;
    private LocalDateTime finishedRegUpdate;
    private int finishedPrice;


    public FinishedProductListResponseDTO(FinishedProduct finishedProduct) {
        this.finishedCode = finishedProduct.getFinishedCode();
        this.finishedName = finishedProduct.getFinishedName();
        this.finishedCount = finishedProduct.getFinishedCount();
        this.finishedPrice = finishedProduct.getFinishedPrice();
        this.finishedRegDate = finishedProduct.getFinishedRegDate();
        this.finishedRegUpdate = finishedProduct.getFinishedRegUpdate();

    }
}
