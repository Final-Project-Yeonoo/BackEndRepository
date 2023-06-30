package com.ynfinal.finalproject.inventory.products.dto.request;

import com.ynfinal.finalproject.inventory.products.entity.RawProduct;
import com.ynfinal.finalproject.organization.user.entity.Employees;
import lombok.*;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class RawProductInsertRequestDTO {
//    private Long rawCode;
    private String rawName;
    private String rawType;
    private Long empNo;
    public RawProduct toEntity() {
        return RawProduct.builder()
//                .rawCode(this.rawCode)
                .rawName(this.rawName)
                .rawType(this.rawType)
                .employees(Employees.builder().empNo(empNo).build())
                .build();
    }

}
