package com.ynfinal.finalproject.organization.user.dto.request;


import lombok.*;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeesLoginRequestDto {
    private String empId;
    private String empPassword;
    private Boolean isAutoLogin;
}
