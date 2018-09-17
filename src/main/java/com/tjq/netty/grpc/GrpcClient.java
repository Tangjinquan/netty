/**
 * =============================================================
 * Copyright 2018 Lianjia Group All Rights Reserved
 * CompanyName: 上海链家有限公司
 * SystemName: 贝壳
 * ClassName: GrpcClient
 * version: 1.0.0
 * date: 2018/9/13
 * author: Tyson
 * =============================================================
 */
package com.tjq.netty.grpc;

import com.tjq.netty.proto.MRequest;
import com.tjq.netty.proto.MResponse;
import com.tjq.netty.proto.StudentServiceOGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @Description: TODO
 * @author Tyson
 * @date 2018/9/13下午4:07
 * @version V1.0
 */
public class GrpcClient {

    private static final Logger logger = Logger.getLogger(GrpcClient.class.getName());

    private final ManagedChannel channel;
    private final StudentServiceOGrpc.StudentServiceBlockingStub blockingStub;

    /** Construct client connecting to HelloWorld server at {@code host:port}. */
    public GrpcClient(String host, int port) {
        this(ManagedChannelBuilder.forAddress(host, port)
                // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
                // needing certificates.
                .usePlaintext()
                .build());
    }

    /** Construct client for accessing HelloWorld server using the existing channel. */
    GrpcClient(ManagedChannel channel) {
        this.channel = channel;
        blockingStub = StudentServiceOGrpc.newBlockingStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    /** Say hello to server. */
    public void greet(String name) {
        logger.info("Will try to greet " + name + " ...");
        MRequest request = MRequest.newBuilder().setUsername(name).build();
        MResponse response;
        try {
            response = blockingStub.getRealnameByUserName(request);
        } catch (StatusRuntimeException e) {
            logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
            return;
        }
        logger.info("Greeting: " + response.getRealname());
        System.out.println(response.getRealname());
    }

    /**
     * Greet server. If provided, the first element of {@code args} is the name to use in the
     * greeting.
     */
    public static void main(String[] args) throws Exception {
        GrpcClient client = new GrpcClient("localhost", 8899);
        try {
            /* Access a service running on the local machine on port 50051 */
            String username = "zhangsan";
            if (args.length > 0) {
                username = args[0]; /* Use the arg as the name to greet if provided */
            }
            client.greet(username);
        } finally {
            client.shutdown();
        }
    }
}
