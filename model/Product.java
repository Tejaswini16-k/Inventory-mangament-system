package model;

public class Product {
    private String id;
    private String name;
    private String category;
    private int quantity;
    private double price;

    public Product(String id, String name, String category, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }

    // Setters
    public void setName(String name) { this.name = name; }
    public void setCategory(String category) { this.category = category; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setPrice(double price) { this.price = price; }

    // Convert product to a single line string
    @Override
    public String toString() {
        return id + "," + name + "," + category + "," + quantity + "," + price;
    }

    // Create a product object from a line string
    public static Product fromString(String line) {
        String[] parts = line.split(",");
        return new Product(parts[0], parts[1], parts[2], Integer.parseInt(parts[3]), Double.parseDouble(parts[4]));
    }
}
