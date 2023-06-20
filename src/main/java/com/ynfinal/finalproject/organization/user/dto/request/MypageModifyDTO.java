package com.ynfinal.finalproject.organization.user.dto.request;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MypageModifyDTO {
    @NotBlank
    private String empId;
    @NotBlank
    private String empPassword;
    @NotBlank
    private String empPhone;
    @NotBlank
    private String empAddress;
}
