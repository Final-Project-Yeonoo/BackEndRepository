package com.ynfinal.finalproject.inventory.products.api;

import com.ynfinal.finalproject.inventory.products.dto.request.RawProductInsertRequestDTO;
import com.ynfinal.finalproject.inventory.products.dto.request.RawProductModifyRequestDTO;
import com.ynfinal.finalproject.inventory.products.dto.response.RawProductListResponseDTO;
import com.ynfinal.finalproject.inventory.products.service.RawProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/ynfinal/rawitem")
@Validated
public class RawController {


    private final RawProductService rawProductService;

    // 모든 원자제 리스트
    @GetMapping
    public ResponseEntity<?> rawItemList(){

        log.info("/ynfinal/rawitem : GET!! ");

        List<RawProductListResponseDTO> listResponseDTO = rawProductService.rawProductList();

        return ResponseEntity.ok().body(listResponseDTO);

    }

    // 원자제 등록하기
    @PostMapping
    public ResponseEntity<?> addRawProducts(
            @Valid @RequestBody
            RawProductInsertRequestDTO dto
    ){

        log.info("/ynfinal/rawitem : POST!! {}", dto);
        Boolean b = rawProductService.addRawProducts(dto);

        return ResponseEntity.ok().body("원자제가 정상적으로 등록되었습니다.");
    }

    // 원자제 수정하기
    @RequestMapping(method = {RequestMethod.PATCH, RequestMethod.PUT})
    public ResponseEntity<?> updateRawProducts(
            @Valid @RequestBody RawProductModifyRequestDTO requestDTO
    ){

        log.info("/ynfinal/rawitem : PATCH!! {} ", requestDTO);

        List<RawProductListResponseDTO> rawProducts = rawProductService.modifyRawProducts(requestDTO);

        return ResponseEntity.ok().body(rawProducts);
    }


    // 원자제 하나 삭제하기
    @DeleteMapping("/{rawCode}")
    public ResponseEntity<?> deleteRawProduct(
            @PathVariable Long rawCode
    ){
        log.info("/ynfinal/rawitem/{} = DELETE 요청!",rawCode);

        rawProductService.deleteRawProduct(rawCode);

        return ResponseEntity.ok("원자제가 정상적으로 삭제 되었습니다.");

    }


}
