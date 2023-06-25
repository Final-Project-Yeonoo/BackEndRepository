package com.ynfinal.finalproject.manual.service;

import com.ynfinal.finalproject.inventory.products.entity.FinishedProduct;
import com.ynfinal.finalproject.inventory.products.repository.FinishedProductRepository;
import com.ynfinal.finalproject.manual.dto.request.OrderDetailCreateDTO;
import com.ynfinal.finalproject.manual.dto.response.EstimateResponseDTO;
import com.ynfinal.finalproject.manual.dto.response.OrderDetailResponseDTO;
import com.ynfinal.finalproject.manual.entity.OrderDetail;
import com.ynfinal.finalproject.manual.entity.OrderManage;
import com.ynfinal.finalproject.manual.repository.OrderDetailRepository;
import com.ynfinal.finalproject.manual.repository.OrderManageRepository;
import com.ynfinal.finalproject.organization.user.entity.Employees;
import com.ynfinal.finalproject.organization.user.repository.EmployeesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class OrderDetailService {
    private final OrderDetailRepository orderDetailRepository;
    private final FinishedProductRepository finishedProductRepository;
    private final OrderManageRepository orderManageRepository;

    public List<OrderDetailResponseDTO> findAllOrderDetails() {
       return orderDetailRepository.findAll().stream()
                .map(OrderDetailResponseDTO::new)
                .collect(Collectors.toList());
    }
    public void createOrderDetails(List<OrderDetailCreateDTO> requestDTOs) {
        for (OrderDetailCreateDTO requestDTO : requestDTOs) {
            OrderDetail orderDetail =requestDTO.toEntity();
            FinishedProduct finishedProduct = finishedProductRepository.findById(requestDTO.getFinishedCode()).orElseThrow();

            OrderManage orderManage = orderManageRepository.findById(orderDetail.getOrderDetailSeq()).orElseThrow();
            orderDetail.setFinishedProduct(finishedProduct);
            orderDetail.setOrderManage(orderManage);

            orderDetailRepository.save(orderDetail);
        }
    }
    public void deleteOrderDetails(List<Long> orderDetailIds) {
        for (Long orderDetailId : orderDetailIds) {
            orderDetailRepository.deleteById(orderDetailId);
        }
    }
}
