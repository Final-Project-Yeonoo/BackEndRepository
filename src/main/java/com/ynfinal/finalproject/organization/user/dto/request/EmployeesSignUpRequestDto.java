package com.ynfinal.finalproject.organization.user.dto.request;


import com.ynfinal.finalproject.organization.user.entity.Employees;
import lombok.*;

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


    @Email
    @NotBlank(message = "아이디를 입력해주세요")
    private String empId;

    @NotBlank(message = "비밀번호를 입력해주세요")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,30}$",
            message = "비밀번호는 8~30 자리이면서 1개 이상의 알파벳, 숫자, 특수문자를 포함해야합니다.")
    private String empPassword;
    @NotBlank(message = "이름을 입력해주세요")
    private String empName;
    private LocalDateTime empHiredDate;
    private String empPhone;
    private String empExtension;
    private String empProfile;



    public Employees toEntity(){
        return Employees.builder()
                .empId(empId)
                .empPassword(empPassword)
                .empName(empName)
                .empHiredDate(empHiredDate)
                .empPhone(empPhone)
                .empExtension(empExtension)
                .empProfile(empProfile)
                .build();
    }

}
