package com.ynfinal.finalproject.manual.service;

import com.ynfinal.finalproject.manual.dto.request.OrderManageCreateDTO;
import com.ynfinal.finalproject.manual.dto.response.OrderManageResponseDTO;
import com.ynfinal.finalproject.manual.entity.Estimate;
import com.ynfinal.finalproject.manual.entity.OrderManage;
import com.ynfinal.finalproject.manual.entity.Project;
import com.ynfinal.finalproject.manual.repository.EstimateRepository;
import com.ynfinal.finalproject.manual.repository.OrderManageRepository;
import com.ynfinal.finalproject.manual.repository.ProjectRepository;
import com.ynfinal.finalproject.organization.company.entity.TradeCompany;
import com.ynfinal.finalproject.organization.user.entity.Employees;
import com.ynfinal.finalproject.organization.user.repository.EmployeesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class OrderManageService {
    private final OrderManageRepository orderManageRepository;
    private final EmployeesRepository employeesRepository;
    private final ProjectRepository projectRepository;
    private final EstimateRepository estimateRepository;
    public List<OrderManageResponseDTO> findAllOrderManages() {
        return orderManageRepository.findAll().stream()
                .map(OrderManageResponseDTO::new)
                .collect(Collectors.toList());
    }

    public void createOrderManages(List<OrderManageCreateDTO> requestDTOs) {
        Date currentDate = new Date();

        for (OrderManageCreateDTO requestDTO : requestDTOs) {
            OrderManage orderManage = requestDTO.toEntity();
            Employees employees = employeesRepository.findByEmpNo(1L);
            Estimate estimate = estimateRepository.findById(1L).orElseThrow();
            Project project = projectRepository.findByProjectCode(1L);
            orderManage.setEstimate(estimate);
            orderManage.setEmployees(employees);
            orderManage.setProject(project);
            orderManageRepository.save(orderManage);
        }
    }

    public void deleteOrderManages(List<Long> orderManageIds) {
        for (Long orderManageId : orderManageIds) {
            orderManageRepository.deleteById(orderManageId);
        }
    }
}
