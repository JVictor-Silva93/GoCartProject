package src.main.java.gocart.model;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
     // A map to hold products and their quantities
    private Map<Product, Integer> products;

    public Inventory() {
        products = new HashMap<>();
    }

    /**
     * Adds a product to the inventory with the specified quantity.
     *
     * @param product The product to add.
     * @param quantity The quantity of the product.
     */
    public void addProduct(Product product, int quantity) {
        if (product == null || quantity <= 0) {
            throw new IllegalArgumentException("Invalid product or quantity");
        }
        products.put(product, quantity);
    }

    /**
     * Updates the quantity of a product in the inventory.
     *
     * @param product The product to update.
     * @param quantity The new quantity of the product.
     */
    public void updateProductQuantity(Product product, int quantity) {
        if (!products.containsKey(product) || quantity < 0) {
            throw new IllegalArgumentException("Product not found or invalid quantity");
        }
        products.put(product, quantity);
    }

    /**
     * Removes a product from the inventory.
     *
     * @param product The product to remove.
     */
    public void removeProduct(Product product) {
        if (!products.containsKey(product)) {
            throw new IllegalArgumentException("Product not found");
        }
        products.remove(product);
    }

    /**
     * Retrieves the quantity of a specific product in the inventory.
     *
     * @param product The product whose quantity is to be retrieved.
     * @return The quantity of the product.
     */
    public int getProductQuantity(Product product) {
        return products.getOrDefault(product, 0);
    }

    /**
     * Retrieves all products in the inventory.
     *
     * @return A map of all products and their quantities.
     */
    public Map<Product, Integer> getAllProducts() {
        return new HashMap<>(products);
    }
}
