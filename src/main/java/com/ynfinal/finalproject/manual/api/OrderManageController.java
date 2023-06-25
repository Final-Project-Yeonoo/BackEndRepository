package com.ynfinal.finalproject.manual.api;

import com.ynfinal.finalproject.manual.dto.request.OrderManageCreateDTO;
import com.ynfinal.finalproject.manual.dto.response.OrderManageResponseDTO;
import com.ynfinal.finalproject.manual.service.OrderManageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ynfinal/orders")
@Validated
public class OrderManageController {
    private final OrderManageService orderManageService;

    @GetMapping
    public ResponseEntity<List<OrderManageResponseDTO>> getOrderManages() {
        List<OrderManageResponseDTO> list = orderManageService.findAllOrderManages();
        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<String> createOrderManages(@Valid @RequestBody List<OrderManageCreateDTO> requestDTOs) {
        orderManageService.createOrderManages(requestDTOs);
        return ResponseEntity.ok("Order manages created successfully.");
    }

    @DeleteMapping
    public ResponseEntity<String> deleteOrderManages(@Valid @RequestBody List<Long> orderManageIds) {
        orderManageService.deleteOrderManages(orderManageIds);
        return ResponseEntity.ok("Order manages deleted successfully.");
    }
}


