package com.ynfinal.finalproject.inventory.products.service;

import com.ynfinal.finalproject.inventory.products.dto.request.InsertRawItemRequestDTO;
import com.ynfinal.finalproject.inventory.products.dto.response.RawProductListResponseDTO;
import com.ynfinal.finalproject.inventory.products.entity.RawProduct;
import com.ynfinal.finalproject.inventory.products.repository.RawProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class RawProductService {

    private final RawProductRepository rawRepository;

    // 원자제 전체 리스트 조회하기
    public List<RawProductListResponseDTO> rawProductList(){

        return rawRepository.findAll().stream()
                .map(RawProductListResponseDTO::new)
                .collect(Collectors.toList());
    }

    // 원자제 등록하기
    public boolean addRawProducts(
            final InsertRawItemRequestDTO dto
    ){


        RawProduct rawProduct = dto.toEntity();
        rawRepository.save(rawProduct);
        log.info("새로운 원자제가 등록되었습니다. {}", rawProduct.getRawName());



        return true;
    }



}
