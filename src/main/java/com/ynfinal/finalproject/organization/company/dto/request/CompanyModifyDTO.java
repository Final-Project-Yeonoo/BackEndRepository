package com.ynfinal.finalproject.organization.company.dto.request;

import lombok.*;

import javax.persistence.Column;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyModifyDTO {
    private Long compCode;
    private String compName;
    private String compRegNo;
    private String compCeo;
    private String compPhone;
}
