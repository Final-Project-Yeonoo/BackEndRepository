package com.ynfinal.finalproject.organization.user.auth;

import lombok.*;

@Getter
@ToString @EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TokenEmployeeInfo {

    private String empId;
    private String empName;

}
