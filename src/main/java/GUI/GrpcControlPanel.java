/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;
import distsys.generated.*;
import distsys.generated.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.concurrent.CountDownLatch;
/**
 *
 * @author 刘佳
 */




public class GrpcControlPanel extends JFrame {

    private JTextField inputField;
    private JTextArea outputArea;

    public GrpcControlPanel() {
        setTitle("gRPC Service Controller");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // 输入区域
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());

        inputField = new JTextField(20);
        JButton recommendBtn = new JButton("Recommendation");
        JButton checkoutBtn = new JButton("Checkout");
        JButton inventoryBtn = new JButton("Inventory");

        topPanel.add(new JLabel("Product/Transaction:"));
        topPanel.add(inputField);
        topPanel.add(recommendBtn);
        topPanel.add(checkoutBtn);
        topPanel.add(inventoryBtn);

        add(topPanel, BorderLayout.NORTH);

        // 输出区域
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        // 按钮功能绑定
        recommendBtn.addActionListener(this::callRecommendation);
        checkoutBtn.addActionListener(this::callCheckout);
        inventoryBtn.addActionListener(this::callInventory);
    }

    private void callRecommendation(ActionEvent e) {
        String input = inputField.getText().trim();
        if (input.isEmpty()) return;

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50053).usePlaintext().build();
        RecommendationServiceGrpc.RecommendationServiceBlockingStub stub =
                RecommendationServiceGrpc.newBlockingStub(channel);

        RecommendationRequest request = RecommendationRequest.newBuilder().setProductName(input).build();

        append("→ Calling Recommendation (Unary)...");
        RecommendationResponse response = stub.getRecommendations(request);
        append("← Response: " + response.getRecommendationsList());

        append("→ Calling Recommendation (Server Streaming)...");
        stub.streamRecommendations(request).forEachRemaining(resp ->
                append("← Streamed: " + resp.getRecommendationsList()));

        channel.shutdown();
    }

    private void callCheckout(ActionEvent e) {
        String txId = inputField.getText().trim();
        if (txId.isEmpty()) return;

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50054).usePlaintext().build();
        CheckoutServiceGrpc.CheckoutServiceStub asyncStub = CheckoutServiceGrpc.newStub(channel);

        CountDownLatch latch = new CountDownLatch(1);
        append("→ Calling Checkout (Bi-Streaming)...");

        StreamObserver<PaymentRequest> sender = asyncStub.paymentStatus(new StreamObserver<>() {
            @Override
            public void onNext(PaymentResponse value) {
                append("← Status: " + value.getStatus());
            }

            @Override
            public void onError(Throwable t) {
                append("Error: " + t.getMessage());
                latch.countDown();
            }

            @Override
            public void onCompleted() {
                append("✔️ Bi-Streaming Completed");
                latch.countDown();
            }
        });

        sender.onNext(PaymentRequest.newBuilder().setTransactionId(txId).build());
        sender.onCompleted();

        try {
            latch.await();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        channel.shutdown();
    }

    private void callInventory(ActionEvent e) {
        String productId = inputField.getText().trim();
        if (productId.isEmpty()) return;

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50055).usePlaintext().build();
        InventoryServiceGrpc.InventoryServiceStub stub = InventoryServiceGrpc.newStub(channel);

        append("→ Calling Inventory (Server Streaming)...");

        stub.streamStockUpdates(ProductRequest.newBuilder().setProductId(productId).build(),
                new StreamObserver<>() {
                    @Override
                    public void onNext(StockUpdateResponse value) {
                        append("← Stock: " + value.getProductId() + " = " + value.getStockQuantity());
                    }

                    @Override
                    public void onError(Throwable t) {
                        append("Error: " + t.getMessage());
                    }

                    @Override
                    public void onCompleted() {
                        append("✔️ Inventory Streaming Completed");
                    }
                });
    }

    private void append(String text) {
        outputArea.append(text + "\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GrpcControlPanel gui = new GrpcControlPanel();
            gui.setVisible(true);
        });
    }
}

