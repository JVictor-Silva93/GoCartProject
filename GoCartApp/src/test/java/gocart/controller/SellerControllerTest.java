package src.test.java.gocart.controller;

import src.main.java.gocart.controller.SellerController;
import src.main.java.gocart.model.Product;
import src.main.java.gocart.util.DatabaseUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;

public class SellerControllerTest {
    private SellerController sellerController;

    @BeforeEach
    public void setUp() {
        // Mocking the DatabaseUtil class
        DatabaseUtil mockDatabaseUtil = Mockito.mock(DatabaseUtil.class);
        sellerController = new SellerController(mockDatabaseUtil);
    }

    @Test
    public void testAddProduct() {
        Product product = new Product("1", "Test Product", 10.0, "Description", 5);

        // Assuming DatabaseUtil.addProduct returns true for successful addition
        Mockito.when(DatabaseUtil.addProduct(product)).thenReturn(true);

        boolean result = sellerController.addProduct(product);
        assertTrue(result, "Product should be added successfully");

        // Verifying if DatabaseUtil.addProduct was called with the correct product
        Mockito.verify(DatabaseUtil.addProduct(product));
    }

    @Test
    public void testUpdateProduct() {
        Product product = new Product("1", "Updated Product", 12.0, "Updated Description", 10);

        // Assuming DatabaseUtil.updateProduct returns true for successful update
        Mockito.when(DatabaseUtil.updateProduct(product)).thenReturn(true);

        boolean result = sellerController.updateProduct(product);
        assertTrue(result, "Product should be updated successfully");

        // Verifying if DatabaseUtil.updateProduct was called with the correct product
        Mockito.verify(DatabaseUtil.updateProduct(product));
    }

    @Test
    public void testRemoveProduct() {
        Product product = new Product("1", "Test Product", 10.0, "Description", 5);

        // Assuming DatabaseUtil.removeProduct returns true for successful removal
        Mockito.when(DatabaseUtil.removeProduct(product)).thenReturn(true);

        boolean result = sellerController.removeProduct(product);
        assertTrue(result, "Product should be removed successfully");

        // Verifying if DatabaseUtil.removeProduct was called with the correct product
        Mockito.verify(DatabaseUtil.removeProduct(product));
    }

    @Test
    public void testGetSalesMetrics() {
        // Assuming DatabaseUtil.getSalesMetrics returns some sales metrics
        // Here you would replace 'SalesMetricsType' with your actual sales metrics type
        SalesMetricsType expectedMetrics = new SalesMetricsType(); 
        Mockito.when(DatabaseUtil.getSalesMetrics()).thenReturn(expectedMetrics);

        SalesMetricsType actualMetrics = sellerController.getSalesMetrics();
        assertEquals(expectedMetrics, actualMetrics, "Sales metrics should be fetched correctly");

        // Verifying if DatabaseUtil.getSalesMetrics was called
        Mockito.verify(DatabaseUtil.getSalesMetrics());
    }
}
