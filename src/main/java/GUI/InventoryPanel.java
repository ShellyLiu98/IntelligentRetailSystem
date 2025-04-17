/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import distsys.generated.InventoryProto;
import distsys.generated.InventoryServiceGrpc;

/**
 *
 * @author JiaLiu
 */




public class InventoryPanel extends JPanel {

    private JTextField productIdField;
    private JTextArea resultArea;

    public InventoryPanel() {
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Product ID:"));
        productIdField = new JTextField(15);
        inputPanel.add(productIdField);

        JButton checkButton = new JButton("Check Stock");
        JButton monitorButton = new JButton("Monitor Stock");

        inputPanel.add(checkButton);
        inputPanel.add(monitorButton);

        resultArea = new JTextArea(10, 30);
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);

        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // gRPC channel
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50053)
                .usePlaintext()
                .build();

        InventoryServiceGrpc.InventoryServiceBlockingStub blockingStub = InventoryServiceGrpc.newBlockingStub(channel);
        InventoryServiceGrpc.InventoryServiceStub asyncStub = InventoryServiceGrpc.newStub(channel);

        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String productId = productIdField.getText();

                InventoryProto.ProductRequest request = InventoryProto.ProductRequest.newBuilder()
                        .setProductId(productId)
                        .build();

                InventoryProto.StockResponse response = blockingStub.checkStock(request);
                resultArea.setText("Available Quantity: " + response.getQuantity());
            }
        });

        monitorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String productId = productIdField.getText();

                InventoryProto.ProductRequest request = InventoryProto.ProductRequest.newBuilder()
                        .setProductId(productId)
                        .build();

                resultArea.setText("Monitoring stock updates...\n");

                asyncStub.monitorStock(request, new StreamObserver<InventoryProto.StockUpdateResponse>() {
                    @Override
                    public void onNext(InventoryProto.StockUpdateResponse response) {
                        resultArea.append("Update: " + response.getMessage() + "\n");
                    }

                    @Override
                    public void onError(Throwable t) {
                        resultArea.append("Error: " + t.getMessage() + "\n");
                    }

                    @Override
                    public void onCompleted() {
                        resultArea.append("Monitoring finished.\n");
                    }
                });
            }
        });
    }
}
