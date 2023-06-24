package com.ynfinal.finalproject.manual.dto.request;


import com.ynfinal.finalproject.manual.entity.Project;
import com.ynfinal.finalproject.organization.user.entity.Employees;
import lombok.*;

import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ProjectPostDTO {
    private Long projectCode;
    private String projectName;
    private Date projectDate;
    private String empId;
    private String empName;
    private String projectEtc;

    public Project toEntity(){
        return Project.builder()
                .projectCode(this.projectCode)
                .projectName(this.projectName)
                .projectDate(this.projectDate)
                .employees(Employees.builder().empId(this.empId).build())
                .projectEtc(this.projectEtc)
                .build();
    }



}
