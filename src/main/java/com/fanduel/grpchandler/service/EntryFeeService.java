package com.fanduel.grpchandler.service;

import com.fanduel.grpchandler.model.EntryFeeRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class EntryFeeService {

    private final Logger logger = LoggerFactory.getLogger(EntryFeeService.class);

    public void entryFee(EntryFeeRequest request) {
        logger.info("Should call engine contribute endpoint through gRPC");
    }
}
