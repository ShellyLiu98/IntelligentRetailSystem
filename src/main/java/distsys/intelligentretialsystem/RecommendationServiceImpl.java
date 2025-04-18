/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package distsys.intelligentretialsystem;

import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import distsys.generated.RecommendationServiceGrpc;
import distsys.generated.RecommendationRequest;
import distsys.generated.RecommendationResponse;

/**
 * RecommendationServiceImpl handles product recommendation requests.
 * API key validation is simulated by requiring the product name to start with "key_".
 * If the condition is not met, the server responds with UNAUTHENTICATED status.
 * 
 * Author: Jia Liu                                                
 */
public class RecommendationServiceImpl extends RecommendationServiceGrpc.RecommendationServiceImplBase {

    /**
     * Unary RPC: Return a set of recommendations based on a product name.
     */
    @Override
    public void getRecommendations(RecommendationRequest request, StreamObserver<RecommendationResponse> responseObserver) {
        String product = request.getProductName();

        // Simulated API key check: product name must start with "key_"
        if (!product.startsWith("key_")) {
            responseObserver.onError(
                    Status.UNAUTHENTICATED
                            .withDescription("Invalid API key. Product name must start with 'key_'")
                            .asRuntimeException()
            );
            return;
        }

        // Build a sample response if validation passes
        RecommendationResponse response = RecommendationResponse.newBuilder()
                .addRecommendations("Related Product A for " + product)
                .addRecommendations("Related Product B for " + product)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    /**
     * Server Streaming RPC: Stream multiple recommendations based on a product.
     */
    public void streamRecommendations(RecommendationRequest request, StreamObserver<RecommendationResponse> responseObserver) {
        String product = request.getProductName();

        // Simulated API key check
        if (!product.startsWith("key_")) {
            responseObserver.onError(
                    Status.UNAUTHENTICATED
                            .withDescription("Invalid API key. Product name must start with 'key_'")
                            .asRuntimeException()
            );
            return;
        }

        // Stream several recommendations
        for (int i = 1; i <= 5; i++) {
            RecommendationResponse response = RecommendationResponse.newBuilder()
                    .addRecommendations("Related Product " + i + " for " + product)
                    .build();
            responseObserver.onNext(response);

            try {
                Thread.sleep(500); // Simulate delay between responses
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        responseObserver.onCompleted();
    }
}
