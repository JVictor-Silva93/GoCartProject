package src.main.java.gocart.view;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import src.main.java.gocart.controller.SellerController;
import src.main.java.gocart.model.Product;

public class SellerView {

    private SellerController sellerController;

    //UI Components
    private JList<Product> productList;
    private JButton addButton;
    private JButton updateButton;
    private JButton removeButton;
    private JButton viewMetricsButton;

    public SellerView(SellerController controller) {
        this.sellerController = controller;
        initializeUI();
    }

    private void initializeUI() {
        setTitle("GoCart - Seller");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        //product List
        productList = new JList<>();
        updateProductList();
        JScrollPane scrollPane = new JScrollPane(productList);
        add(scrollPane, BorderLayout.CENTER);

        //panel for buttons
        JPanel buttonPanel = new JPanel();
        addButton = new JButton("Add Product");
        updateButton = new JButton("Update Product");
        removeButton = new JButton("Remove Product");
        viewMetricsButton = new JButton("View Sales Metrics");

        //Add action listeners
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNewProduct();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateSelectedProduct();
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeSelectedProduct();
            }
        });

        viewMetricsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewSalesMetrics();
            }
        });

        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(viewMetricsButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Display the window
        setVisible(true);
    }

    private void updateProductList() {
        DefaultListModel<Product> model = new DefaultListModel<>();
        for (Product product : sellerController.getAvailableProducts()) {
            model.addElement(product);
        }
        productList.setModel(model);
    }

    private void addNewProduct() {
        ProductDialog dialog = new ProductDialog(this, "Add New Product");
        Product newProduct = dialog.getProduct();
        if (newProduct != null && sellerController.addProduct(newProduct)) {
            updateProductList();
        }
    }

    private void updateSelectedProduct() {
        Product selectedProduct = productList.getSelectedValue();
        if (selectedProduct != null) {
            ProductDialog dialog = new ProductDialog(this, "Update Product", selectedProduct);
            Product updatedProduct = dialog.getProduct();
            if (updatedProduct != null && sellerController.updateProduct(updatedProduct)) {
                updateProductList();
            }
        }
    }

    private void removeSelectedProduct() {
        Product selectedProduct = productList.getSelectedValue();
        if (selectedProduct != null) {
            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to remove this product?");
            if (confirm == JOptionPane.YES_OPTION && sellerController.removeProduct(selectedProduct)) {
                updateProductList();
            }
        }
    }

    private void viewSalesMetrics() {
        SalesMetrics metrics = sellerController.getSalesMetrics();
        MetricsDialog metricsDialog = new MetricsDialog(this, metrics);
        metricsDialog.setVisible(true);
    }

}
