package com.ynfinal.finalproject.inventory.products.service;

import com.ynfinal.finalproject.inventory.products.dto.request.HalfProductInsertRequestDTO;
import com.ynfinal.finalproject.inventory.products.dto.request.HalfProductModifyRequestDTO;
import com.ynfinal.finalproject.inventory.products.dto.response.HalfProductListResponseDTO;
import com.ynfinal.finalproject.inventory.products.entity.HalfProduct;
import com.ynfinal.finalproject.inventory.products.entity.RawProduct;
import com.ynfinal.finalproject.inventory.products.repository.HalfProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class HalfProductService {

    private final HalfProductRepository halfRepository;

    // 반제품 전체 조회
    @Transactional(readOnly = true)
    public List<HalfProductListResponseDTO> halfProductsList() {

        return halfRepository.findAll().stream()
                .map(HalfProductListResponseDTO::new)
                .collect(Collectors.toList());

    }

    // 반제품 추가하기
    public List<HalfProductListResponseDTO> addHalfProducts(
            final HalfProductInsertRequestDTO requestDTO) {

        log.info("=== service dto {} ", requestDTO);
        HalfProduct halfProduct = requestDTO.toEntity();
        halfRepository.save(halfProduct);

        log.info("반제품이 정상적으로 등록되었습니다. {}", halfProduct.getHalfName());

        return halfProductsList();

    }

    public List<HalfProductListResponseDTO> modifyHalfProducts(HalfProductModifyRequestDTO requestDTO) {

        log.info("modifyHalfProduct service {}", requestDTO);

        Long target = requestDTO.getHalfCode();

        Optional<HalfProduct> halfProduct = halfRepository.findById(target);

        halfProduct.ifPresent(entity -> {

            // 기본값을 유지하기 위한 코드
            long halfCode = entity.getHalfCode();
            int halfCount = entity.getHalfCount();
            int halfPrice = entity.getHalfPrice();
            String halfName = entity.getHalfName();
            LocalDateTime halfRegDate = entity.getHalfRegDate();

            // dto에서 받아온 값
            String modifiedHalfName = requestDTO.getHalfName();
            int modifiedHalfCount = requestDTO.getHalfCount();
            int modifiedHalfPrice = requestDTO.getHalfPrice();

            // dto에 값이 있을때만 update한다
            if (modifiedHalfCount > 0) {
                halfCount = modifiedHalfCount;
            }
            if (modifiedHalfPrice > 0) {
                halfPrice = modifiedHalfPrice;
            }
            if (modifiedHalfName != null) {
                halfName = modifiedHalfName;
            }

            HalfProduct save = HalfProduct.builder()
                    .halfCode(halfCode)
                    .halfName(halfName)
                    .halfPrice(halfPrice)
                    .halfCount(halfCount)
                    .halfRegDate(halfRegDate)
                    .halfRegUpdate(LocalDateTime.now())
                    .build();
            halfRepository.save(save);

            System.out.println("수정 항목!  = " + save);


        });
        return halfProductsList();
    }

    // 원자제 삭제하기
    public List<HalfProductListResponseDTO> deleteHalfProduct(Long halfCode) {

        halfRepository.deleteById(halfCode);

        return halfProductsList();
    }
}
