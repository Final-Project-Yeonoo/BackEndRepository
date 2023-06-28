package com.ynfinal.finalproject.organization.user.service;


import com.ynfinal.finalproject.organization.user.dto.response.PositionResponseDTO;
import com.ynfinal.finalproject.organization.user.repository.PositionRepository;
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
public class PositionService {
    private final PositionRepository positionRepository;
    public List<PositionResponseDTO> findAll() {
        List<PositionResponseDTO> positionResponseDTOList = positionRepository.findAll().stream().map(
                position -> PositionResponseDTO.builder()
                        .posCode(position.getPosCode())
                        .posName(position.getPosName())
                        .build()
        ).collect(Collectors.toList());

        return positionResponseDTOList;
    }
}
