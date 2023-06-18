package com.ynfinal.finalproject.organization.user.dto.response;

import com.ynfinal.finalproject.organization.user.entity.Employees;
import lombok.*;


// 로그인이 성공 후 클라이언트에게 전송할 데이터객체
@Getter
@ToString @EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginResponseDTO {
    private String empId;
    private String empName;

    private String token; // 인증 토큰
//    private String message; // 로그인 메시지
    public LoginResponseDTO(Employees employees, String token) {
        this.empId = employees.getEmpId();
        this.empName = employees.getEmpName();
        this.token = token;

    }
}
