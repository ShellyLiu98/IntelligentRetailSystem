/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Client;
import distsys.generated.ProductRequest;
import distsys.generated.StockResponse;
import distsys.generated.StockUpdateResponse;
import distsys.generated.InventoryServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.concurrent.CountDownLatch;

/**
 *
 * @author 刘佳
 */


public class InventoryClient {
    public static void main(String[] args) throws InterruptedException {
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 50055)
                .usePlaintext()
                .build();

        InventoryServiceGrpc.InventoryServiceBlockingStub stub = InventoryServiceGrpc.newBlockingStub(channel);
        InventoryServiceGrpc.InventoryServiceStub asyncStub = InventoryServiceGrpc.newStub(channel);

        // Unary call
        System.out.println("🔹 Unary: checkStock");
        ProductRequest request = ProductRequest.newBuilder().setProductId("P123").build();
        StockResponse response = stub.checkStock(request);
        System.out.println("Stock status: " + response.getStockStatus());

        // Server Streaming
        System.out.println("🔹 Server Streaming: streamStockUpdates");
        CountDownLatch latch = new CountDownLatch(1);

        asyncStub.streamStockUpdates(request, new StreamObserver<>() {
            @Override
            public void onNext(StockUpdateResponse value) {
                System.out.println("Stock for " + value.getProductId() + ": " + value.getStockQuantity());
            }

            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
                latch.countDown();
            }

            @Override
            public void onCompleted() {
                System.out.println("Server streaming completed.");
                latch.countDown();
            }
        });

        latch.await();
        channel.shutdown();
    }
}
