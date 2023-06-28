package com.ynfinal.finalproject.manual.dto.request;

import com.ynfinal.finalproject.inventory.products.entity.FinishedProduct;
import com.ynfinal.finalproject.manual.entity.OrderType;
import com.ynfinal.finalproject.manual.entity.ReturnDetail;
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
public class ReturnDetailRequestDTO {
    private Long returnDetailCode;
    private Date returnDetailReceiptDate;
    private Long returnDetailQuantity;
    private Long finishedCode;
    private Long returnedCode;
    public ReturnDetail toEntity() {
        ReturnDetail returnDetail = new ReturnDetail();
        returnDetail.setReturnDetailCode(this.returnDetailCode);
        returnDetail.setReturnDetailReceiptDate(this.returnDetailReceiptDate);
        returnDetail.setReturnDetailQuantity(this.returnDetailQuantity);
        returnDetail.setFinishedProduct(FinishedProduct.builder().finishedCode(finishedCode).build());
        returnDetail.setReturned(Returned.builder().returnedCode(returnedCode).build());
        return returnDetail;
    }
}
