package src.main.java.gocart.controller;

import java.util.ArrayList;
import java.util.List;

import src.main.java.gocart.model.Product;
import src.main.java.gocart.model.ShoppingCart;
import src.main.java.gocart.util.DatabaseUtil;

public class CustomerController {
    
    private ShoppingCart shoppingCart;

    public CustomerController() {
        shoppingCart = new ShoppingCart();
    }

    /**
     * Retrieves a list of products available for purchase.
     * @return A list of products.
     */
    public List<Product> getAvailableProducts() {
        return DatabaseUtil.getAllProducts();
    }

    /**
     * Adds a product to the customer's shopping cart.
     * @param product The product to add.
     * @param quantity The quantity of the product to add.
     */
    public void addProductToCart(Product product, int quantity) {
        // Check if the product is already in the cart
        if (shoppingCart.containsProduct(product)) {
            // If it is, just update the quantity
            shoppingCart.updateProductQuantity(product, quantity);
        } else {
            // If not, add it to the cart
            shoppingCart.addProduct(product, quantity);
        }
    }

    /**
     * Removes a product from the customer's shopping cart.
     * @param product The product to remove.
     */
    public void removeProductFromCart(Product product) {
        shoppingCart.removeProduct(product);
    }

    /**
     * Processes the checkout for the current shopping cart.
     */
    public void checkout() {
        // Validate the items in the cart
        if (!shoppingCart.validate()) {
            throw new IllegalStateException("Shopping cart contains invalid items.");
        }

        // Process payment - this is highly simplified
        if (!processPayment(shoppingCart.getTotalPrice())) {
            throw new IllegalStateException("Payment failed.");
        }

        // Update inventory
        shoppingCart.getProducts().forEach((product, quantity) -> {
            DatabaseUtil.updateProductInventory(product, -quantity);
        });

        // Clear the shopping cart after successful checkout
        shoppingCart.clear();
    }

    private boolean processPayment(double amount) {
        // Implement payment processing logic
        // This could involve integrating with a payment gateway
        return true; // Placeholder
    }

    // Additional customer-related methods can be added here
}
