package src.test.java.gocart.model;

import src.main.java.gocart.model.Inventory;
import src.main.java.gocart.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InventoryTest {
    private Inventory inventory;
    private Product testProduct;

    @BeforeEach
    public void setUp() {
        inventory = new Inventory();
        testProduct = new Product("1", "Test Product", 10.0, "Description", 5);
    }

    @Test
    public void testAddProduct() {
        inventory.addProduct(testProduct, 10);
        assertEquals(10, inventory.getProductQuantity(testProduct),
                "Product should be added with the correct quantity");
    }

    @Test
    public void testUpdateProductQuantity() {
        inventory.addProduct(testProduct, 10);
        inventory.updateProductQuantity(testProduct, 15);
        assertEquals(15, inventory.getProductQuantity(testProduct),
                "Product quantity should be updated correctly");
    }

    @Test
    public void testRemoveProduct() {
        inventory.addProduct(testProduct, 10);
        inventory.removeProduct(testProduct);
        assertEquals(0, inventory.getProductQuantity(testProduct),
                "Product should be removed from the inventory");
    }

    @Test
    public void testGetProductQuantityNotInInventory() {
        assertEquals(0, inventory.getProductQuantity(testProduct),
                "Getting quantity of a product not in inventory should return 0");
    }
}
