package com.ynfinal.finalproject.inventory.products.dto.response;

import com.ynfinal.finalproject.inventory.products.entity.HalfProduct;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class HalfProductListResponseDTO {

    private Long halfCode;
    private String halfName;
    private int halfCount;
    private LocalDateTime halfRegDate;
    private LocalDateTime halfRegUpdate;
    private int halfPrice;

    public HalfProductListResponseDTO(HalfProduct halfProduct) {
        this.halfCode = halfProduct.getHalfCode();
        this.halfName = halfProduct.getHalfName();
        this.halfPrice = halfProduct.getHalfPrice();
        this.halfCount = halfProduct.getHalfCount();
        this.halfRegDate = halfProduct.getHalfRegDate();
        this.halfRegUpdate = halfProduct.getHalfRegUpdate();
    }
}
