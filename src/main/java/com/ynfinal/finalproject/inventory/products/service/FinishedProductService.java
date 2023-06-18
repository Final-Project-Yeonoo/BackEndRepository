package com.ynfinal.finalproject.inventory.products.service;

import com.ynfinal.finalproject.inventory.products.dto.request.FinishedProductInsertRequestDTO;
import com.ynfinal.finalproject.inventory.products.dto.request.FinishedProductModifyRequestDTO;
import com.ynfinal.finalproject.inventory.products.dto.response.FinishedProductListResponseDTO;
import com.ynfinal.finalproject.inventory.products.entity.FinishedProduct;
import com.ynfinal.finalproject.inventory.products.repository.FinishedProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class FinishedProductService {

    private final FinishedProductRepository finishedRepository;


    // 완제품 전체 조회하기
    public List<FinishedProductListResponseDTO> finishedProductsList() {

        return finishedRepository.findAll()
                .stream()
                .map(FinishedProductListResponseDTO::new)
                .collect(Collectors.toList());

    }

    // 완제품 등록하기
    public boolean insertFinishedProduct(final FinishedProductInsertRequestDTO requestDTO) {

        log.info("finishedInsert service : {}", requestDTO);
        FinishedProduct finishedProduct = requestDTO.toEntity();
        FinishedProduct save = finishedRepository.save(finishedProduct);

        return true;

    }

    public List<FinishedProductListResponseDTO> modifyFinishedProducts(FinishedProductModifyRequestDTO requestDTO) {

        log.info("{}", requestDTO);

        // 수정 전 데이터 조회
        Long target = requestDTO.getFinishedCode();
        System.out.println(target);

        Optional<FinishedProduct> finishedProduct = finishedRepository.findById(target);


        finishedProduct.ifPresent(entity -> {

            // 기본값을 유지하기 위한 코드
            long finishedCode = entity.getFinishedCode();
            int finishedCount = entity.getFinishedCount();
            int finishedPrice = entity.getFinishedPrice();
            String finishedName = entity.getFinishedName();
            LocalDateTime finishedRegDate = entity.getFinishedRegDate();

            // dto에서 받아온 값
            String modifiedFinishedName = requestDTO.getFinishedName();
            int modifiedFinishedCount = requestDTO.getFinishedCount();
            int modifiedFinishedPrice = requestDTO.getFinishedPrice();

            // dto에 값이 있을때만 update한다
            if (modifiedFinishedCount > 0) {
                finishedCount = modifiedFinishedCount;
            }
            if (modifiedFinishedPrice > 0) {
                finishedPrice = modifiedFinishedPrice;
            }
            if (modifiedFinishedName != null) {
                finishedName = modifiedFinishedName;
            }

            FinishedProduct save = FinishedProduct.builder()
                    .finishedCode(finishedCode)
                    .finishedName(finishedName)
                    .finishedPrice(finishedPrice)
                    .finishedCount(finishedCount)
                    .finishedRegDate(finishedRegDate)
                    .finishedRegUpdate(LocalDateTime.now())
                    .build();
            finishedRepository.save(save);

            System.out.println("수정 항목!  = " + save);


        });

        return finishedProductsList();
    }

    // 완제품 삭제하기
    public void deleteFinishedProduct(Long finishedCode) {

        log.info("delete service {}", finishedCode);
        finishedRepository.deleteById(finishedCode);
    }
}
