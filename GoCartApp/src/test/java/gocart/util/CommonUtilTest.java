package src.test.java.gocart.util;

import src.main.java.gocart.util.CommonUtil;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CommonUtilTest {
    @Test
    public void testIsStringValid() {
        assertTrue(CommonUtil.isStringValid("valid string"), "Non-empty string should be valid");
        assertFalse(CommonUtil.isStringValid(""), "Empty string should be invalid");
        assertFalse(CommonUtil.isStringValid(null), "Null string should be invalid");
    }

    @Test
    public void testFormatPrice() {
        assertEquals("10.00", CommonUtil.formatPrice(10), "Price should be formatted to two decimal places");
        assertEquals("10.12", CommonUtil.formatPrice(10.123), "Price should be rounded to two decimal places");
    }
}
