package com.ynfinal.finalproject.organization.company.service;

import com.ynfinal.finalproject.organization.company.dto.response.TradeCompanyResponseDTO;
import com.ynfinal.finalproject.organization.company.entity.TradeCompany;
import com.ynfinal.finalproject.organization.company.repository.TradeCompanyRepository;
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
public class TradeCompanyService {

    private final TradeCompanyRepository tradeCompanyRepository;

    public List<TradeCompanyResponseDTO> findAll() {
        List<TradeCompanyResponseDTO> tradeCompanyResponseDTOS = tradeCompanyRepository.findAll()
                .stream()
                .map(tradeCompany -> {
                    String storehouseName = tradeCompany.getStoreHouse() != null ? tradeCompany.getStoreHouse().getStorehouseName() : null;
                    String empName = tradeCompany.getEmployees() != null ? tradeCompany.getEmployees().getEmpName() : null;

                    return TradeCompanyResponseDTO.builder()
                            .trCompCode(tradeCompany.getTrCompCode())
                            .trCompRegNo(tradeCompany.getTrCompRegNo())
                            .trCompCeo(tradeCompany.getTrCompCeo())
                            .trCompPhone(tradeCompany.getTrCompPhone())
                            .trBuy(tradeCompany.getTrBuy())
                            .trSell(tradeCompany.getTrSell())
                            .trStartDate(tradeCompany.getTrStartDate())
                            .trEndDate(tradeCompany.getTrEndDate())
                            .trRegDate(tradeCompany.getTrRegDate())
                            .trUpdateDate(tradeCompany.getTrUpdateDate())
                            .trAddr(tradeCompany.getTrAddr())
                            .storehouseName(storehouseName)
                            .empName(empName)
                            .build();
                })
                .collect(Collectors.toList());

        return tradeCompanyResponseDTOS;
    }







}
