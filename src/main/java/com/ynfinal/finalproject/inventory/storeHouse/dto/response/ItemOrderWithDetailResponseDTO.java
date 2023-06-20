package com.ynfinal.finalproject.inventory.storeHouse.dto.response;


import com.ynfinal.finalproject.inventory.storeHouse.entity.StoreHouseType;
import com.ynfinal.finalproject.util.Check;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemOrderWithDetailResponseDTO {

     // item order에 딸린 디테일을 가져와된다
     private Long itemOrderCode;

     // item order detail 필드
     private String itemOderDetailName;
     private int itemOrderNetPrice;
     private double taxCode;
     private int itemOrderCount;


}
