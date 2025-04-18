/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;

import distsys.generated.CheckoutProto.*;
import distsys.generated.CheckoutServiceGrpc;
import distsys.generated.ShoppingCart;
import distsys.generated.PaymentRequest;
import distsys.generated.PaymentResponse;
import distsys.generated.CheckoutServiceGrpc;


/**
 *
 * @author JiaLiu
 */


public class CheckoutPanel extends JPanel {

    private JTextArea cartInput;
    private JTextArea resultArea;

    public CheckoutPanel() {
        setLayout(new BorderLayout());

        cartInput = new JTextArea(5, 30);
        resultArea = new JTextArea(10, 30);
        resultArea.setEditable(false);

        JButton processPaymentButton = new JButton("Process Payment");
        JButton checkStatusButton = new JButton("Check Payment Status");

        JPanel topPanel = new JPanel(new GridLayout(2, 1));
        topPanel.add(new JScrollPane(cartInput));
        topPanel.add(processPaymentButton);

        JPanel middlePanel = new JPanel();
        middlePanel.add(new JLabel("Enter Transaction ID:"));
        JTextField transactionIdField = new JTextField(15);
        middlePanel.add(transactionIdField);
        middlePanel.add(checkStatusButton);

        add(topPanel, BorderLayout.NORTH);
        add(middlePanel, BorderLayout.CENTER);
        add(new JScrollPane(resultArea), BorderLayout.SOUTH);

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50054)
                .usePlaintext()
                .build();

        CheckoutServiceGrpc.CheckoutServiceStub asyncStub = CheckoutServiceGrpc.newStub(channel);

        processPaymentButton.addActionListener((ActionEvent e) -> {
            String[] products = cartInput.getText().split(",");
            StreamObserver<ShoppingCart> requestObserver = asyncStub.processPayment(new StreamObserver<PaymentResponse>() {
                @Override
                public void onNext(PaymentResponse response) {
                    resultArea.append("Payment Status: " + response.getStatus() + "\nTransaction ID: " + response.getTransactionId() + "\n");
                }

                @Override
                public void onError(Throwable t) {
                    resultArea.append("Error: " + t.getMessage() + "\n");
                }

                @Override
                public void onCompleted() {
                    resultArea.append("Payment process completed.\n");
                }
            });

            for (String p : products) {
                requestObserver.onNext(ShoppingCart.newBuilder().addProductIds(p.trim()).build());
            }
            requestObserver.onCompleted();
        });

        checkStatusButton.addActionListener((ActionEvent e) -> {
            String txId = transactionIdField.getText();

            StreamObserver<PaymentRequest> requestObserver = asyncStub.paymentStatus(new StreamObserver<PaymentResponse>() {
                @Override
                public void onNext(PaymentResponse response) {
                    resultArea.append("Transaction ID: " + response.getTransactionId() + "\nStatus: " + response.getStatus() + "\n");
                }

                @Override
                public void onError(Throwable t) {
                    resultArea.append("Error: " + t.getMessage() + "\n");
                }

                @Override
                public void onCompleted() {
                    resultArea.append("Status check complete.\n");
                }
            });

            requestObserver.onNext(PaymentRequest.newBuilder().setTransactionId(txId).build());
            requestObserver.onCompleted();
        });
    }
}

