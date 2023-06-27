package com.ynfinal.finalproject.inventory.products.service;

import com.ynfinal.finalproject.inventory.products.dto.request.RawProductInsertRequestDTO;
import com.ynfinal.finalproject.inventory.products.dto.request.RawProductModifyRequestDTO;
import com.ynfinal.finalproject.inventory.products.dto.response.RawProductListResponseDTO;
import com.ynfinal.finalproject.inventory.products.entity.RawProduct;
import com.ynfinal.finalproject.inventory.products.repository.RawProductRepository;
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
@Transactional
public class RawProductService {

    private final RawProductRepository rawRepository;

    // 원자제 전체 리스트 조회하기
    @Transactional(readOnly = true)
    public List<RawProductListResponseDTO> rawProductList() {
        return rawRepository.findAll().stream()
                .map(RawProductListResponseDTO::new)
                .collect(Collectors.toList());
    }

    // 원자제 등록하기
    public List<RawProductListResponseDTO> addRawProducts(
            final RawProductInsertRequestDTO dto
    ) {
        log.info("-----{}", dto);

        RawProduct rawProduct = dto.toEntity();
        log.info("{}", rawProduct);

        rawRepository.save(rawProduct);

        log.info("새로운 원자제가 등록되었습니다. {}", rawProduct.getRawName());

        return rawProductList();
    }

    // 원자재 수정하기
    public List<RawProductListResponseDTO> modifyRawProducts(RawProductModifyRequestDTO requestDTO) {

        log.info("{}", requestDTO);

        // 수정 전 데이터 조회
        Long target = requestDTO.getRawCode();
        System.out.println(target);

        Optional<RawProduct> foundRawItem = rawRepository.findById(target);

        System.out.println("\n\n");
        System.out.println("foundRawItem = " + foundRawItem);

        foundRawItem.ifPresent(entity -> {

            // 기본값을 유지하기 위한 코드
            long rawCode = entity.getRawCode();
            int rawCount = entity.getRawCount();
            int rawPrice = entity.getRawPrice();
            String rawName = entity.getRawName();
            LocalDateTime rawRegDate = entity.getRawRegDate();

            // dto에서 받아온 값
            String modifiedRawName = requestDTO.getRawName();
            int modifiedRawCount = requestDTO.getRawCount();
            int modifiedRawPrice = requestDTO.getRawPrice();

            // dto에 값이 있을때만 update한다
            if(modifiedRawCount > 0){
                rawCount = modifiedRawCount;
            }
            if(modifiedRawPrice > 0){
                rawPrice = modifiedRawPrice;
            }
            if(modifiedRawName != null){
                rawName = modifiedRawName;
            }

            RawProduct save = RawProduct.builder()
                    .rawCode(rawCode)
                    .rawName(rawName)
                    .rawPrice(rawPrice)
                    .rawCount(rawCount)
                    .rawRegDate(rawRegDate)
                    .rawRegUpdate(LocalDateTime.now())
                    .build();
            rawRepository.save(save);

            System.out.println("수정 항목!  = " + save);
        });

        return rawProductList();

    }


    // 원자제 삭제하기
    public List<RawProductListResponseDTO> deleteRawProduct(Long rawCode) {

        rawRepository.deleteById(rawCode);
        
        return rawProductList();
    }
}
