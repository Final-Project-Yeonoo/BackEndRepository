package com.ynfinal.finalproject.inventory.products.dto.request;

import com.ynfinal.finalproject.inventory.products.entity.RawProduct;
import lombok.*;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class RawProductInsertRequestDTO {

    private String rawName;
    private Integer rawCount;
    private Integer rawPrice;

    public RawProduct toEntity() {
        RawProduct rawProduct = new RawProduct();
        rawProduct.setRawName(this.rawName);
        rawProduct.setRawCount(this.rawCount);
        rawProduct.setRawPrice(this.rawPrice);
        return rawProduct;
    }

}
