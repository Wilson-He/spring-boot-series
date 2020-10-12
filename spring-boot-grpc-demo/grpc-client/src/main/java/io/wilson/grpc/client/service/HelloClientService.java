package io.wilson.grpc.client.service;

import io.grpc.stub.StreamObserver;
import io.wilson.grpc.common.message.HelloReply;
import io.wilson.grpc.common.message.HelloRequest;
import io.wilson.grpc.common.message.HelloWorldServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

/**
 * @author Wilson
 */
@Service
public class HelloClientService {
    @GrpcClient("grpc-server")
    private HelloWorldServiceGrpc.HelloWorldServiceStub helloWorldServiceStub;

    public void sayHello() {
        helloWorldServiceStub.sayHello(HelloRequest.newBuilder()
                .setName("Wilson")
                .build(), new StreamObserver<HelloReply>() {
            @Override
            public void onNext(HelloReply value) {
                System.out.println("receive server reply:" + value);
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onCompleted() {
                System.out.println("request finished! ");
            }
        });
    }
}
