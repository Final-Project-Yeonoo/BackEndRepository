package com.ynfinal.finalproject.organization.company.dto.request;

import lombok.*;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyModifyRequestDTO {
    private Long compCode;
    private String compName;
    private String compRegNo;
    private String compCeo;
    private String compPhone;
}
