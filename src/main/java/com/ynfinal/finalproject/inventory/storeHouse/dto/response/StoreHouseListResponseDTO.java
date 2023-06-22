package com.ynfinal.finalproject.inventory.storeHouse.dto.response;

import com.ynfinal.finalproject.inventory.storeHouse.entity.StoreHouse;
import com.ynfinal.finalproject.inventory.storeHouse.entity.StoreHouseType;
import lombok.*;

import java.util.Date;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StoreHouseListResponseDTO {

    private Long storehouseCode;
    private String storehouseName;
    private String storehouseType;
    private Date storehouseStartDate;
    private String storehouseAddr;


    public StoreHouseListResponseDTO(StoreHouse storeHouse) {

        this.storehouseCode = storeHouse.getStorehouseCode();
        this.storehouseName = storeHouse.getStorehouseName();
        this.storehouseAddr = storeHouse.getStorehouseAddr();
        this.storehouseStartDate = storeHouse.getStorehouseStartDate();
        this.storehouseType = String.valueOf(storeHouse.getStorehouseType());

    }
}
