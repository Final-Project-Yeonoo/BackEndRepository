package com.ynfinal.finalproject.manual.api;

import com.ynfinal.finalproject.manual.dto.request.OrderDetailCreateDTO;
import com.ynfinal.finalproject.manual.dto.response.OrderDetailResponseDTO;
import com.ynfinal.finalproject.manual.service.OrderDetailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/ynfinal/orders/detail")
@Validated
public class OrderDetailController {
    private final OrderDetailService orderDetailService;

    @GetMapping
    public ResponseEntity<List<OrderDetailResponseDTO>> getOrderDetails() {
        List<OrderDetailResponseDTO> list = orderDetailService.findAllOrderDetails();
        return ResponseEntity.ok(list);
    }



    @PostMapping
    public ResponseEntity<String> createOrderDetails(@Valid @RequestBody List<OrderDetailCreateDTO> requestDTOs) {
        log.info("{}----------", requestDTOs);
        orderDetailService.createOrderDetails(requestDTOs);
        return ResponseEntity.ok("Order details created successfully.");
    }

    @DeleteMapping
    public ResponseEntity<String> deleteOrderDetails(@Valid @RequestBody List<Long> orderDetailIds) {
        orderDetailService.deleteOrderDetails(orderDetailIds);
        return ResponseEntity.ok("Order details deleted successfully.");
    }
}
