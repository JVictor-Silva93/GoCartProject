package src.main.java.gocart.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ShoppingCart {
    private Map<Product, Integer> items;

    public ShoppingCart() {
        items = new HashMap<>();
    }

    /**
     * Adds a product to the shopping cart or updates its quantity if it already exists.
     * 
     * @param product The product to add.
     * @param quantity The quantity of the product.
     */
    public void addProduct(Product product, int quantity) {
        if (product == null || quantity <= 0) {
            throw new IllegalArgumentException("Invalid product or quantity");
        }
        items.merge(product, quantity, Integer::sum);
    }

    /**
     * Removes a product from the shopping cart.
     * 
     * @param product The product to remove.
     */
    public void removeProduct(Product product) {
        if (product == null || !items.containsKey(product)) {
            throw new IllegalArgumentException("Product not in the cart");
        }
        items.remove(product);
    }

    /**
     * Updates the quantity of a product in the shopping cart.
     * 
     * @param product The product to update.
     * @param quantity The new quantity of the product.
     */
    public void updateProductQuantity(Product product, int quantity) {
        if (product == null || quantity < 0 || !items.containsKey(product)) {
            throw new IllegalArgumentException("Invalid product or quantity");
        }
        if (quantity == 0) {
            removeProduct(product);
        } else {
            items.put(product, quantity);
        }
    }

    /**
     * Retrieves the total price of all items in the cart.
     * 
     * @return The total price.
     */
    public double getTotalPrice() {
        return items.entrySet().stream()
                    .mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue())
                    .sum();
    }

    /**
     * Retrieves all items in the shopping cart.
     * 
     * @return A set of map entries containing products and their quantities.
     */
    public Set<Map.Entry<Product, Integer>> getItems() {
        return items.entrySet();
    }

    /**
     * Clears all items from the shopping cart.
     */
    public void clear() {
        items.clear();
    }
}
