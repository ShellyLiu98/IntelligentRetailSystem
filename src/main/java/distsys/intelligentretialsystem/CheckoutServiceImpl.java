/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package distsys.intelligentretialsystem;

import io.grpc.Status;
import io.grpc.stub.StreamObserver;

import distsys.generated.ShoppingCart;
import distsys.generated.PaymentRequest;
import distsys.generated.PaymentResponse;

import distsys.generated.CheckoutServiceGrpc;
/**
 *
 * @author JiaLiu
 */

/**
 * CheckoutServiceImpl handles client-streaming and bidirectional streaming payment-related RPCs.
 * This version includes a simulated API key check by requiring all product or transaction IDs
 * to start with the prefix "key_".
 * 
 * @author JiaLiu
 */
public class CheckoutServiceImpl extends CheckoutServiceGrpc.CheckoutServiceImplBase {

    /**
     * Process payment using client streaming.
     * API key is simulated by checking whether the first product ID starts with "key_".
     */
    @Override
    public StreamObserver<ShoppingCart> processPayment(StreamObserver<PaymentResponse> responseObserver) {
        return new StreamObserver<ShoppingCart>() {
            @Override
            public void onNext(ShoppingCart cart) {
                // ✅ Simulated API key validation
                if (cart.getProductIdsList().isEmpty() || 
                    !cart.getProductIdsList().get(0).startsWith("key_")) {
                    responseObserver.onError(
                        Status.UNAUTHENTICATED
                            .withDescription("Invalid API key. First product ID must start with 'key_'")
                            .asRuntimeException()
                    );
                    return;
                }

                // Simulate processing payment if validation passes
                String status = "✅ Payment received for " + cart.getProductIdsList();
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

    /**
     * Get payment status via bidirectional streaming.
     * API key is simulated by checking whether the transaction ID starts with "key_".
     */
    @Override
    public StreamObserver<PaymentRequest> paymentStatus(StreamObserver<PaymentResponse> responseObserver) {
        return new StreamObserver<PaymentRequest>() {
            @Override
            public void onNext(PaymentRequest request) {
                // ✅ Simulated API key validation
                if (!request.getTransactionId().startsWith("key_")) {
                    responseObserver.onError(
                        Status.UNAUTHENTICATED
                            .withDescription("Invalid API key. Transaction ID must start with 'key_'")
                            .asRuntimeException()
                    );
                    return;
                }

                // Simulate valid status response
                PaymentResponse response = PaymentResponse.newBuilder()
                        .setStatus("✅ Status OK")
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

    /**
     * Stream real-time status updates for a given transaction.
     * This method does not include API key logic as it is a simple server-streaming simulation.
     */
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
