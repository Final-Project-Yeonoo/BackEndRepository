package com.ynfinal.finalproject.manual.api;

import com.ynfinal.finalproject.manual.dto.request.DeliveryRequestDTO;
import com.ynfinal.finalproject.manual.dto.request.OrderDetailCreateDTO;
import com.ynfinal.finalproject.manual.dto.response.DeliveryResponseDTO;
import com.ynfinal.finalproject.manual.dto.response.OrderDetailResponseDTO;
import com.ynfinal.finalproject.manual.service.DeliveryService;
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
@RequestMapping("/ynfinal/delivery")
public class DeliveryController {
    private final DeliveryService deliveryService;

    @GetMapping
    public ResponseEntity<List<DeliveryResponseDTO>> getDelivery() {
        List<DeliveryResponseDTO> list = deliveryService.findAllDeliveryDetails();
        return ResponseEntity.ok(list);
    }



    @PostMapping
    public ResponseEntity<String> createDelivery(@Valid @RequestBody List<DeliveryRequestDTO> requestDTOs) {
        log.info("{}----------", requestDTOs);
        deliveryService.createDeliveryDetails(requestDTOs);
        return ResponseEntity.ok("DeliveryService created successfully.");
    }

    @DeleteMapping
    public ResponseEntity<String> deleteDelivery(@Valid @RequestBody List<Long> ids) {
        deliveryService.deleteDeliveryDetails(ids);
        return ResponseEntity.ok("DeliveryService deleted successfully.");
    }

}
