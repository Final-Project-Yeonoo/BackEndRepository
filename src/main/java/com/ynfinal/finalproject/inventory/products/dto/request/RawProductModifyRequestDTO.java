package com.ynfinal.finalproject.inventory.products.dto.request;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RawProductModifyRequestDTO {

    public Long rawCode;
    public String rawName;
    public int rawCount;
    public int rawPrice;
    private String rawType;
    private Long empNo;
    private LocalDateTime rawRegUpdate;


}
