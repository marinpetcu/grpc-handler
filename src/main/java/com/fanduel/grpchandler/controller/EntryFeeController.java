package com.fanduel.grpchandler.controller;

import com.fanduel.grpchandler.model.EntryFeeRequest;
import com.fanduel.grpchandler.service.EntryFeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/entry-fee")
public class EntryFeeController {

    private final EntryFeeService entryFeeService;

    private final Logger logger = LoggerFactory.getLogger(EntryFeeController.class);

    public EntryFeeController(EntryFeeService entryFeeService) {
        this.entryFeeService = entryFeeService;
    }

    @PostMapping
    public void entryFee(@RequestBody EntryFeeRequest request) {
        logger.info("Received request: " + request);
        entryFeeService.entryFee(request);
    }
}
