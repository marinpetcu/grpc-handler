package com.fanduel.grpchandler.controller;

import com.fanduel.grpchandler.model.EngineRequest;
import com.fanduel.grpchandler.service.EngineService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/engine")
public class EngineController {

    private final EngineService engineService;

    private final Logger logger = LoggerFactory.getLogger(EngineController.class);

    public EngineController(EngineService engineService) {
        this.engineService = engineService;
    }

    @PostMapping
    public void contribute(@RequestBody EngineRequest request) {
        logger.info("Received request: " + request);
        engineService.contribute(request);
    }
}
