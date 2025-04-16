/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package distsys.intelligentretialsystem;

import io.grpc.stub.StreamObserver;
import distsys.generated.InventoryServiceGrpc;
import distsys.generated.ProductRequest;
import distsys.generated.StockResponse;
import distsys.generated.StockUpdateRequest;
import distsys.generated.StockUpdateResponse;

/**
 *
 * @author JiaLiu
 */

public class InventoryServiceImpl extends InventoryServiceGrpc.InventoryServiceImplBase {

    @Override
    public void checkStock(ProductRequest request, StreamObserver<StockResponse> responseObserver) {
        StockResponse response = StockResponse.newBuilder()
                .setStockStatus("In Stock")
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<StockUpdateRequest> monitorStock(StreamObserver<StockUpdateResponse> responseObserver) {
        return new StreamObserver<StockUpdateRequest>() {
            @Override
            public void onNext(StockUpdateRequest request) {
                for (String productId : request.getProductIdsList()) {
                    StockUpdateResponse update = StockUpdateResponse.newBuilder()
                            .setProductId(productId)
                            .setStockQuantity(99)
                            .build();
                    responseObserver.onNext(update);
                }
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("MonitorStock error: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
    }
    public void streamStockUpdates(ProductRequest request, StreamObserver<StockUpdateResponse> responseObserver) {
        String productId = request.getProductId();

        for (int i = 0; i < 5; i++) {
            int stock = 100 - i * 5;

            StockUpdateResponse response = StockUpdateResponse.newBuilder()
                    .setProductId(productId)
                    .setStockQuantity(stock)
                    .build();
            responseObserver.onNext(response);

            try {
                Thread.sleep(600);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        responseObserver.onCompleted();
    }

}
