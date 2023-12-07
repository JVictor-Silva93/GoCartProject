package src.main.java.gocart;

import javax.swing.*;

import src.main.java.gocart.controller.CustomerController;
import src.main.java.gocart.controller.SellerController;
import src.main.java.gocart.view.CustomerView;
import src.main.java.gocart.view.SellerView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    public static void main(String[] args) {
        //set the look and feel to the system look and feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        //create and set up the main window
        JFrame frame = new JFrame("GoCart - Shopping Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);

        //create buttons for customer and seller interface
        JButton customerButton = new JButton("Open Customer Interface");
        JButton sellerButton = new JButton("Open Seller Interface");

        //action listeners to buttons
        customerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openCustomerInterface();
            }
        });

        sellerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openSellerInterface();
            }
        });

        //panel w/ buttons
        JPanel panel = new JPanel();
        panel.add(customerButton);
        panel.add(sellerButton);

        //add  panel to the frame
        frame.getContentPane().add(panel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private static void openCustomerInterface() {
        CustomerController customerController = new CustomerController();
        new CustomerView(customerController);
    }

    private static void openSellerInterface() {
        SellerController sellerController = new SellerController();
        new SellerView(sellerController);
    }
    
}
