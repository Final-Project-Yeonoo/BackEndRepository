package com.ynfinal.finalproject.inventory.products.dto.request;

import lombok.*;

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

}
