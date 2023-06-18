package com.ynfinal.finalproject.inventory.storeHouse.api;

import com.ynfinal.finalproject.inventory.products.dto.request.FinishedProductInsertRequestDTO;
import com.ynfinal.finalproject.inventory.storeHouse.dto.request.StoreHouseInsertDTO;
import com.ynfinal.finalproject.inventory.storeHouse.dto.response.StoreHouseListResponseDTO;
import com.ynfinal.finalproject.inventory.storeHouse.service.StoreHouseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Controller
@Slf4j
@RequiredArgsConstructor
@Validated
@RequestMapping("/ynfinal/storehouse")
public class StoreHouseController {

    private final StoreHouseService storeHouseService;

    // 창고리스트 조회
    @GetMapping
    public ResponseEntity<?> storeHouseList(){

        log.info("/ynfinal/storehouse");

        List<StoreHouseListResponseDTO> storehouseList = storeHouseService.storehouseList();

        return ResponseEntity.ok().body(storehouseList);
    }

    // 창고 등록하기
    @PostMapping
    public ResponseEntity<?> addStoreHouseProduct(
            @Valid @RequestBody StoreHouseInsertDTO requestDTO
    ){

        log.info("/ynfinal/finisheditem : POST!! ");
        storeHouseService.insertStoreHouse(requestDTO);

        return ResponseEntity.ok("완제품이 정상적으로 등록되었습니다.");
    }



    // 창고삭제하기
    @DeleteMapping("/{storehouseCode}")
    public ResponseEntity<?> deleteStoreHouse(
            @PathVariable Long storehouseCode
    ){

        log.info("/ynfinal/storehouse/{storehouseCode} : DELETE");

        storeHouseService.deleteStoreHouse(storehouseCode);
        return ResponseEntity.ok().body("창고를 정상적으로 삭제했습니다.");
    }

}
