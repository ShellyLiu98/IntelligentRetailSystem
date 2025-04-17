package GUI;
import javax.swing.*;
import java.awt.*;
import distsys.GUI.RecommendationPanel;
import distsys.intelligentretailsystem.GUI.CheckoutPanel;
import distsys.intelligentretailsystem.GUI.InventoryPanel;

public class GrpcControlPanel extends JFrame {

    public GrpcControlPanel() {
        setTitle("Intelligent Retail System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        // Create tabs for each service
        JTabbedPane tabbedPane = new JTabbedPane();

        // Add the individual service panels
        tabbedPane.addTab("Recommendation", new RecommendationPanel());
        tabbedPane.addTab("Checkout", new CheckoutPanel());
        tabbedPane.addTab("Inventory", new InventoryPanel());

        // Add the tabbed pane to the window
        add(tabbedPane, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        // Launch the GUI
        SwingUtilities.invokeLater(() -> new GrpcControlPanel());
    }
}
