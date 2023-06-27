package com.ynfinal.finalproject.manual.api;

import com.ynfinal.finalproject.manual.dto.request.OrderDetailCreateDTO;
import com.ynfinal.finalproject.manual.dto.request.ReturnedRequestDTO;
import com.ynfinal.finalproject.manual.dto.response.OrderDetailResponseDTO;
import com.ynfinal.finalproject.manual.dto.response.ReturnedResponseDTO;
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
@RequestMapping("/ynfinal/return")
public class ReturnedController {
    private final ReturnedService returnedService;

    @GetMapping
    public ResponseEntity<List<ReturnedResponseDTO>> getReturned() {
        List<ReturnedResponseDTO> list = returnedService.findAllReturned();
        return ResponseEntity.ok(list);
    }



    @PostMapping
    public ResponseEntity<String> createReturned(@Valid @RequestBody List<ReturnedRequestDTO> requestDTOs) {
        log.info("{}----------", requestDTOs);
        returnedService.createReturned(requestDTOs);
        return ResponseEntity.ok("Returned created successfully.");
    }

    @DeleteMapping
    public ResponseEntity<String> deleteReturned(@Valid @RequestBody List<Long> ids) {
        returnedService.deleteReturned(ids);
        return ResponseEntity.ok("Returned deleted successfully.");
    }
}
