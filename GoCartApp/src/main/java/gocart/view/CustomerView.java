package src.main.java.gocart.view;

// import javax.swing.*;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import src.main.java.gocart.controller.CustomerController;
import src.main.java.gocart.model.Product;

public class CustomerView extends JFrame{
    private CustomerController customerController;

    // UI Components
    private JList<Product> productList;
    private JButton addToCartButton;
    private JButton checkoutButton;

    public CustomerView(CustomerController controller) {
        this.customerController = controller;
        initializeUI();
    }

    private void initializeUI() {
        setTitle("GoCart - Customer");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Product List
        productList = new JList<>();
        updateProductList();
        JScrollPane scrollPane = new JScrollPane(productList);
        add(scrollPane, BorderLayout.CENTER);

        // Panel for buttons
        JPanel buttonPanel = new JPanel();
        addToCartButton = new JButton("Add to Cart");
        checkoutButton = new JButton("Checkout");

        // Add action listeners
        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addSelectedProductToCart();
            }
        });

        checkoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                proceedToCheckout();
            }
        });

        buttonPanel.add(addToCartButton);
        buttonPanel.add(checkoutButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Display the window
        setVisible(true);
    }

    private void updateProductList() {
        // Fetch products and update the product list
        DefaultListModel<Product> model = new DefaultListModel<>();
        for (Product product : customerController.getAvailableProducts()) {
            model.addElement(product);
        }
        productList.setModel(model);
    }

    private void addSelectedProductToCart() {
        // Add the selected product to the shopping cart
        Product selectedProduct = productList.getSelectedValue();
        if (selectedProduct != null) {
            customerController.addProductToCart(selectedProduct, 1); // Quantity is set to 1 for simplicity
        }
    }

    private void proceedToCheckout() {
        // Handle checkout logic
        customerController.checkout();
        JOptionPane.showMessageDialog(this, "Checkout successful!");
    }
}
