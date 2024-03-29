package com.fanduel.grpchandler.controller;

import com.fanduel.grpchandler.model.HandlerRequest;
import com.fanduel.grpchandler.service.HandlerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contribute")
public class HandlerController {

    private final HandlerService handlerService;

    private final Logger logger = LoggerFactory.getLogger(HandlerController.class);

    public HandlerController(HandlerService handlerService) {
        this.handlerService = handlerService;
    }

    @PostMapping
    public void contribute(@RequestBody HandlerRequest request) {
        logger.info("Received request: " + request);
        handlerService.contribute(request);
    }
}
