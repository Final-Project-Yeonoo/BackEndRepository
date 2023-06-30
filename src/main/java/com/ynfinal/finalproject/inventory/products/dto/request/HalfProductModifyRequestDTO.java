package com.ynfinal.finalproject.inventory.products.dto.request;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@ToString
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@Builder
public class HalfProductModifyRequestDTO {

    public Long halfCode;
    public String halfName;
    public int halfCount;
    public int halfPrice;
    private LocalDateTime halfRegUpdate;
    private Long empNo;
    private String halfComment;


}
