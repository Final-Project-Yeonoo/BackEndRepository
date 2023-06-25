package com.ynfinal.finalproject.manual.dto.response;

import com.ynfinal.finalproject.manual.entity.Estimate;
import com.ynfinal.finalproject.manual.entity.EstimateOrderType;
import com.ynfinal.finalproject.manual.entity.EstimatePayment;
import lombok.*;

import javax.persistence.Column;
import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EstimateResponseDTO {
    private Long estimateCode;
    private Date estimateDate;
    private EstimateOrderType estimateOrderType;
    private EstimatePayment estimatePayment;
    private String estimateEtc;
    private Date projectRegDate;
    private Date projectUpdateDate;
    private String empId;
    private String empName;
    private Long projectCode;
    private String projectName;
    private Long trCompCode;
    private String trCompName;

    public EstimateResponseDTO(Estimate estimate) {
        this.estimateCode = estimate.getEstimateCode();
        this.estimateDate = estimate.getEstimateDate();
        this.estimateOrderType = estimate.getEstimateOrderType();
        this.estimatePayment = estimate.getEstimatePayment();
        this.estimateEtc = estimate.getEstimateEtc();
        this.projectRegDate = estimate.getProjectRegDate();
        this.projectUpdateDate = estimate.getProjectUpdateDate();
        this.empId = estimate.getEmployees().getEmpId();
        this.empName = estimate.getEmployees().getEmpName();
        this.projectCode = estimate.getProject().getProjectCode();
        this.projectName = estimate.getProject().getProjectName();
        this.trCompCode = estimate.getTradeCompany().getTrCompCode();
        this.trCompName = estimate.getTradeCompany().getTrCompName();
    }
}