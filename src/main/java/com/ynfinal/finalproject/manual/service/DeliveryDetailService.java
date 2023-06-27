package com.ynfinal.finalproject.manual.service;

import com.ynfinal.finalproject.manual.dto.request.DeliveryDetailRequestDTO;
import com.ynfinal.finalproject.manual.dto.request.OrderDetailCreateDTO;
import com.ynfinal.finalproject.manual.dto.response.DeliveryDetailResponseDTO;
import com.ynfinal.finalproject.manual.dto.response.OrderManageResponseDTO;
import com.ynfinal.finalproject.manual.entity.DeliveryDetail;
import com.ynfinal.finalproject.manual.entity.OrderDetail;
import com.ynfinal.finalproject.manual.repository.DeliveryDetailRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class DeliveryDetailService {
    private final DeliveryDetailRepository deliveryDetailRepository;

    public List<DeliveryDetailResponseDTO> findAllDeliveryDetails() {
        return deliveryDetailRepository.findAll().stream()
                .map(DeliveryDetailResponseDTO::new)
                .collect(Collectors.toList());
    }

    public void createDeliveryDetails(List<DeliveryDetailRequestDTO> requestDTOs) {
        for (DeliveryDetailRequestDTO requestDTO : requestDTOs) {
            DeliveryDetail deliveryDetail =requestDTO.toEntity();
            deliveryDetailRepository.save(deliveryDetail);
        }

    }

    public void deleteDeliveryDetails(List<Long> ids) {
        for (Long id : ids) {
            deliveryDetailRepository.deleteById(id);
        }
    }
}
