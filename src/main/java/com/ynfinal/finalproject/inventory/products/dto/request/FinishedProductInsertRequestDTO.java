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
    private Long finishedCode;
    private String finishedName;
    private Long empNo;
    private String finishedSize;





    public FinishedProduct toEntity(){
        return FinishedProduct.builder()
                .finishedCode(this.finishedCode)
                .finishedName(this.finishedName)
                .employees(Employees.builder().empNo(empNo).build())
                .finishedSize(this.finishedSize)
                .build();
    }
}
