package src.test.java.gocart.model;

import src.main.java.gocart.model.Product;
import src.main.java.gocart.model.ShoppingCart;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ShoppingCartTest {
    
    private ShoppingCart cart;
    private Product product1;
    private Product product2;

    @BeforeEach
    public void setUp() {
        cart = new ShoppingCart();
        product1 = new Product("1", "Test Product 1", 20.0, "Description 1", 10);
        product2 = new Product("2", "Test Product 2", 40.0, "Description 2", 5);
    }

    @Test
    public void testAddProduct() {
        cart.addProduct(product1, 2);
        assertEquals(2, cart.getProductQuantity(product1), "Product 1 should be added with the correct quantity");
    }

    @Test
    public void testUpdateProductQuantity() {
        cart.addProduct(product1, 2);
        cart.updateProductQuantity(product1, 5);
        assertEquals(5, cart.getProductQuantity(product1), "Product 1 quantity should be updated correctly");
    }

    @Test
    public void testRemoveProduct() {
        cart.addProduct(product1, 2);
        cart.removeProduct(product1);
        assertEquals(0, cart.getProductQuantity(product1), "Product 1 should be removed from the cart");
    }

    @Test
    public void testGetTotalPrice() {
        cart.addProduct(product1, 2); // Total: 40.0
        cart.addProduct(product2, 1); // Total: 40.0 + 40.0 = 80.0
        assertEquals(80.0, cart.getTotalPrice(), "Total price should be calculated correctly");
    }

    @Test
    public void testClearCart() {
        cart.addProduct(product1, 2);
        cart.addProduct(product2, 3);
        cart.clear();
        assertEquals(0, cart.getTotalPrice(), "Cart should be empty after clear operation");
    }

}
