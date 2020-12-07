package io.wilson.grpc.server.service;

import io.grpc.stub.StreamObserver;
import io.wilson.grpc.common.BusinessException;
import io.wilson.grpc.common.aspect.CodeMsg;
import io.wilson.grpc.common.message.HelloReply;
import io.wilson.grpc.common.message.HelloRequest;
import io.wilson.grpc.common.service.HelloWorldServiceGrpc;
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
        throw new BusinessException(CodeMsg.BAD_REQUEST);
        //System.out.println(100 / 0);
    }
}
