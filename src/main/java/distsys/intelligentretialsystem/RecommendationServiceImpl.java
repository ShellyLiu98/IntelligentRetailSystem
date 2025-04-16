/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package distsys.intelligentretialsystem;

import io.grpc.stub.StreamObserver;
import distsys.generated.RecommendationServiceGrpc;
import distsys.generated.RecommendationRequest;
import distsys.generated.RecommendationResponse;





/**
 *
 * @author 刘佳
 */



public class RecommendationServiceImpl extends RecommendationServiceGrpc.RecommendationServiceImplBase {
    @Override
    public void getRecommendations(RecommendationRequest request, StreamObserver<RecommendationResponse> responseObserver) {
        String product = request.getProductName();

        RecommendationResponse response = RecommendationResponse.newBuilder()
                .addRecommendations("Related Product A for " + product)
                .addRecommendations("Related Product B for " + product)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
    public void streamRecommendations(RecommendationRequest request, StreamObserver<RecommendationResponse> responseObserver) {
    String product = request.getProductName();

    for (int i = 1; i <= 5; i++) {
        RecommendationResponse response = RecommendationResponse.newBuilder()
                .addRecommendations("Related Product " + i + " for " + product)
                .build();
        responseObserver.onNext(response);

        try {
            Thread.sleep(500); // 模拟服务端推送延迟
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    responseObserver.onCompleted();
}

}
