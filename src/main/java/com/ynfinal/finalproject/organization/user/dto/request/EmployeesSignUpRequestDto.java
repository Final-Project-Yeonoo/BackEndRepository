package com.ynfinal.finalproject.organization.user.dto.request;


import com.ynfinal.finalproject.organization.user.entity.Authorization;
import com.ynfinal.finalproject.organization.user.entity.Department;
import com.ynfinal.finalproject.organization.user.entity.Employees;
import com.ynfinal.finalproject.organization.user.entity.Position;
import com.ynfinal.finalproject.util.Check;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;


@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeesSignUpRequestDto {

    @NotBlank(message = "이름을 입력해주세요")
    private String empName;
    @NotBlank(message = "아이디를 입력해주세요")
    private String empId;
    @NotBlank(message = "비밀번호를 입력해주세요")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,30}$",
            message = "비밀번호는 8~30 자리이면서 1개 이상의 알파벳, 숫자, 특수문자를 포함해야합니다.")
    private String empPassword;
    private Long deptCode;
    private Long posCode;
    private String empPhone;
    private String empExtension;
    private LocalDateTime empHiredDate;
    private boolean empValidate;

    @Enumerated(EnumType.STRING)
    private Check userAuth;
    @Enumerated(EnumType.STRING)
    private Check infoAuth;
    @Enumerated(EnumType.STRING)
    private Check purchaseAuth;
    @Enumerated(EnumType.STRING)
    private Check inventoryAuth;


    public Employees toEntity(){
        return Employees.builder()
                .empName(empName)
                .empId(empId)
                .empPassword(empPassword)
                .department(Department.builder().deptCode(deptCode).build())
                .position(Position.builder().posCode(posCode).build())
                .empPhone(empPhone)
                .empExtension(empExtension)
                .empHiredDate(empHiredDate)
                .empValidate(empValidate)
                .build();
    }



}
