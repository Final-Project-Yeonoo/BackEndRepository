package com.ynfinal.finalproject.manual.api;

import com.ynfinal.finalproject.manual.dto.request.OrderDetailCreateDTO;
import com.ynfinal.finalproject.manual.dto.request.ReturnDetailRequestDTO;
import com.ynfinal.finalproject.manual.dto.response.OrderDetailResponseDTO;
import com.ynfinal.finalproject.manual.dto.response.ReturnDetailResponseDTO;
import com.ynfinal.finalproject.manual.service.ReturnDetailService;
import com.ynfinal.finalproject.manual.service.ReturnedService;
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
@RequestMapping("/ynfinal/return/detail")
public class ReturnDetailController {
    private final ReturnDetailService returnDetailService;

    @GetMapping
    public ResponseEntity<List<ReturnDetailResponseDTO>> getReturnDetail() {
        List<ReturnDetailResponseDTO> list = returnDetailService.findAllReturnDetail();
        return ResponseEntity.ok(list);
    }



    @PostMapping
    public ResponseEntity<String> createReturnDetail(@Valid @RequestBody List<ReturnDetailRequestDTO> requestDTOs) {
        log.info("{}----------", requestDTOs);
        returnDetailService.createReturnDetail(requestDTOs);
        return ResponseEntity.ok("ReturnDetail created successfully.");
    }

    @DeleteMapping
    public ResponseEntity<String> deleteReturnDetail(@Valid @RequestBody List<Long> ids) {
        returnDetailService.deleteReturnDetail(ids);
        return ResponseEntity.ok("ReturnDetail deleted successfully.");
    }
}
