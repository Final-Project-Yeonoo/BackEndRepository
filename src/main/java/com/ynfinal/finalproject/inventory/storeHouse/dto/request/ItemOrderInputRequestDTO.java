package com.ynfinal.finalproject.inventory.storeHouse.dto.request;

import com.ynfinal.finalproject.inventory.storeHouse.entity.ItemOrder;
import com.ynfinal.finalproject.organization.company.entity.TradeCompany;
import com.ynfinal.finalproject.organization.user.entity.Employees;
import com.ynfinal.finalproject.util.Check;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;
import java.util.Date;
//  발주서 등록 요청 DTO
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemOrderInputRequestDTO {

    // 발주서의 저장, 확정 확인
    @Enumerated(EnumType.STRING)
    private Check itemOrderCheck;

    // 입고 예정 일자 / 발주일? -> 추가하거나 하나마 사용하거나 해야돼요
    private Date itemOrderStart;

    // 발주서 작성 및 등록일
    private LocalDateTime itemOrderReg;
    // 발주서 수정일
    private LocalDateTime itemOrderUpdate;
    // 발주 담당자 코드
    private Long empNo;
    // 발주 담당자 이름
    private String empName;
    // 거래처 코드
    private Long trCompCode;
    // 거래처 이름
    private String trCompName;


    public ItemOrder toEntity() {
        ItemOrder itemOrder = ItemOrder.builder()
                // 발주서 코드 생성 -> 생성할거라면 사용
                .itemOrderCheck(this.itemOrderCheck)
                .itemOrderStart(this.itemOrderStart)
                .itemOrderReg(this.itemOrderReg)
                .itemOrderUpdate(this.itemOrderUpdate)
                .employees(Employees.builder().empNo(empNo).build())
                .tradeCompany(TradeCompany.builder().trCompCode(trCompCode).build())
                .build();

        return itemOrder;
    }
}
