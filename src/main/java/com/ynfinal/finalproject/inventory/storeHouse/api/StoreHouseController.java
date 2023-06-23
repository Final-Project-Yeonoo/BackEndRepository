package com.ynfinal.finalproject.inventory.storeHouse.api;

import com.ynfinal.finalproject.inventory.products.dto.request.FinishedProductInsertRequestDTO;
import com.ynfinal.finalproject.inventory.storeHouse.dto.request.StoreHouseDeleteRequestDTO;
import com.ynfinal.finalproject.inventory.storeHouse.dto.request.StoreHouseInsertDTO;
import com.ynfinal.finalproject.inventory.storeHouse.dto.request.StoreHouseModifyRequestDTO;
import com.ynfinal.finalproject.inventory.storeHouse.dto.request.StoreHousefilterDTO;
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


@RestController
@Slf4j
@RequiredArgsConstructor
@Validated
@RequestMapping("/ynfinal/store")
public class StoreHouseController {

    private final StoreHouseService storeHouseService;

    // 창고리스트 조회
    @GetMapping
    public ResponseEntity<?> storeHouseList(){

        log.info("/ynfinal/store : GET!!");

        List<StoreHouseListResponseDTO> storehouseList = storeHouseService.storehouseList();

        return ResponseEntity.ok().body(storehouseList);
    }



//    @GetMapping("/filter")
//    public ResponseEntity<?> storeHouseFilterList(@RequestParam(required = false) String storehouseName,
//                                                  @RequestParam(required = false) String storehouseAddr,
//                                                  @RequestParam(required = false) String storehouseType,
//                                                  @RequestParam(required = false) String storehouseEtc){
//        StoreHousefilterDTO dto = new StoreHousefilterDTO();
//        dto.setStorehouseName(storehouseName);
//        dto.setStorehouseAddr(storehouseAddr);
//        dto.setStorehouseType(storehouseType);
//        dto.setStorehouseEtc(storehouseEtc);
//
//        List<StoreHouseListResponseDTO> storehouseList = storeHouseService.storehousefilterList(dto);
//        return ResponseEntity.ok().body(storehouseList);
//    }
    // 창고 등록하기
    @PostMapping
    public ResponseEntity<?> addStoreHouseProduct(
            @Valid @RequestBody List<StoreHouseInsertDTO> requestDTO
    ){

        log.info("/ynfinal/store : POST!! ");
        storeHouseService.insertStoreHouse(requestDTO);

        return ResponseEntity.ok("완제품이 정상적으로 등록되었습니다.");
    }

    // 창고 정보 수정하기
    @PutMapping
    public ResponseEntity<?> modifyStoreHouse(
            StoreHouseModifyRequestDTO requestDTO
    ){

        log.info("/ynfinal/store : FETCH !!");
        List<StoreHouseListResponseDTO> storehouseModifyList = storeHouseService.storehouseModify(requestDTO);

        return ResponseEntity.ok().body(storehouseModifyList);

    }


    // 창고삭제하기
    @DeleteMapping("/{storehouseCode}")
    public ResponseEntity<?> deleteStoreHouse(
            @PathVariable Long storehouseCode
    ){

        log.info("/ynfinal/store/{storehouseCode} : DELETE");

        storeHouseService.deleteStoreHouse(storehouseCode);
        return ResponseEntity.ok().body("창고를 정상적으로 삭제했습니다.");
    }


    @DeleteMapping
    public ResponseEntity<?> deleteListStoreHouse(
            @RequestBody @Validated List<StoreHouseDeleteRequestDTO> storeHouseDeleteRequestDTOS
    ){

        log.info("/ynfinal/store : DELETE");

        storeHouseService.deleteListStoreHouse(storeHouseDeleteRequestDTOS);
        return ResponseEntity.ok().body("창고를 정상적으로 삭제했습니다.");
    }

}
