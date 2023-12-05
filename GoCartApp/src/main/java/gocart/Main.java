package src.main.java.gocart;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    public static void main(String[] args) {
        // Set the look and feel to the system look and feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Create and set up the main window
        JFrame frame = new JFrame("GoCart - Shopping Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);  // Center the window

        // Create buttons for customer and seller login
        JButton customerButton = new JButton("Customer Login");
        JButton sellerButton = new JButton("Seller Login");

        // Add action listeners to buttons
        customerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open customer login dialog
                CustomerLoginDialog dialog = new CustomerLoginDialog(frame);
                dialog.setVisible(true);
                if (dialog.isLoginSuccessful()) {
                    // Proceed to customer interface
                    openCustomerInterface();
                }
            }
        });

        sellerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open seller login dialog
                SellerLoginDialog dialog = new SellerLoginDialog(frame);
                dialog.setVisible(true);
                if (dialog.isLoginSuccessful()) {
                    // Proceed to seller interface
                    openSellerInterface();
                }
            }
        });

        // Create a panel and add buttons to it
        JPanel panel = new JPanel();
        panel.add(customerButton);
        panel.add(sellerButton);

        // Add the panel to the frame
        frame.getContentPane().add(panel, BorderLayout.CENTER);

        // Display the window
        frame.setVisible(true);
    }
}
