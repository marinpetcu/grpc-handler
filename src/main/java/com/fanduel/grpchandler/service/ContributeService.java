package com.fanduel.grpchandler.service;

import com.fanduel.grpchandler.model.ContributeRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ContributeService {

    private final Logger logger = LoggerFactory.getLogger(ContributeService.class);

    public void contribute(ContributeRequest request) {
        logger.info("Should call engine contribute endpoint through gRPC");
    }
}
