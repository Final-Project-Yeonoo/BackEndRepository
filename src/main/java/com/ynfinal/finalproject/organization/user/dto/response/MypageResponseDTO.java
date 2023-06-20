package com.ynfinal.finalproject.organization.user.dto.response;


import lombok.*;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MypageResponseDTO {
    private Long empNo;
    private String empId;
    private String deptName;
    private String posName;
    private String empExtension;
    private String empPhone;
    private String empAddress;
}
