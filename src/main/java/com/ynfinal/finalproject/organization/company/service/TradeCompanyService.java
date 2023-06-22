package com.ynfinal.finalproject.organization.company.service;

import com.ynfinal.finalproject.inventory.storeHouse.dto.response.StoreHouseListResponseDTO;
import com.ynfinal.finalproject.inventory.storeHouse.entity.StoreHouse;
import com.ynfinal.finalproject.inventory.storeHouse.entity.StoreHouseType;
import com.ynfinal.finalproject.inventory.storeHouse.repository.StoreHouseRepository;
import com.ynfinal.finalproject.organization.company.dto.request.TradeCompanyRequestDTO;
import com.ynfinal.finalproject.organization.company.dto.response.TradeCompanyResponseDTO;
import com.ynfinal.finalproject.organization.company.entity.TradeCompany;
import com.ynfinal.finalproject.organization.company.repository.TradeCompanyRepository;
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
public class TradeCompanyService {

    private final TradeCompanyRepository tradeCompanyRepository;
    private final StoreHouseRepository storeHouseRepository;
    public List<TradeCompanyResponseDTO> findAll() {
        List<TradeCompanyResponseDTO> tradeCompanyResponseDTOS = tradeCompanyRepository.findAll()
                .stream()
                .map(tradeCompany -> {
                    String storehouseName = tradeCompany.getStoreHouse() != null ? tradeCompany.getStoreHouse().getStorehouseName() : null;
                    String empName = tradeCompany.getEmployees() != null ? tradeCompany.getEmployees().getEmpName() : null;

                    return TradeCompanyResponseDTO.builder()
                            .trCompName(tradeCompany.getTrCompName())
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
                            .trEtc(tradeCompany.getTrEtc())
                            .empName(empName)
                            .build();
                })
                .collect(Collectors.toList());

        return tradeCompanyResponseDTOS;
    }


    public List<TradeCompanyResponseDTO> insertTradeCompany(List<TradeCompanyRequestDTO> tradeCompanyRequestDTOList) {
        List<TradeCompanyResponseDTO> list = new ArrayList<>();
        for (TradeCompanyRequestDTO tradeCompanyRequestDTO : tradeCompanyRequestDTOList) {


            StoreHouseListResponseDTO storeHouseListResponseDTO =
                    storeHouseRepository.findByStorehouseName(tradeCompanyRequestDTO.getStorehouseName()).orElseThrow();

            TradeCompany tradeCompany = TradeCompany.builder()
                    .trCompCode(tradeCompanyRequestDTO.getTrCompCode())
                    .trCompName(tradeCompanyRequestDTO.getTrCompName())
                    .trCompPhone(tradeCompanyRequestDTO.getTrCompPhone())
                    .trAddr(tradeCompanyRequestDTO.getTrAddr())
                    .trEtc(tradeCompanyRequestDTO.getTrEtc())
                    .trCompCode(tradeCompanyRequestDTO.getTrCompCode())
                    .trStartDate(tradeCompanyRequestDTO.getTrStartDate())
                    .trBuy(tradeCompanyRequestDTO.getTrBuy())
                    .trSell(tradeCompanyRequestDTO.getTrSell())
                    .storeHouse(StoreHouse.builder()
                            .storehouseCode(storeHouseListResponseDTO.getStorehouseCode())
                            .storehouseAddr(storeHouseListResponseDTO.getStorehouseAddr())
                            .storehouseType(StoreHouseType.valueOf(storeHouseListResponseDTO.getStorehouseType()))
                            .storehouseStartDate(storeHouseListResponseDTO.getStorehouseStartDate())
                            .storehouseName(storeHouseListResponseDTO.getStorehouseName())
                            .build())
                    .build();

            TradeCompany save = tradeCompanyRepository.save(tradeCompany);

            list.add(TradeCompanyResponseDTO.builder()
                    .trCompName(save.getTrCompName())
                    .trCompPhone(save.getTrCompPhone())
                    .trAddr(save.getTrAddr())
                    .trEtc(save.getTrEtc())
                    .trCompCode(save.getTrCompCode())
                    .trStartDate(save.getTrStartDate())
                    .trBuy(save.getTrBuy())
                    .trSell(save.getTrSell())
                    .storehouseName(save.getStoreHouse().getStorehouseName())
                    .build());
        }
        return list;
    }
}
