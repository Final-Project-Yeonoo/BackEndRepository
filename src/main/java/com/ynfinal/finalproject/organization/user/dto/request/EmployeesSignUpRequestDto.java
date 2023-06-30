package com.ynfinal.finalproject.organization.user.dto.request;


import com.ynfinal.finalproject.organization.company.entity.Company;
import com.ynfinal.finalproject.organization.user.entity.Authorization;
import com.ynfinal.finalproject.organization.user.entity.Department;
import com.ynfinal.finalproject.organization.user.entity.Employees;
import com.ynfinal.finalproject.organization.user.entity.Position;
import com.ynfinal.finalproject.util.Check;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
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
public class EmployeesSignUpRequestDto {

    @NotBlank(message = "이름을 입력해주세요")
    private String empName;
    @NotBlank(message = "아이디를 입력해주세요")
    private String empId;
    @NotBlank(message = "비밀번호를 입력해주세요")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,30}$",
            message = "비밀번호는 8~30 자리이면서 1개 이상의 알파벳, 숫자, 특수문자를 포함해야합니다.")
    private String empPassword;
    @NotNull(message = "부서코드를 입력해주세요")
    private Long deptCode;
    @NotNull(message = "직급코드를 입력해주세요")
    private Long posCode;
    @NotBlank(message = "휴대폰번호를 입력해주세요")
    private String empPhone;
    @NotBlank(message = "내선번호를 입력해주세요")
    private String empExtension;
    @NotNull(message = "입사일을 입력해주세요")
//    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date empHiredDate;
    private boolean empValidate = false;

    @Builder.Default
    private Check userAuth = Check.Y;
    @Builder.Default
    private Check infoAuth = Check.Y;
    @Builder.Default
    private Check purchaseAuth= Check.Y;
    @Builder.Default
    private Check inventoryAuth= Check.Y;
    @Builder.Default
    private Check salesAuth= Check.Y;
    @Builder.Default
    private Check productAuth = Check.Y;
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
//                .userAuth(userAuth)
//                .infoAuth(infoAuth)
//                .purchaseAuth(purchaseAuth)
//                .inventoryAuth(inventoryAuth)
                //TODO 사원 관리를 등록하는 사람의 회사 코드를 가져오기
                .company(Company.builder().compCode(1L).build())
                .build();
    }


    public Authorization toAuthEntity(){
        return Authorization.builder()
                .userAuth(userAuth)
                .infoAuth(infoAuth)
                .purchaseAuth(purchaseAuth)
                .inventoryAuth(inventoryAuth)
                .salesAuth(salesAuth)
                .productAuth(productAuth)
                .build();
    }




}
