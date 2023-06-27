package com.ynfinal.finalproject.manual.service;

import com.ynfinal.finalproject.manual.dto.request.OrderDetailCreateDTO;
import com.ynfinal.finalproject.manual.dto.request.ReturnDetailRequestDTO;
import com.ynfinal.finalproject.manual.dto.response.OrderManageResponseDTO;
import com.ynfinal.finalproject.manual.dto.response.ReturnDetailResponseDTO;
import com.ynfinal.finalproject.manual.entity.OrderDetail;
import com.ynfinal.finalproject.manual.entity.ReturnDetail;
import com.ynfinal.finalproject.manual.repository.ReturnDetailRepository;
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
public class ReturnDetailService {
    private final ReturnDetailRepository returnDetailRepository;

    public List<ReturnDetailResponseDTO> findAllReturnDetail() {
        return returnDetailRepository.findAll().stream()
                .map(ReturnDetailResponseDTO::new)
                .collect(Collectors.toList());
    }

    public void createReturnDetail(List<ReturnDetailRequestDTO> requestDTOs) {
        for (ReturnDetailRequestDTO requestDTO : requestDTOs) {
            ReturnDetail detail =requestDTO.toEntity();
            returnDetailRepository.save(detail);
        }
    }

    public void deleteReturnDetail(List<Long> ids) {
        for (Long id : ids) {
            returnDetailRepository.deleteById(id);
        }
    }
}
