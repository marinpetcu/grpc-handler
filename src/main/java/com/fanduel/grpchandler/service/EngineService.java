package com.fanduel.grpchandler.service;

import com.fanduel.grpc.lib.ContributeRequest;
import com.fanduel.grpc.lib.ContributeServiceGrpc;
import com.fanduel.grpc.lib.ContributeServiceGrpc.ContributeServiceBlockingStub;
import com.fanduel.grpchandler.model.EngineRequest;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class EngineService {

    @GrpcClient("contribute")
    private ContributeServiceBlockingStub contributeService;

    private final Logger logger = LoggerFactory.getLogger(EngineService.class);

    public void contribute(EngineRequest request) {
        logger.info("Should call engine contribute endpoint through gRPC");

        ContributeRequest contributeRequest =  ContributeRequest.newBuilder()
                .setRequestId(request.requestId())
                .setAmount(request.amount().doubleValue())
                .setUserId(request.userId())
                .setTransactionRef(request.transactionRef())
                .build();

        contributeService.contribute(contributeRequest);
    }
}
