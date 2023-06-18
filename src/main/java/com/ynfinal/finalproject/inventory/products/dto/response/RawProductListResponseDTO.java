package com.ynfinal.finalproject.inventory.products.dto.response;

import com.ynfinal.finalproject.inventory.products.entity.RawProduct;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class RawProductListResponseDTO {

    private Long rawCode;
    private String rawName;
    private int rawCount;
    private LocalDateTime rawRegDate;
    private LocalDateTime rawRegUpdate;
    private int rawPrice;

    public RawProductListResponseDTO(RawProduct rawProduct){
        this.rawCode = (rawProduct.getRawCode());
        this.rawName = rawProduct.getRawName();
        this.rawCount = rawProduct.getRawCount();
        this.rawRegDate = rawProduct.getRawRegDate();
        this.rawRegUpdate = rawProduct.getRawRegUpdate();
        this.rawPrice = rawProduct.getRawPrice();
    }
}
