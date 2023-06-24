package com.ynfinal.finalproject.organization.user.dto.response;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.ynfinal.finalproject.util.Check;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;

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
    private String empPassword;
    private String empExtension;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime empHiredDate;
    private String empPhone;
    private String empAddress;
    private boolean empValidate;
    @Enumerated(EnumType.STRING)
    private Check userAuth = Check.N;
    @Enumerated(EnumType.STRING)
    private Check infoAuth = Check.N;

    @Enumerated(EnumType.STRING)
    private Check salesAuth = Check.N;
    @Enumerated(EnumType.STRING)
    private Check purchaseAuth = Check.N;
    @Enumerated(EnumType.STRING)
    private Check inventoryAuth = Check.N;
    @Enumerated(EnumType.STRING)
    private Check productAuth = Check.N;



}
