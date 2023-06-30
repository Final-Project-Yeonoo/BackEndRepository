package com.ynfinal.finalproject.organization.user.dto.response;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.ynfinal.finalproject.util.Check;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeesResponseDTO {
    private Long empNo;
    private String empName;
    private String empId;
    private String deptName;
    private String posName;
    private String empPassword;
    private String empExtension;
//    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date empHiredDate;
    private String empPhone;
    private String empAddress;
    private boolean empValidate;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private Check userAuth = Check.N;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private Check infoAuth = Check.N;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private Check salesAuth = Check.N;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private Check purchaseAuth = Check.N;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private Check inventoryAuth = Check.N;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private Check productAuth = Check.N;



}
