package com.ynfinal.finalproject.manual.api;

import com.ynfinal.finalproject.manual.dto.request.DeliveryDetailRequestDTO;
import com.ynfinal.finalproject.manual.dto.request.OrderDetailCreateDTO;
import com.ynfinal.finalproject.manual.dto.response.DeliveryDetailResponseDTO;
import com.ynfinal.finalproject.manual.dto.response.OrderDetailResponseDTO;
import com.ynfinal.finalproject.manual.service.DeliveryDetailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@Slf4j
@Validated
@RequestMapping("/ynfinal/delivery/detail")
public class DeliveryDetailController {
    private final DeliveryDetailService deliveryDetailService;

    @GetMapping
    public ResponseEntity<List<DeliveryDetailResponseDTO>> getDeliveryDetail() {
        List<DeliveryDetailResponseDTO> list = deliveryDetailService.findAllDeliveryDetails();
        return ResponseEntity.ok(list);
    }



    @PostMapping
    public ResponseEntity<String> createDeliveryDetail(@Valid @RequestBody List<DeliveryDetailRequestDTO> requestDTOs) {
        log.info("{}----------", requestDTOs);
        deliveryDetailService.createDeliveryDetails(requestDTOs);
        return ResponseEntity.ok("deliveryDetail created successfully.");
    }

    @DeleteMapping
    public ResponseEntity<String> deleteDeliveryDetail(@Valid @RequestBody List<Long> ids) {
        deliveryDetailService.deleteDeliveryDetails(ids);
        return ResponseEntity.ok("deliveryDetail deleted successfully.");
    }
}
