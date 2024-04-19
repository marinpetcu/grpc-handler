package com.fanduel.grpchandler.service;

import beyondplay.contrib.v1.Contribute;
import beyondplay.contrib.v1.Contribute.ContributeRequest;
import beyondplay.contrib.v1.ContributionServiceGrpc;
import com.fanduel.grpchandler.model.HandlerRequest;
import com.google.type.Money;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class HandlerService {

    @GrpcClient("contribute")
    private ContributionServiceGrpc.ContributionServiceBlockingStub contributeService;

    private final Logger logger = LoggerFactory.getLogger(HandlerService.class);

    public void contribute(HandlerRequest request) {
        logger.info("Should call engine contribute endpoint through gRPC");

        Contribute.Contribution contribution = Contribute.Contribution.newBuilder()
                .setBaseWager(Money.newBuilder()
                        .setUnits(request.amount().longValue())
                        .build())
                .setPlayerId(request.userId().toString())
                .setRoundId(request.transactionRef())
                .build();

        ContributeRequest contributeRequest = ContributeRequest.newBuilder()
                .setData(contribution)
                .build();


        contributeService.contribute(contributeRequest);
    }
}
