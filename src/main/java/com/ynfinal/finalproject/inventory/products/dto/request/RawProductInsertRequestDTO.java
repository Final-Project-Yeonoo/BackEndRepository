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
    private Long rawCode;
    private String rawName;
    private Integer rawCount;

    private String rawType;

    public RawProduct toEntity() {
        return RawProduct.builder()
                .rawCode(this.rawCode)
                .rawName(this.rawName)
                .rawCount(this.rawCount)
                .rawCode(this.rawCode)
                .build();
    }

}
