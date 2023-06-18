package com.ynfinal.finalproject.inventory.products.dto.request;

import com.ynfinal.finalproject.inventory.products.entity.FinishedProduct;
import lombok.*;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class FinishedProductInsertRequestDTO {

    private String finishedName;
    private int finishedPrice;
    private int finishedCount;

    public FinishedProduct toEntity(){
        return FinishedProduct.builder()
                .finishedName(this.finishedName)
                .finishedCount(this.finishedCount)
                .finishedPrice(this.finishedPrice)
                .build();
    }
}
