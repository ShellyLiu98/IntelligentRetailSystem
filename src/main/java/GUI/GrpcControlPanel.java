package GUI;

import javax.swing.*;

/**
 * GrpcControlPanel - Main GUI frame to display and switch between all gRPC service panels.
 * Uses a tabbed interface for Recommendation, Checkout, and Inventory services.
 */
public class GrpcControlPanel extends JFrame {

    public GrpcControlPanel() {
        // Set up window title and size
        setTitle("Intelligent Retail System - gRPC GUI");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        // Create a tabbed pane for the service panels
        JTabbedPane tabbedPane = new JTabbedPane();

        // Add each service panel as a tab
        tabbedPane.addTab(" Recommendation", new RecommendationPanel());
        tabbedPane.addTab(" Checkout", new CheckoutPanel());
        tabbedPane.addTab(" Inventory", new InventoryPanel());

        // Add the tabbed pane to the main window
        add(tabbedPane);

        // Make the window visible
        setVisible(true);
    }

    public static void main(String[] args) {
        // Start the GUI using the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> new GrpcControlPanel());
    }
}
