package com.ynfinal.finalproject.manual.api;

import com.ynfinal.finalproject.manual.dto.request.OrderDetailCreateDTO;
import com.ynfinal.finalproject.manual.dto.request.PerformanceRequestDTO;
import com.ynfinal.finalproject.manual.dto.response.OrderDetailResponseDTO;
import com.ynfinal.finalproject.manual.dto.response.PerformanceResponseDTO;
import com.ynfinal.finalproject.manual.service.PerformanceService;
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
@RequestMapping("/ynfinal/performance")
public class PerformanceController {
    private final PerformanceService performanceService;

    @GetMapping
    public ResponseEntity<List<PerformanceResponseDTO>> getPerformance() {
        List<PerformanceResponseDTO> list = performanceService.findAllPerformance();
        return ResponseEntity.ok(list);
    }



    @PostMapping
    public ResponseEntity<String> createPerformance(@Valid @RequestBody List<PerformanceRequestDTO> requestDTOs) {
        log.info("{}----------", requestDTOs);
        performanceService.createPerformance(requestDTOs);
        return ResponseEntity.ok("performanceService created successfully.");
    }

    @DeleteMapping
    public ResponseEntity<String> deletePerformance(@Valid @RequestBody List<Long> ids) {
        log.info("{}----------------", ids);
        performanceService.deletePerformance(ids);
        return ResponseEntity.ok("performanceService deleted successfully.");
    }
}
