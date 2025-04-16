/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package distsys.intelligentretialsystem;

import io.grpc.stub.StreamObserver;

import distsys.generated.ShoppingCart;
import distsys.generated.PaymentRequest;
import distsys.generated.PaymentResponse;

import distsys.generated.CheckoutServiceGrpc;
/**
 *
 * @author JiaLiu
 */




public class CheckoutServiceImpl extends CheckoutServiceGrpc.CheckoutServiceImplBase {

    @Override
    public StreamObserver<ShoppingCart> processPayment(StreamObserver<PaymentResponse> responseObserver) {
        return new StreamObserver<ShoppingCart>() {
            @Override
            public void onNext(ShoppingCart cart) {
                // Simulate processing payment
                String status = "Payment received for " + cart.getProductIdsList();
                PaymentResponse response = PaymentResponse.newBuilder()
                        .setStatus(status)
                        .setTransactionId("TX123")
                        .build();
                responseObserver.onNext(response);
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("Payment stream error: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
    }

    @Override
    public StreamObserver<PaymentRequest> paymentStatus(StreamObserver<PaymentResponse> responseObserver) {
        return new StreamObserver<PaymentRequest>() {
            @Override
            public void onNext(PaymentRequest request) {
                PaymentResponse response = PaymentResponse.newBuilder()
                        .setStatus("Status OK")
                        .setTransactionId(request.getTransactionId())
                        .build();
                responseObserver.onNext(response);
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("Status stream error: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
    }
    public void streamPaymentStatus(PaymentRequest request, StreamObserver<PaymentResponse> responseObserver) {
        String txId = request.getTransactionId();

        String[] statuses = {"Processing", "Payment Confirmed", "Packing", "Shipped", "Delivered"};
        for (String status : statuses) {
            PaymentResponse response = PaymentResponse.newBuilder()
                .setStatus(status)
                .setTransactionId(txId)
                .build();
            responseObserver.onNext(response);

            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        responseObserver.onCompleted();
}

}

