package com.ynfinal.finalproject.manual.dto.response;


import com.ynfinal.finalproject.inventory.storeHouse.entity.StoreHouse;
import com.ynfinal.finalproject.manual.entity.Project;
import com.ynfinal.finalproject.organization.user.entity.Employees;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProjectResponseDTO {
    private Long projectCode;
    private String projectName;
    private Date projectDate;
    private String empId;
    private String empName;
    private String projectEtc;

    public ProjectResponseDTO(Project project) {
        this.projectCode = project.getProjectCode();
        this.projectName = project.getProjectName();
        this.projectDate = project.getProjectDate();
        this.empId = project.getEmployees().getEmpId();
        this.empName = project.getEmployees().getEmpName();
        this.projectEtc = project.getProjectEtc();
    }
}
