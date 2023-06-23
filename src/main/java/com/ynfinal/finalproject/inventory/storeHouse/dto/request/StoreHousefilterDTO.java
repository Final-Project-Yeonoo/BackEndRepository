package com.ynfinal.finalproject.inventory.storeHouse.dto.request;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Builder
public class StoreHousefilterDTO {
    private String storehouseName;
    private String storehouseType;
    private String storehouseAddr;
    private String storehouseEtc;

}
