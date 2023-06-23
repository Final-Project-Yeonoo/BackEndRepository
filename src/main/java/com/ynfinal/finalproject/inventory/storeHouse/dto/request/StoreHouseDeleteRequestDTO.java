package com.ynfinal.finalproject.inventory.storeHouse.dto.request;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StoreHouseDeleteRequestDTO {
    private Long storehouseCode;

}
