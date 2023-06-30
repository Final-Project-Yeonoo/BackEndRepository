package com.ynfinal.finalproject.inventory.storeHouse.dto.request;

import com.ynfinal.finalproject.inventory.storeHouse.entity.StoreHouse;
import com.ynfinal.finalproject.inventory.storeHouse.entity.StoreHouseType;
import lombok.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class StoreHouseInsertDTO {
    private Long storehouseCode;
    private String storehouseName;
    @Builder.Default
    private String storehouseType = "FINISHED";
    private String storehouseAddr;
    private Date storehouseStartDate;
    private String storehouseEtc;

    public StoreHouse toEntity(){


            return StoreHouse.builder()
                    .storehouseCode(this.storehouseCode)
                    .storehouseName(this.storehouseName)
                    .storehouseType(StoreHouseType.valueOf(this.storehouseType))
                    .storehouseStartDate(this.storehouseStartDate)
                    .storehouseAddr(this.storehouseAddr)
                    .storehouseEtc(this.storehouseEtc)
                    .build();

    }


}
