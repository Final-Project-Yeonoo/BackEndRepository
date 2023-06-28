package com.ynfinal.finalproject;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HealthCheckController {
@GetMapping("/health-check")
    public ResponseEntity<?> healthCheck() {
    log.info("server is running!! ");
    return  ResponseEntity.ok()
            .body("server is ok!");
}
}
