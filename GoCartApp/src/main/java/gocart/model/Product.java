package src.main.java.gocart.model;

public class Product {
    private String id;
    private String name;
    private double price;
    private String description;
    private int quantity;  // optional, depends on how you manage inventory

    public Product(String id, String name, double price, String description, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
    }

    // Getters and setters for all fields
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Additional methods like validation can be added here
    public boolean isValid() {
        return id != null && !id.trim().isEmpty()
                && name != null && !name.trim().isEmpty()
                && price > 0
                && description != null;
    }

    // Override equals and hashCode if necessary, especially if using in collections

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
