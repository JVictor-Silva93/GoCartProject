package src.test.java.gocart.model;

import src.main.java.gocart.model.Product;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {
    
    @Test
    public void testProductCreation() {
        Product product = new Product("1", "Test Product", 10.0, "Description", 5);

        assertNotNull(product, "Product should be successfully created");
        assertEquals("1", product.getId(), "Product ID should be set correctly");
        assertEquals("Test Product", product.getName(), "Product name should be set correctly");
        assertEquals(10.0, product.getPrice(), "Product price should be set correctly");
        assertEquals("Description", product.getDescription(), "Product description should be set correctly");
        assertEquals(5, product.getQuantity(), "Product quantity should be set correctly");
    }

    @Test
    public void testProductValidation() {
        Product validProduct = new Product("1", "Valid Product", 10.0, "Valid Description", 5);
        assertTrue(validProduct.isValid(), "Product should be valid");

        Product invalidProduct = new Product(null, "", -10.0, null, -5);
        assertFalse(invalidProduct.isValid(), "Product with invalid fields should be invalid");
    }

}
