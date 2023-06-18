package com.ynfinal.finalproject.inventory.products.productsapi;

import com.ynfinal.finalproject.inventory.products.dto.request.HalfProductInsertRequestDTO;
import com.ynfinal.finalproject.inventory.products.dto.request.HalfProductModifyRequestDTO;
import com.ynfinal.finalproject.inventory.products.dto.response.HalfProductListResponseDTO;
import com.ynfinal.finalproject.inventory.products.service.HalfProductService;
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
@RequestMapping("/ynfinal/halfitem")
@Validated
public class HalfController {

    private final HalfProductService halfService;

    // 모든 반제품 리스트
    @GetMapping
    public ResponseEntity<?> halfItemList(){

        log.info("/ynfinal/halfitem : GET!!");
        List<HalfProductListResponseDTO> halfProducts = halfService.halfProductsList();

        return ResponseEntity.ok().body(halfProducts);
    }

    // 반제품 등록하기
    @PostMapping
    public ResponseEntity<?> addHalfProducts(
            @Valid @RequestBody
            HalfProductInsertRequestDTO requestDTO
    ){

        log.info("/ynfinal/halfitem : POST !! {} ", requestDTO);

        log.info("{} ", requestDTO.getHalfName());

        halfService.addHalfProducts(requestDTO);

        return ResponseEntity.ok().body("상품이 등록되었습니다.");

    }

    // 반제품 수정하기
    @RequestMapping(method = {RequestMethod.PATCH, RequestMethod.PUT})
    public ResponseEntity<?> updateHalfProducts(
            @Valid @RequestBody HalfProductModifyRequestDTO requestDTO

    ){

        log.info("/ynfinal/halfitem : PATCH !! {} ", requestDTO);

        List<HalfProductListResponseDTO> halfProducts = halfService.modifyHalfProducts(requestDTO);

        return ResponseEntity.ok().body(halfProducts);
    }

    @DeleteMapping("/{halfCode}")
    public ResponseEntity<?> deleteHalfProduct(
            @PathVariable Long halfCode
    ){

        log.info("/ynfinal/halfitem/{} : DELETE 요청~", halfCode);

        halfService.deleteHalfProduct(halfCode);

        return ResponseEntity.ok("반제품이 정상적으로 삭제 되었습니다.");
    }


}
