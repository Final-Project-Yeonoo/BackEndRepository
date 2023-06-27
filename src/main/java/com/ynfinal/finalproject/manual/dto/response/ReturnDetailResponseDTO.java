package com.ynfinal.finalproject.manual.dto.response;

import com.ynfinal.finalproject.inventory.products.entity.FinishedProduct;
import com.ynfinal.finalproject.manual.entity.ReturnDetail;
import com.ynfinal.finalproject.manual.entity.Returned;
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
public class ReturnDetailResponseDTO {
    private Long returnDetailCode;
    private Date returnDetailReceiptDate;
    private Long returnDetailQuantity;
    private Long finishedCode;
    private String finishedName;

    public ReturnDetailResponseDTO(ReturnDetail returnDetail) {
        this.returnDetailCode = returnDetail.getReturnDetailCode();
        this.returnDetailReceiptDate = returnDetail.getReturnDetailReceiptDate();
        this.returnDetailQuantity = returnDetail.getReturnDetailQuantity();
        this.finishedCode = returnDetail.getFinishedProduct().getFinishedCode();
        this.finishedName = returnDetail.getFinishedProduct().getFinishedName();
    }


}
