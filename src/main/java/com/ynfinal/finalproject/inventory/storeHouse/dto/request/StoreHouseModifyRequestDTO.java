package com.ynfinal.finalproject.inventory.storeHouse.dto.request;

import com.ynfinal.finalproject.inventory.storeHouse.entity.StoreHouseType;
import lombok.*;

@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StoreHouseModifyRequestDTO {

    private Long storehouseCode;
    private String storehouseName;
    private String storehouseAddr;
    private StoreHouseType storehouseType;




}
