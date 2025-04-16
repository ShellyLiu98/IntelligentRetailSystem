/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Client;
import distsys.generated.PaymentRequest;
import distsys.generated.PaymentResponse;
import distsys.generated.ShoppingCart;
import distsys.generated.CheckoutServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

/**
 *
 * @author 刘佳
 */




import java.util.Arrays;
import java.util.concurrent.CountDownLatch;

public class CheckoutClient {
    public static void main(String[] args) throws InterruptedException {
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 50054)
                .usePlaintext()
                .build();

        CheckoutServiceGrpc.CheckoutServiceStub asyncStub = CheckoutServiceGrpc.newStub(channel);

        // Client Streaming: ProcessPayment
        CountDownLatch latch1 = new CountDownLatch(1);
        System.out.println("🔹 Client Streaming: processPayment");
        StreamObserver<PaymentResponse> paymentResponseObserver;
        paymentResponseObserver = new StreamObserver<>() {
            @Override
            public void onNext(PaymentResponse response) {
                System.out.println("Received payment confirmation: " + response.getStatus());
            }

            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
                latch1.countDown();
            }

            @Override
            public void onCompleted() {
                System.out.println("Client Streaming completed.");
                latch1.countDown();
            }
        };

        StreamObserver<ShoppingCart> cartSender = asyncStub.processPayment(paymentResponseObserver);

        cartSender.onNext(ShoppingCart.newBuilder()
                .addAllProductIds(Arrays.asList("item1", "item2"))
                .setPaymentMethod("Card")
                .build());
        cartSender.onNext(ShoppingCart.newBuilder()
                .addProductIds("item3")
                .setPaymentMethod("Card")
                .build());

        cartSender.onCompleted();
        latch1.await();

        // Bi-directional Streaming: PaymentStatus
        CountDownLatch latch2 = new CountDownLatch(1);
        System.out.println("🔹 Bi-directional Streaming: paymentStatus");

        StreamObserver<PaymentRequest> requestStream = asyncStub.paymentStatus(new StreamObserver<>() {
            @Override
            public void onNext(PaymentResponse response) {
                System.out.println("Status: " + response.getStatus());
            }

            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
                latch2.countDown();
            }

            @Override
            public void onCompleted() {
                System.out.println("Bi-directional streaming completed.");
                latch2.countDown();
            }
        });

        requestStream.onNext(PaymentRequest.newBuilder().setTransactionId("TX123").build());
        requestStream.onNext(PaymentRequest.newBuilder().setTransactionId("TX124").build());
        requestStream.onCompleted();

        latch2.await();
        channel.shutdown();
    }
}

