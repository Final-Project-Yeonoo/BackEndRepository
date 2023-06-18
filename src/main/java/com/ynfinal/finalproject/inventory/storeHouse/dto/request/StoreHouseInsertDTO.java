package com.ynfinal.finalproject.inventory.storeHouse.dto.request;

import com.ynfinal.finalproject.inventory.storeHouse.entity.StoreHouse;
import com.ynfinal.finalproject.inventory.storeHouse.entity.StoreHouseType;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class StoreHouseInsertDTO {

    private String storehouseName;
    private StoreHouseType storehouseType;
    private String storehouseAddr;
    private LocalDateTime storehouseStartDate;


    public StoreHouse toEntity(){
        return StoreHouse.builder()
                .storehouseName(this.storehouseName)
                .storehouseType(this.storehouseType)
                .storehouseAddr(this.storehouseAddr)
                .build();
    }


}
