package com.ynfinal.finalproject.inventory.products.dto.request;

import com.ynfinal.finalproject.inventory.storeHouse.entity.StoreHouse;
import com.ynfinal.finalproject.organization.user.entity.Employees;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FinishedProductModifyRequestDTO {

    private Long finishedCode;
    private String finishedName;
    private int finishedCount;
    private int finishedPrice;
    private LocalDateTime finishedRegUpdate;
    private StoreHouse storeHouse;
    private Employees employees;
    private String finishedSize;

}
