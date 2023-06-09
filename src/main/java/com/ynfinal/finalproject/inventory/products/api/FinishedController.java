package com.ynfinal.finalproject.inventory.products.api;

import com.ynfinal.finalproject.inventory.products.dto.request.FinishedProductInsertRequestDTO;
import com.ynfinal.finalproject.inventory.products.dto.request.FinishedProductModifyRequestDTO;
import com.ynfinal.finalproject.inventory.products.dto.response.FinishedProductListResponseDTO;
import com.ynfinal.finalproject.inventory.products.service.FinishedProductService;
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
@RequestMapping("/ynfinal/finisheditem")
public class FinishedController {

    private final FinishedProductService finishedService;

    // 완제품 전체 조회
    @GetMapping
    public ResponseEntity<?> finisedProductList(){

        log.info("/ynfinal/finisheditem : GET!! ");
        List<FinishedProductListResponseDTO> finishedList = finishedService.finishedProductsList();

        return ResponseEntity.ok().body(finishedList);
    }

    // 완제품 등록하기
    @PostMapping
    public ResponseEntity<?> addFinishedProduct(
            @Valid @RequestBody FinishedProductInsertRequestDTO requestDTO
    ){

        log.info("/ynfinal/finisheditem : POST!! ");
        List<FinishedProductListResponseDTO> finishedList = finishedService.insertFinishedProduct(requestDTO);

        return ResponseEntity.ok().body(finishedList);
    }

    // 완제품 수정하기
    @RequestMapping(method = {RequestMethod.PATCH, RequestMethod.PUT})
    public ResponseEntity<?> updateFinishedProducts(
            @Valid @RequestBody FinishedProductModifyRequestDTO requestDTO
    ){

        log.info("/ynfinal/finisheditem : PATCH!! {} ", requestDTO);

        List<FinishedProductListResponseDTO> finishedProducts = finishedService.modifyFinishedProducts(requestDTO);

        return ResponseEntity.ok().body(finishedProducts);
    }

    // 완제품 삭제하기
    @DeleteMapping("/{finishedCode}")
    public ResponseEntity<?> deleteFinishedProduct(
            @PathVariable Long finishedCode
    ){
        log.info("/ynfinal/finisheditem/{finishedCode} : DELETE");

        List<FinishedProductListResponseDTO> finishedList = finishedService.deleteFinishedProduct(finishedCode);


        return ResponseEntity.ok().body(finishedList);
    }
}
