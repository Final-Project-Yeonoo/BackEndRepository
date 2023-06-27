package com.ynfinal.finalproject.inventory.storeHouse.api;

import com.ynfinal.finalproject.inventory.storeHouse.dto.request.ItemOrderInputRequestDTO;
import com.ynfinal.finalproject.inventory.storeHouse.dto.response.ItemOrderListResponseDTO;
import com.ynfinal.finalproject.inventory.storeHouse.entity.ItemOrder;
import com.ynfinal.finalproject.inventory.storeHouse.service.ItemOrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/ynfinal/order")
public class ItemOrderController {


    private final ItemOrderService itemOrderService;

    //모든 발주서 확인하기
    @GetMapping
    public ResponseEntity<?> itemOrderList(){
        log.info("/ynfinal/order : GET!! ");
        List<ItemOrderListResponseDTO> itemOrderList = itemOrderService.itemOrderList();
        return ResponseEntity.ok().body(itemOrderList);

    }

    @PostMapping
    public ResponseEntity<?> itemOrderInput(
            @RequestBody ItemOrderInputRequestDTO requestDTO
    ){

        log.info("/ynfinal/order : POST !! ");
        boolean b = itemOrderService.addItemOrder(requestDTO);


        return ResponseEntity.ok().body(b);
    }


    @DeleteMapping("/{itemOrderCode}")
    public ResponseEntity<?> deleteItemOrder(
            @PathVariable Long itemOrderCode
    ){

        itemOrderService.deleteItemOrder(itemOrderCode);
        return ResponseEntity.ok().body("삭제되었습니다.");
    }




}
