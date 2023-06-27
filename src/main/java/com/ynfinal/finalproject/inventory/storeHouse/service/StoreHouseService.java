package com.ynfinal.finalproject.inventory.storeHouse.service;

import com.ynfinal.finalproject.inventory.storeHouse.dto.request.StoreHouseDeleteRequestDTO;
import com.ynfinal.finalproject.inventory.storeHouse.dto.request.StoreHouseInsertDTO;
import com.ynfinal.finalproject.inventory.storeHouse.dto.request.StoreHouseModifyRequestDTO;
import com.ynfinal.finalproject.inventory.storeHouse.dto.request.StoreHousefilterDTO;
import com.ynfinal.finalproject.inventory.storeHouse.dto.response.StoreHouseListResponseDTO;
import com.ynfinal.finalproject.inventory.storeHouse.entity.StoreHouse;
import com.ynfinal.finalproject.inventory.storeHouse.entity.StoreHouseType;
import com.ynfinal.finalproject.inventory.storeHouse.repository.StoreHouseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class StoreHouseService {

    private final StoreHouseRepository repository;

    // 창고 전체 조회하기
    public List<StoreHouseListResponseDTO> storehouseList() {

        log.info("storehouse list service");
        return repository.findAll().stream()
                .map(StoreHouseListResponseDTO::new)
                .collect(Collectors.toList());

    }

    public boolean insertStoreHouse(List<StoreHouseInsertDTO> requestDTOList) {

        log.info("insert dto");
        for (StoreHouseInsertDTO requestDTO : requestDTOList) {
            StoreHouse storeHouse = requestDTO.toEntity();

            log.info("{} ---------- ",storeHouse);

            repository.save(storeHouse);
            log.info("새로운 창고가 등록되었습니다. {}", storeHouse.getStorehouseName());
        }

        return true;
    }


    // 창고 정보 수정
    public List<StoreHouseListResponseDTO> storehouseModify(StoreHouseModifyRequestDTO requestDTO) {


        Long target = requestDTO.getStorehouseCode();

        Optional<StoreHouse> storeHouse = repository.findById(target);

        storeHouse.ifPresent(entity -> {

            // 기존 정보
            Long storehouseCode = entity.getStorehouseCode();
            String storehouseName = entity.getStorehouseName();
            String storehouseAddr = entity.getStorehouseAddr();
            StoreHouseType storeHouseType = entity.getStorehouseType();

            // 정보에서 수정 할 정보
            String newStorehouseName = requestDTO.getStorehouseName();
            String newStorehouseAddr = requestDTO.getStorehouseAddr();
            String newStorehouseType = String.valueOf(requestDTO.getStorehouseType());

            if (newStorehouseName != null) {
                storehouseName = newStorehouseName;
            }
            if (newStorehouseAddr != null) {
                storehouseAddr = newStorehouseAddr;
            }
            if (!newStorehouseType.isEmpty()) {
                storeHouseType = StoreHouseType.valueOf(newStorehouseType);
            }


            StoreHouse newStorehouse = StoreHouse.builder()
                    .storehouseCode(storehouseCode)
                    .storehouseName(storehouseName)
                    .storehouseAddr(storehouseAddr)
                    .storehouseType(storeHouseType)
                    .build();

            repository.save(newStorehouse);

        });

        return storehouseList();

    }


    // 창고 삭제하기
    public void deleteStoreHouse(Long storehouseCode) {

        log.info("delete service");
        repository.deleteById(storehouseCode);

    }

    public void deleteListStoreHouse(List<StoreHouseDeleteRequestDTO> storeHouseDeleteRequestDTOS) {

        storeHouseDeleteRequestDTOS.stream().forEach( d -> {
                    if(d.getStorehouseCode()==null) return;
                    repository.deleteById(d.getStorehouseCode());
                }
        );


    }

//    public List<StoreHouseListResponseDTO> storehousefilterList(StoreHousefilterDTO dto) {
//        return repository.findFilteredStorehouses(dto.getStorehouseName(), dto.getStorehouseAddr(), dto.getStorehouseType(), dto.getStorehouseEtc()).stream()
//                .map(StoreHouseListResponseDTO::new)
//                .collect(Collectors.toList());
//    }
}
