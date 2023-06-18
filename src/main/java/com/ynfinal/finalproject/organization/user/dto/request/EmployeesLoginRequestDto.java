package com.ynfinal.finalproject.organization.user.dto.request;


import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeesLoginRequestDto {
    @NotBlank
    @Email
    private String empId;
    @NotBlank
    private String empPassword;
    private Boolean isAutoLogin;
}
