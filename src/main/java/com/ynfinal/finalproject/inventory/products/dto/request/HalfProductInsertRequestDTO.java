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

    private String halfName;
    private String halfComment;
    private int halfCount;


    public HalfProduct toEntity(){

        return HalfProduct.builder()
                .halfCount(this.halfCount)
                .halfComment(this.halfComment)
                .halfName(this.halfName)
                .build();
    }
}

