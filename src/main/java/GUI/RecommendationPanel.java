/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import distsys.generated.RecommendationRequest;
import distsys.generated.RecommendationResponse;
import distsys.generated.RecommendationServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;



/**
 *
 * @author JiaLiu
 */



public class RecommendationPanel extends JPanel {

    private JTextField productNameField;
    private JTextArea resultArea;

    public RecommendationPanel() {
        setLayout(new BorderLayout());

        // Top input panel
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        JLabel label = new JLabel("Product Name:");
        productNameField = new JTextField(20);
        JButton getRecommendationsButton = new JButton("Get Recommendations");

        inputPanel.add(label);
        inputPanel.add(productNameField);
        inputPanel.add(getRecommendationsButton);

        add(inputPanel, BorderLayout.NORTH);

        // Result area in center
        resultArea = new JTextArea();
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        add(scrollPane, BorderLayout.CENTER);

        // Button click event
        getRecommendationsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String productName = productNameField.getText().trim();
                if (!productName.isEmpty()) {
                    getRecommendations(productName);
                } else {
                    resultArea.setText("Please enter a product name.");
                }
            }
        });
    }

    // Call gRPC server
    private void getRecommendations(String productName) {
        try {
            // Connect to gRPC server
            ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                    .usePlaintext()
                    .build();

            RecommendationServiceGrpc.RecommendationServiceBlockingStub stub =
                    RecommendationServiceGrpc.newBlockingStub(channel);

            // Create request and call service
            RecommendationRequest request = RecommendationRequest.newBuilder()
                    .setProductName(productName)
                    .build();

            RecommendationResponse response = stub.getRecommendations(request);

            // Display result
            resultArea.setText("Recommended products for " + productName + ":\n");
            for (String rec : response.getRecommendationsList()) {
                resultArea.append("- " + rec + "\n");
            }

            // Shutdown channel
            channel.shutdown();

        } catch (Exception ex) {
            resultArea.setText("Error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}





