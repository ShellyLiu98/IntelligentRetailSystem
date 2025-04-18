/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import distsys.generated.InventoryServiceGrpc;
import distsys.generated.ProductRequest;
import distsys.generated.StockResponse;
import distsys.generated.StockUpdateResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author JiaLiu
 */

/**
 * InventoryPanel provides a GUI to interact with InventoryService.
 */
public class InventoryPanel extends JPanel {
    private JTextField productIdField;
    private JButton checkStockButton;
    private JButton monitorButton;
    private JTextArea resultArea;

    private final InventoryServiceGrpc.InventoryServiceBlockingStub blockingStub;
    private final InventoryServiceGrpc.InventoryServiceStub asyncStub;

    public InventoryPanel() {
        // Create gRPC channel
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50055)
                .usePlaintext()
                .build();

        blockingStub = InventoryServiceGrpc.newBlockingStub(channel);
        asyncStub = InventoryServiceGrpc.newStub(channel);

        // GUI layout and components
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new FlowLayout());

        productIdField = new JTextField(10);
        checkStockButton = new JButton("Check Stock");
        monitorButton = new JButton("Monitor Stock");

        inputPanel.add(new JLabel("Product ID:"));
        inputPanel.add(productIdField);
        inputPanel.add(checkStockButton);
        inputPanel.add(monitorButton);

        resultArea = new JTextArea(10, 40);
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);

        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Button: Check stock (Unary RPC)
        checkStockButton.addActionListener(new ActionListener() {
     @Override
     public void actionPerformed(ActionEvent e) {
         String productId = productIdField.getText();
         ProductRequest request = ProductRequest.newBuilder()
                 .setProductId(productId)
                 .build();

         try {
             StockResponse response = blockingStub.checkStock(request);
             resultArea.setText("Available Quantity: " + response.getStockStatus());
         } catch (Exception ex) {
             resultArea.setText("Error: " + ex.getMessage());
         }
     }
 });

        // Button: Monitor stock (Server Streaming RPC)
monitorButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String productId = productIdField.getText();
        resultArea.setText("Monitoring stock updates...\n");

        // Create StreamObserver for receiving responses
        StreamObserver<StockUpdateResponse> responseObserver = new StreamObserver<StockUpdateResponse>() {
            @Override
            public void onNext(StockUpdateResponse response) {
                resultArea.append("Update for Product ID " + response.getProductId() +
                        ": Quantity = " + response.getStockQuantity() + "\n");
            }

            @Override
            public void onError(Throwable t) {
                resultArea.append("Error: " + t.getMessage() + "\n");
            }

            @Override
            public void onCompleted() {
                resultArea.append("Stock monitoring completed.\n");
            }
        };

        // Call bidirectional streaming method to get requestObserver
        StreamObserver<distsys.generated.StockUpdateRequest> requestObserver =
                asyncStub.monitorStock(responseObserver);

        // Send request
        distsys.generated.StockUpdateRequest request = distsys.generated.StockUpdateRequest.newBuilder()
                .addProductIds(productId)
                .build();

        requestObserver.onNext(request);
    }
});

    }
}