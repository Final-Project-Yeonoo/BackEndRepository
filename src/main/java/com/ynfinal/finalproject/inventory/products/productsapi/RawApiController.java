package com.ynfinal.finalproject.inventory.products.productsapi;

import com.ynfinal.finalproject.inventory.products.dto.request.InsertRawItemRequestDTO;
import com.ynfinal.finalproject.inventory.products.dto.response.RawProductListResponseDTO;
import com.ynfinal.finalproject.inventory.products.service.RawProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/ynfinal/rawitem")
public class RawApiController {

    private RawProductService rawProductService;

    // 모든 원자제 리스트
    @GetMapping
    public ResponseEntity<?> rawItemList(){

        log.info("/ynfinal/raitem : GET!! ");

        List<RawProductListResponseDTO> listResponseDTO = rawProductService.rawProductList();

        return ResponseEntity.ok().body(listResponseDTO);
    }

    // 원자제 등록하기
    @PostMapping
    public ResponseEntity<?> addRawProducts(
            @Validated @RequestBody
            InsertRawItemRequestDTO dto
    ){

        log.info("/ynfinal/raitem : POST!! ");



        boolean b = rawProductService.addRawProducts(dto);

        return ResponseEntity.ok().body(b);
    }

}
