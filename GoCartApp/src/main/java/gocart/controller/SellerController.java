package src.main.java.gocart.controller;

import src.main.java.gocart.model.Product;
import src.main.java.gocart.util.DatabaseUtil;

public class SellerController {
    /**
     * Adds a new product to the inventory.
     *
     * @param product The product to add.
     * @return true if the operation is successful, false otherwise.
     */
    public boolean addProduct(Product product) {
        // Validate product details
        if (product == null || !product.isValid()) {
            return false;
        }

        // Add product to the database
        return DatabaseUtil.addProductToInventory(product);
    }

    /**
     * Updates an existing product in the inventory.
     *
     * @param product The product with updated details.
     * @return true if the operation is successful, false otherwise.
     */
    public boolean updateProduct(Product product) {
        // Validate product details
        if (product == null || !product.isValid()) {
            return false;
        }

        // Update product in the database
        return DatabaseUtil.updateProductInInventory(product);
    }

    /**
     * Retrieves sales metrics or reports.
     *
     * @return Sales metrics.
     */
    public SalesMetrics getSalesMetrics() {
        // Retrieve and return sales metrics from the database
        return DatabaseUtil.getSalesMetrics();
    }
}
