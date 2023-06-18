package com.ynfinal.finalproject.inventory.products.dto.request;

import lombok.*;

@Getter
@ToString
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@Builder
public class HalfProductModifyRequestDTO {

    public Long halfCode;
    public String halfName;
    public int halfCount;
    public int halfPrice;

}
