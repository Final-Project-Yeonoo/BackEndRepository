package com.ynfinal.finalproject.organization.user.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ynfinal.finalproject.organization.user.entity.Employees;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeesSignUpResponseDTO {

    private String empId;
    private String empName;


    public EmployeesSignUpResponseDTO(Employees employees) {
        this.empId = employees.getEmpId();
        this.empName = employees.getEmpName();

    }
}
