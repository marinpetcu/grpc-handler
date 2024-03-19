package com.fanduel.grpchandler.service;

import com.fanduel.grpc.lib.EngineContributeRequest;
import com.fanduel.grpc.lib.EngineContributeServiceGrpc;
import com.fanduel.grpchandler.model.ContributeRequest;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ContributeService {

    @GrpcClient("engine")
    private EngineContributeServiceGrpc.EngineContributeServiceBlockingStub engineContributeServiceStub;

    private final Logger logger = LoggerFactory.getLogger(ContributeService.class);

    public void contribute(ContributeRequest request) {
        logger.info("Should call engine contribute endpoint through gRPC");

        EngineContributeRequest engineContributeRequest =  EngineContributeRequest.newBuilder()
                .setRequestId(request.requestId())
                .setAmount(request.amount().doubleValue())
                .setUserId(request.userId())
                .setTransactionRef(request.transactionRef())
                .build();

        engineContributeServiceStub.contribute(engineContributeRequest);
    }
}
