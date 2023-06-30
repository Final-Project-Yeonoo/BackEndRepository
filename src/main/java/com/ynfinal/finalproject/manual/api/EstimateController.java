package com.ynfinal.finalproject.manual.api;


import com.ynfinal.finalproject.manual.dto.request.EstimateDeleteDTO;
import com.ynfinal.finalproject.manual.dto.request.EstimateRequestDTO;
import com.ynfinal.finalproject.manual.dto.response.EstimateResponseDTO;
import com.ynfinal.finalproject.manual.service.EstimateService;
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
@RequestMapping("/ynfinal/estimate")
public class EstimateController {
    private final EstimateService estimateService;


    @GetMapping
    public ResponseEntity<List<EstimateResponseDTO>> getEstimates() {
        List<EstimateResponseDTO> estimates = estimateService.getAllEstimates();
        return ResponseEntity.ok(estimates);
    }

    @PostMapping
    public ResponseEntity<String> createEstimates(@Valid @RequestBody List<EstimateRequestDTO> requestDTO) {
        log.info("{}--------------------", requestDTO);
        estimateService.insertEstimates(requestDTO);
        return ResponseEntity.ok("Estimates created successfully.");
    }

    @DeleteMapping
    public ResponseEntity<String> deleteEstimates(@Valid @RequestBody List<EstimateDeleteDTO> requestDTO) {
        estimateService.deleteEstimates(requestDTO);
        return ResponseEntity.ok("Estimates deleted successfully.");
    }

}
