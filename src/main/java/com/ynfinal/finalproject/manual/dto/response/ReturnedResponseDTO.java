package com.ynfinal.finalproject.manual.dto.response;

import com.ynfinal.finalproject.manual.entity.OrderType;
import com.ynfinal.finalproject.manual.entity.Returned;
import com.ynfinal.finalproject.organization.company.entity.TradeCompany;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReturnedResponseDTO {
    private Long returnedCode;
    @Enumerated(EnumType.STRING)
    private OrderType returnedStatus;
    private Date returnedDate;
    private Long returnedReceipt;
    private Long trCompCode;
    private String trCompName;

    public ReturnedResponseDTO(Returned returned) {
        this.returnedCode = returned.getReturnedCode();
        this.returnedStatus = returned.getReturnedStatus();
        this.returnedDate = returned.getReturnedDate();
        this.returnedReceipt = returned.getReturnedReceipt();
        this.trCompCode = returned.getTradeCompany().getTrCompCode();
        this.trCompName = returned.getTradeCompany().getTrCompName();
    }
}
