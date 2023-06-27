package com.ynfinal.finalproject.manual.api;

import com.ynfinal.finalproject.manual.dto.request.JobOrderRequestDTO;
import com.ynfinal.finalproject.manual.dto.request.OrderDetailCreateDTO;
import com.ynfinal.finalproject.manual.dto.response.JobOrderResponseDTO;
import com.ynfinal.finalproject.manual.dto.response.OrderDetailResponseDTO;
import com.ynfinal.finalproject.manual.service.JobOrderService;
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
@RequestMapping("/ynfinal/joborder")
public class JobOrderController {
    private final JobOrderService jobOrderService;

    @GetMapping
    public ResponseEntity<List<JobOrderResponseDTO>> getJobOrder() {
        List<JobOrderResponseDTO> list = jobOrderService.findAllJobOrder();
        return ResponseEntity.ok(list);
    }



    @PostMapping
    public ResponseEntity<String> createJobOrder(@Valid @RequestBody List<JobOrderRequestDTO> requestDTOs) {
        log.info("{}----------", requestDTOs);
        jobOrderService.createJobOrder(requestDTOs);
        return ResponseEntity.ok("JobOrder created successfully.");
    }

    @DeleteMapping
    public ResponseEntity<String> deleteJobOrder(@Valid @RequestBody List<Long> ids) {
        jobOrderService.deleteJobOrder(ids);
        return ResponseEntity.ok("JobOrder deleted successfully.");
    }
}
