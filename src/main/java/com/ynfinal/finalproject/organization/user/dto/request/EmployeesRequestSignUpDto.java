package com.ynfinal.finalproject.organization.user.dto.request;


import com.ynfinal.finalproject.organization.user.entity.Employees;
import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;


@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeesRequestSignUpDto {

    private String empId;
    private String empPassword;
    private String empName;
    private LocalDateTime empHiredDate;
    private String empPhone;
    private String empExtension;
    private String empProfile;
    private boolean empValidate;

}
