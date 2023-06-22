package com.ynfinal.finalproject.organization.user.dto.response;


import lombok.*;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DepartmentResponseDTO {
    private Long deptCode;
    private String deptName;
}
