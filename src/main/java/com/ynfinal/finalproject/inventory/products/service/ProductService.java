package com.ynfinal.finalproject.inventory.products.service;

import com.ynfinal.finalproject.inventory.products.dto.response.RawProductListResponseDTO;
import com.ynfinal.finalproject.inventory.products.repository.RawProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {

    private final RawProductRepository rawRepository;

    public RawProductListResponseDTO totalRawProduct(){

        return null;
    }



}
