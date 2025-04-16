package Client;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import distsys.generated.RecommendationRequest;
import distsys.generated.RecommendationResponse;
import distsys.generated.RecommendationServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

/**
 *
 * @author 刘佳
 */

public class RecommendationClient {
    public static void main(String[] args) throws InterruptedException {
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 50053)
                .usePlaintext()
                .build();

        // Unary call
        RecommendationServiceGrpc.RecommendationServiceBlockingStub stub =
                RecommendationServiceGrpc.newBlockingStub(channel);

        System.out.println("🔹 Unary call: getRecommendations");
        RecommendationRequest request = RecommendationRequest.newBuilder()
                .setProductName("Shoes")
                .build();
        RecommendationResponse response = stub.getRecommendations(request);
        System.out.println("Response: " + response.getRecommendationsList());

        // Server Streaming call
        System.out.println("🔹 Server Streaming call: streamRecommendations");
        stub.streamRecommendations(request).forEachRemaining(streamedResponse ->
                System.out.println("Streamed: " + streamedResponse.getRecommendationsList()));

        channel.shutdown();
    }
}
