package com.fanduel.grpchandler.service;

import beyondplay.contrib.v1.ContributeRequest;
import beyondplay.contrib.v1.Contribution;
import beyondplay.contrib.v1.ContributionServiceGrpc;
import beyondplay.contrib.v1.ContributionServiceGrpc.ContributionServiceBlockingStub;
import com.fanduel.grpchandler.model.HandlerRequest;
import com.google.protobuf.Struct;
import com.google.protobuf.Value;
import com.google.type.Money;
import io.grpc.Channel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.Executors;

@Service
public class HandlerService {

    private final Logger logger = LoggerFactory.getLogger(HandlerService.class);

    public void contribute(HandlerRequest request) {
        logger.info("Should call engine contribute endpoint through gRPC");

        Contribution contribution = Contribution.newBuilder()
                .setGameroundId(request.transactionRef())
                .setPlayerId(request.userId().toString())
                .setBaseWager(
                        Money.newBuilder()
                                .setUnits(request.amount().intValue())
                                .build()
                )
                .setMetadata(
                        Struct.newBuilder()
                                .putFields("key", Value.newBuilder().setBoolValue(false).build())
                                .build()
                )
                .build();

        ContributeRequest contributeRequest = ContributeRequest.newBuilder()
                .setData(contribution)
                .build();

        var channel = ManagedChannelBuilder.forAddress("127.0.0.1", 9898).usePlaintext().build();
        ContributionServiceBlockingStub contributionService = ContributionServiceGrpc.newBlockingStub(channel);

        try {
             contributionService.contribute(contributeRequest);
        } catch (Exception e) {
            Status.fromThrowable(e);
            e.printStackTrace();
        }
    }
}
