package com.ynfinal.finalproject.organization.company.api;


import com.ynfinal.finalproject.organization.company.dto.request.TradeCompanyRequestDTO;
import com.ynfinal.finalproject.organization.company.dto.response.TradeCompanyResponseDTO;
import com.ynfinal.finalproject.organization.company.entity.Company;
import com.ynfinal.finalproject.organization.company.entity.TradeCompany;
import com.ynfinal.finalproject.organization.company.service.TradeCompanyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/ynfinal/trcomp")
//@CrossOrigin("*")
public class TradeCompanyController {

    private final TradeCompanyService tradeCompanyService;

    @GetMapping
    public ResponseEntity<?> handleTrcompGetRequest(){
        List<TradeCompanyResponseDTO> all = tradeCompanyService.findAll();
        log.info("/ynfinal/comp GET!!");
        for (TradeCompanyResponseDTO tradeCompany : all) {
            log.info("tradecompnay {}", tradeCompany);
        }

//        return null;
        return ResponseEntity.ok(all);
    }

    @PostMapping
    public ResponseEntity<?> handleTrCompPostRequest(@Validated @RequestBody List<TradeCompanyRequestDTO> tradeCompanyRequestDTO){
        List<TradeCompanyResponseDTO> tradeCompanyResponseDTOS = tradeCompanyService.insertTradeCompany(tradeCompanyRequestDTO);
        return ResponseEntity.ok(tradeCompanyResponseDTOS);
    }
//    @PutMapping
//
//    @DeleteMapping
}


