package com.ynfinal.finalproject.manual.service;

import com.ynfinal.finalproject.manual.dto.request.JobOrderRequestDTO;
import com.ynfinal.finalproject.manual.dto.request.OrderDetailCreateDTO;
import com.ynfinal.finalproject.manual.dto.response.JobOrderResponseDTO;
import com.ynfinal.finalproject.manual.dto.response.OrderManageResponseDTO;
import com.ynfinal.finalproject.manual.entity.JobOrder;
import com.ynfinal.finalproject.manual.entity.OrderDetail;
import com.ynfinal.finalproject.manual.repository.JobOrderRepository;
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
public class JobOrderService {
    private final JobOrderRepository jobOrderRepository;

    public List<JobOrderResponseDTO> findAllJobOrder() {
        return jobOrderRepository.findAll().stream()
                .map(JobOrderResponseDTO::new)
                .collect(Collectors.toList());
    }

    public void createJobOrder(List<JobOrderRequestDTO> requestDTOs) {
        for (JobOrderRequestDTO requestDTO : requestDTOs) {
            JobOrder jobOrder =requestDTO.toEntity();
            jobOrderRepository.save(jobOrder);
        }
    }

    public void deleteJobOrder(List<Long> ids) {
        for (Long id : ids) {
            jobOrderRepository.deleteById(id);
        }
    }
}
