package com.ynfinal.finalproject.inventory.products.dto.request;

import com.ynfinal.finalproject.inventory.products.entity.FinishedProduct;
import com.ynfinal.finalproject.organization.user.entity.Employees;
import lombok.*;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class FinishedProductInsertRequestDTO {

    private String finishedName;
    private int finishedCount;
    private String finishedSize;





    public FinishedProduct toEntity(){
        return FinishedProduct.builder()
                .finishedName(this.finishedName)
                .finishedCount(this.finishedCount)
                .finishedSize(this.finishedSize)
                .build();
    }
}
