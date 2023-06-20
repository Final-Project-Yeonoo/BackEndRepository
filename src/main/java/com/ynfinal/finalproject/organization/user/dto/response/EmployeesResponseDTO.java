package com.ynfinal.finalproject.organization.user.dto.response;


import lombok.*;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeesResponseDTO {
    private String empName;
    private String empId;
    private String deptName;
    private String posName;

}
