package com.ynfinal.finalproject.organization.company.dto.request;

import com.ynfinal.finalproject.util.Check;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TradeCompanyRequestDTO {

    private String storehouseName;
    private LocalDate trStartDate;
    @Builder.Default
    @Enumerated(EnumType.STRING)
    private Check trBuy = Check.N;
    @Builder.Default
    @Enumerated(EnumType.STRING)
    private Check trSell = Check.N;
    private Long trCompCode;
    private String trCompName;
    private String trCompPhone;
    private String trAddr;
    private String trEtc;
}
