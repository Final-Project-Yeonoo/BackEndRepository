package com.ynfinal.finalproject.manual.service;

import com.ynfinal.finalproject.manual.dto.request.EstimateDeleteDTO;
import com.ynfinal.finalproject.manual.dto.request.EstimateRequestDTO;
import com.ynfinal.finalproject.manual.dto.response.EstimateResponseDTO;
import com.ynfinal.finalproject.manual.entity.Estimate;
import com.ynfinal.finalproject.manual.entity.Project;
import com.ynfinal.finalproject.manual.repository.EstimateRepository;
import com.ynfinal.finalproject.manual.repository.ProjectRepository;
import com.ynfinal.finalproject.organization.company.entity.TradeCompany;
import com.ynfinal.finalproject.organization.company.repository.TradeCompanyRepository;
import com.ynfinal.finalproject.organization.user.entity.Employees;
import com.ynfinal.finalproject.organization.user.repository.EmployeesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class EstimateService {

    private final EstimateRepository estimateRepository;
    private final EmployeesRepository employeesRepository;
    private final TradeCompanyRepository tradeCompanyRepository;
    private final ProjectRepository projectRepository;


    public List<EstimateResponseDTO> getAllEstimates() {
        return estimateRepository.findAll().stream()
                .map(EstimateResponseDTO::new)
                .collect(Collectors.toList());
    }

    public void insertEstimates(List<EstimateRequestDTO> requestDTO) {
        for (EstimateRequestDTO estimateRequestDTO : requestDTO) {
            Estimate estimate = estimateRequestDTO.toEntity();
            Employees employees = employeesRepository.findByEmpNo(1L);
            TradeCompany tradeCompany = tradeCompanyRepository.findById(1L).orElseThrow();
            Project project = projectRepository.findByProjectCode(1L);
            // Set the employees to the estimate (assuming EMP_NO is used for mapping)
            estimate.setEmployees(employees);
            estimate.setTradeCompany(tradeCompany);
            estimate.setProject(project);
            estimateRepository.save(estimate);
        }
    }

    public void deleteEstimates(List<EstimateDeleteDTO> requestDTO) {
        requestDTO.forEach(d -> {
            if (d.getEstimateCode() != null) {
                estimateRepository.deleteById(d.getEstimateCode());
            }
        });
    }
}
