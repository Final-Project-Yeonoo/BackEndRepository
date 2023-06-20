package com.ynfinal.finalproject.organization.company.dto.response;

import com.ynfinal.finalproject.inventory.storeHouse.entity.StoreHouse;
import com.ynfinal.finalproject.organization.user.entity.Employees;
import com.ynfinal.finalproject.util.Check;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TradeCompanyResponseDTO {
    private Long trCompCode;
    private String trCompName;
    private String trCompRegNo;
    private String trCompCeo;
    private String trCompPhone;
    private Check trBuy;
    private Check trSell;
    private LocalDateTime trStartDate;
    private LocalDateTime trEndDate;
    private LocalDateTime trRegDate;
    private LocalDateTime trUpdateDate;
    private String trAddr;
    private String storehouseName;
    private String empName;
    private String trEtc;

}
