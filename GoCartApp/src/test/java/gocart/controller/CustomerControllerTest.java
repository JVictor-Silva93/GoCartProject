package src.test.java.gocart.controller;

import src.main.java.gocart.controller.CustomerController;
import src.main.java.gocart.model.Product;
import src.main.java.gocart.model.ShoppingCart;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class CustomerControllerTest {
    private CustomerController customerController;
    private ShoppingCart mockCart;

    @BeforeEach
    public void setUp() {
        mockCart = Mockito.mock(ShoppingCart.class);
        customerController = new CustomerController(mockCart);
    }

    @Test
    public void testAddProductToCart() {
        Product product = new Product("1", "Test Product", 10.0, "Description", 5);
        customerController.addProductToCart(product, 1);
        
        Mockito.verify(mockCart).addProduct(product, 1);
    }

    @Test
    public void testRemoveProductFromCart() {
        Product product = new Product("1", "Test Product", 10.0, "Description", 5);
        customerController.removeProductFromCart(product);
        
        Mockito.verify(mockCart).removeProduct(product);
    }
}
