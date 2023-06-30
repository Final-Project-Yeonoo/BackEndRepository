package com.ynfinal.finalproject.manual.service;

import com.ynfinal.finalproject.manual.dto.request.DeliveryRequestDTO;
import com.ynfinal.finalproject.manual.dto.request.OrderDetailCreateDTO;
import com.ynfinal.finalproject.manual.dto.response.DeliveryResponseDTO;
import com.ynfinal.finalproject.manual.dto.response.OrderManageResponseDTO;
import com.ynfinal.finalproject.manual.entity.Delivery;
import com.ynfinal.finalproject.manual.entity.OrderDetail;
import com.ynfinal.finalproject.manual.repository.DeliveryRepository;
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
public class DeliveryService {
    private final DeliveryRepository deliveryRepository;
    private final EmployeesRepository employeesRepository;
    public List<DeliveryResponseDTO> findAllDeliveryDetails() {
        return deliveryRepository.findAll().stream()
                .map(DeliveryResponseDTO::new)
                .collect(Collectors.toList());
    }

    public void createDeliveryDetails(List<DeliveryRequestDTO> requestDTOs) {
        for (DeliveryRequestDTO requestDTO : requestDTOs) {
            Delivery delivery =requestDTO.toEntity();
            Employees employees = employeesRepository.findByEmpId(requestDTO.getEmpId()).orElseThrow();

            delivery.setEmployees(Employees.builder().empNo(employees.getEmpNo()).build());

            deliveryRepository.save(delivery);
        }
    }

    public void deleteDeliveryDetails(List<Long> ids) {
        for (Long id : ids) {
            deliveryRepository.deleteById(id);
        }
    }
}
