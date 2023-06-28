package com.ynfinal.finalproject.manual.dto.request;

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
public class ReturnedRequestDTO {
    private Long returnedCode;
    @Enumerated(EnumType.STRING)
    private OrderType returnedStatus;
    private Date returnedDate;
    private Long returnedReceipt;
    private Long trCompCode;



    public Returned toEntity() {
        Returned returned = new Returned();
        returned.setReturnedCode(this.returnedCode);
        returned.setReturnedStatus(this.returnedStatus);
        returned.setReturnedDate(this.returnedDate);
        returned.setReturnedReceipt(this.returnedReceipt);
        returned.setTradeCompany(TradeCompany.builder().trCompCode(trCompCode).build());
        return returned;
    }
}
