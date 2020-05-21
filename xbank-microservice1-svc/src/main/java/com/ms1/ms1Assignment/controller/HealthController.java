package com.ms1.ms1Assignment.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {
        private static Logger LOGGER = LoggerFactory.getLogger(HealthController.class);

        @GetMapping("/health")
        public ResponseEntity<Void> health() {
                LOGGER.info("Microservice1 service health is" + HttpStatus.OK);
                return new ResponseEntity<>(HttpStatus.OK);
        }
        
}
