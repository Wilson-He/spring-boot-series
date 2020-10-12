package io.wilson.grpc.server.service;

import io.grpc.stub.StreamObserver;
import io.wilson.grpc.common.message.HelloReply;
import io.wilson.grpc.common.message.HelloRequest;
import io.wilson.grpc.common.message.HelloWorldServiceGrpc;
import net.devh.boot.grpc.server.service.GrpcService;

/**
 * @author Wilson
 */
@GrpcService
public class HelloServerService extends HelloWorldServiceGrpc.HelloWorldServiceImplBase {
    private static String TEMPLATE = "Hey, %s! Your request has been sent to server";

    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        System.out.println("HelloServerService receive request: " + request);
        responseObserver.onNext(HelloReply.newBuilder()
                .setMessage(String.format(TEMPLATE, request.getName()))
                .build());
        responseObserver.onCompleted();
    }
}
