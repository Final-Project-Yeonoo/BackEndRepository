package com.ynfinal.finalproject.inventory.storeHouse.service;

import com.ynfinal.finalproject.inventory.products.entity.RawProduct;
import com.ynfinal.finalproject.inventory.storeHouse.dto.request.StoreHouseInsertDTO;
import com.ynfinal.finalproject.inventory.storeHouse.dto.response.StoreHouseListResponseDTO;
import com.ynfinal.finalproject.inventory.storeHouse.entity.StoreHouse;
import com.ynfinal.finalproject.inventory.storeHouse.repository.StoreHouseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class StoreHouseService {

    private final StoreHouseRepository repository;

    // 창고 전체 조회하기
    public List<StoreHouseListResponseDTO> storehouseList() {

        log.info("storehouse list service");
        return repository.findAll().stream()
                .map(StoreHouseListResponseDTO::new)
                .collect(Collectors.toList());

    }

    public boolean insertStoreHouse(StoreHouseInsertDTO requestDTO) {

        log.info("insert dto");
        StoreHouse storeHouse = requestDTO.toEntity();

        repository.save(storeHouse);
        log.info("새로운 창고가 등록되었습니다. {}", storeHouse.getStorehouseName());

        return true;
    }



    // 창고 삭제하기
    public void deleteStoreHouse(Long storehouseCode) {

        log.info("delete service");
        repository.deleteById(storehouseCode);

    }

}
