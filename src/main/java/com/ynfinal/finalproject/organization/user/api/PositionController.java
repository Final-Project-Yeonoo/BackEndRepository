package com.ynfinal.finalproject.organization.user.api;

import com.ynfinal.finalproject.organization.user.dto.response.PositionResponseDTO;
import com.ynfinal.finalproject.organization.user.service.PositionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/ynfinal/position")
@RequiredArgsConstructor
public class PositionController {
    //    @GetMapping
    //    @PostMapping
    //    @PutMapping
    //    @DeleteMapping
    private final PositionService positionService;

    @GetMapping
    public ResponseEntity<?> handlePositionResponseGetRequest() {
        List<PositionResponseDTO> positionResponseDTOList =  positionService.findAll();

        return ResponseEntity.ok(positionResponseDTOList);
    }
 }
