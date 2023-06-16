package com.ynfinal.finalproject.inventory.products.dto.request;

import com.ynfinal.finalproject.inventory.products.entity.RawProduct;
import lombok.*;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class InsertRawItemRequestDTO {

    private String rawName;
    private int rawCount;
    private int rawPrice;

    public RawProduct toEntity(){
        return RawProduct.builder()
                .rawName(getRawName())
                .rawCount(getRawCount())
                .rawPrice(getRawPrice())
                .build();
    }
}
