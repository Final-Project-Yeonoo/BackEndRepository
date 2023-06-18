package com.ynfinal.finalproject.inventory.products.dto.request;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RawProductModifyRequestDTO {

    public Long rawCode;
    public String rawName;
    public int rawCount;
    public int rawPrice;

}
