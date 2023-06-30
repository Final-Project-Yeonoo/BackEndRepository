package com.ynfinal.finalproject.organization.user.auth;

import lombok.*;

@Getter
@ToString @EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TokenEmployeeInfo {
//    private Long empNo;
    private String empId;
    private String empName;

}
