package com.ynfinal.finalproject.organization.company.dto.request;

import com.ynfinal.finalproject.organization.company.entity.Company;
import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyPostRequestDTO {
    @NotBlank
    private Long compCode;
    @NotBlank
    private String compName;
    @NotBlank
    private String compRegNo;
    @NotBlank
    private String compCeo;
    private String compPhone;

    public Company toEntity(){
        return Company.builder()
                .compCode(compCode)
                .compName(compName)
                .compRegNo(compRegNo)
                .compCeo(compCeo)
                .compPhone(compPhone)
                .build();
    }
}
