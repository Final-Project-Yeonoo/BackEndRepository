package com.ynfinal.finalproject.manual.service;

import com.ynfinal.finalproject.manual.dto.request.OrderDetailCreateDTO;
import com.ynfinal.finalproject.manual.dto.request.ReturnedRequestDTO;
import com.ynfinal.finalproject.manual.dto.response.ReturnedResponseDTO;
import com.ynfinal.finalproject.manual.entity.OrderDetail;
import com.ynfinal.finalproject.manual.entity.Returned;
import com.ynfinal.finalproject.manual.repository.ReturnedRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class ReturnedService {
    private final ReturnedRepository returnedRepository;
    public List<ReturnedResponseDTO> findAllReturned() {
        return returnedRepository.findAll().stream()
                .map(ReturnedResponseDTO::new)
                .collect(Collectors.toList());
    }

    public void createReturned(@Valid List<ReturnedRequestDTO> requestDTOs) {
        for (ReturnedRequestDTO requestDTO : requestDTOs) {
            Returned returned =requestDTO.toEntity();
            returnedRepository.save(returned);
        }

    }

    public void deleteReturned(List<Long> ids) {
        for (Long id : ids) {
            returnedRepository.deleteById(id);
        }
    }
}
