package com.ynfinal.finalproject.inventory.storeHouse.dto.response;

import com.ynfinal.finalproject.inventory.storeHouse.entity.ItemOrder;
import com.ynfinal.finalproject.util.Check;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemOrderListResponseDTO {

    private Long itemOrderCode;
    private Check itemOrderCheck;
    private Date itemOrderStart;
    private Date itemOrderEnd;
    private LocalDateTime itemOrderReg;
    private LocalDateTime itemOrderUpdate;


    public ItemOrderListResponseDTO(ItemOrder itemOrder) {

        this.itemOrderCode = itemOrder.getItemOrderCode();
        this.itemOrderCheck = itemOrder.getItemOrderCheck();
        this.itemOrderStart = itemOrder.getItemOrderStart();
        this.itemOrderEnd = itemOrder.getItemOrderEnd();
        this.itemOrderReg = itemOrder.getItemOrderReg();
        this.itemOrderUpdate = itemOrder.getItemOrderUpdate();

    }
}
