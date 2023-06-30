package com.ynfinal.finalproject.manual.dto.request;


import com.ynfinal.finalproject.manual.entity.Estimate;
import com.ynfinal.finalproject.manual.entity.EstimateOrderType;
import com.ynfinal.finalproject.manual.entity.EstimatePayment;
import com.ynfinal.finalproject.manual.entity.Project;
import com.ynfinal.finalproject.organization.company.entity.TradeCompany;
import com.ynfinal.finalproject.organization.user.entity.Employees;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EstimateRequestDTO {
    private Long estimateCode;
    private Date estimateDate;
    @Enumerated(EnumType.STRING)
    private EstimateOrderType estimateOrderType;
    @Enumerated(EnumType.STRING)
    private EstimatePayment estimatePayment;
    private String estimateEtc;
    private Date projectRegDate;
    private Date projectUpdateDate;
    private Long empNo;
    private String empId;
    private Long projectCode;
    private Long trCompCode;

    public Estimate toEntity() {
        Estimate estimate = new Estimate();
        estimate.setEstimateCode(this.estimateCode);
        estimate.setEstimateDate(this.estimateDate);
        estimate.setEstimateOrderType(this.estimateOrderType);
        estimate.setEstimatePayment(this.estimatePayment);
        estimate.setEstimateEtc(this.estimateEtc);
        estimate.setProjectRegDate(this.projectRegDate);
        estimate.setProjectUpdateDate(this.projectUpdateDate);
        estimate.setEmployees(Employees.builder().empId(empId).build());
        estimate.setProject(Project.builder().projectCode(projectCode).build());
        estimate.setTradeCompany(TradeCompany.builder().trCompCode(trCompCode).build());
        return estimate;
    }

}