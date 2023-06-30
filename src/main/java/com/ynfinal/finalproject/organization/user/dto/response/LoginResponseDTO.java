package com.ynfinal.finalproject.organization.user.dto.response;

import com.ynfinal.finalproject.organization.user.entity.Authorization;
import com.ynfinal.finalproject.organization.user.entity.Employees;
import com.ynfinal.finalproject.util.Check;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;


// 로그인이 성공 후 클라이언트에게 전송할 데이터객체
@Getter
@ToString @EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginResponseDTO {
    private Long empNo;
    private String empId;
    private String empName;
    private String token; // 인증 토큰


    private String userAuth;
    private String infoAuth;
    private String purchaseAuth;
    private String inventoryAuth;
    private String empProfile;
//    private String message; // 로그인 메시지
    public LoginResponseDTO(Employees employees, String token, Authorization authorization) {
        this.empNo = employees.getEmpNo();
        this.empId = employees.getEmpId();
        this.empName = employees.getEmpName();
        this.userAuth = String.valueOf(authorization.getUserAuth());
        this.infoAuth = String.valueOf(authorization.getInfoAuth());
        this.purchaseAuth = String.valueOf(authorization.getPurchaseAuth());
        this.inventoryAuth = String.valueOf(authorization.getInventoryAuth());
        this.empProfile = employees.getEmpProfile();
        this.token = token;


    }
}
