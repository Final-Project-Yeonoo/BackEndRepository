package com.ynfinal.finalproject.inventory.products.dto.request;

import com.ynfinal.finalproject.inventory.products.entity.HalfProduct;
import lombok.*;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class HalfProductInsertRequestDTO {

    private String halfName;
    private int halfPrice;
    private int halfCount;

    public HalfProduct toEntity(){

        return HalfProduct.builder()
                .halfCount(this.halfCount)
                .halfName(this.halfName)
                .halfPrice(this.halfPrice)
                .build();
    }
}

