package com.ynfinal.finalproject.manual.service;

import com.ynfinal.finalproject.manual.dto.request.OrderDetailCreateDTO;
import com.ynfinal.finalproject.manual.dto.request.PerformanceRequestDTO;
import com.ynfinal.finalproject.manual.dto.response.OrderManageResponseDTO;
import com.ynfinal.finalproject.manual.dto.response.PerformanceResponseDTO;
import com.ynfinal.finalproject.manual.entity.OrderDetail;
import com.ynfinal.finalproject.manual.entity.Performance;
import com.ynfinal.finalproject.manual.repository.PerformanceRepository;
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
public class PerformanceService {
    private final PerformanceRepository performanceRepository;
    public List<PerformanceResponseDTO> findAllPerformance() {
        return performanceRepository.findAll().stream()
                .map(PerformanceResponseDTO::new)
                .collect(Collectors.toList());
    }

    public void createPerformance(List<PerformanceRequestDTO> requestDTOs) {
        for (PerformanceRequestDTO requestDTO : requestDTOs) {
            Performance performance =requestDTO.toEntity();
            performanceRepository.save(performance);
        }
    }

    public void deletePerformance(List<Long> ids) {
        for (Long id : ids) {
            performanceRepository.deleteById(id);
        }
    }
}
