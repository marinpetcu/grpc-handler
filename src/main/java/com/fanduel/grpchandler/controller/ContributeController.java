package com.fanduel.grpchandler.controller;

import com.fanduel.grpchandler.model.ContributeRequest;
import com.fanduel.grpchandler.service.ContributeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contribute")
public class ContributeController {

    private final ContributeService contributeService;

    private final Logger logger = LoggerFactory.getLogger(ContributeController.class);

    public ContributeController(ContributeService contributeService) {
        this.contributeService = contributeService;
    }

    @PostMapping
    public void contribute(@RequestBody ContributeRequest request) {
        logger.info("Received request: " + request);
        contributeService.contribute(request);
    }
}
