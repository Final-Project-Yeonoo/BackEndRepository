package com.ynfinal.finalproject.inventory.storeHouse.api;

import com.ynfinal.finalproject.inventory.storeHouse.dto.response.ItemOrderWithDetailResponseDTO;
import com.ynfinal.finalproject.inventory.storeHouse.entity.ItemOrderDetail;
import com.ynfinal.finalproject.inventory.storeHouse.repository.ItemOrderDetailRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/ynfinal/orderdetail")
public class InputOrderDetailController {

    private final ItemOrderDetailRepository detailRepository;

    @GetMapping
    public List<ItemOrderWithDetailResponseDTO> itemOrderWithDetails(){

        detailRepository.findAll();


        return itemOrderWithDetails();
    }




}
