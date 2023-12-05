package src.main.java.gocart.util;

public class CommonUtil {
    
    /**
     * Validates if a given string is non-null and not empty.
     * 
     * @param str The string to validate.
     * @return true if the string is non-null and not empty; false otherwise.
     */
    public static boolean isStringValid(String str) {
        return str != null && !str.trim().isEmpty();
    }

    // Additional utility methods can be added here

    /**
     * Example method for formatting a price to a string with two decimal places.
     * 
     * @param price The price to format.
     * @return Formatted price string.
     */
    public static String formatPrice(double price) {
        return String.format("%.2f", price);
    }

}
