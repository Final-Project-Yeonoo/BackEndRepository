package com.ynfinal.finalproject.inventory.products.dto.request;

import com.ynfinal.finalproject.inventory.products.entity.HalfProduct;
import com.ynfinal.finalproject.organization.user.entity.Employees;
import lombok.*;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class HalfProductInsertRequestDTO {

//    아이템코드
    private Long halfCode;
    private String halfName;
    private String halfComment;
    private int halfCount;
    private Long empNo;

    public HalfProduct toEntity(){

        return HalfProduct.builder()
                .halfCode(this.halfCode)
                .halfCount(this.halfCount)
                .halfComment(this.halfComment)
                .halfName(this.halfName)
                .employees(Employees.builder().empNo(empNo).build())
                .build();
    }
}

