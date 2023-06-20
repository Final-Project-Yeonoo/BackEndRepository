package com.ynfinal.finalproject.organization.user.service;


import com.ynfinal.finalproject.organization.user.dto.response.DepartmentResponseDTO;
import com.ynfinal.finalproject.organization.user.repository.DepartmentRepository;
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
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public List<DepartmentResponseDTO> findAll() {
        List<DepartmentResponseDTO> departmentResponseDTOList = departmentRepository.findAll().stream().map(
                department -> DepartmentResponseDTO.builder()
                        .deptName(department.getDeptName())
                        .build()
        ).collect(Collectors.toList());

        return departmentResponseDTOList;

    }
}
