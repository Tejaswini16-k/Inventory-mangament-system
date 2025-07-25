package view;

import java.util.Scanner;
import model.Product;

public class ProductView {
    private Scanner sc = new Scanner(System.in);

    public int showMenu() {
        System.out.println("\n===== Inventory Menu =====");
        System.out.println("1. Add Product");
        System.out.println("2. View Products");
        System.out.println("3. Update Product");
        System.out.println("4. Delete Product");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
        return sc.nextInt();
    }

    public Product getProductDetails() {
        sc.nextLine(); // clear buffer
        System.out.print("Enter ID: ");
        String id = sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Category: ");
        String category = sc.nextLine();
        System.out.print("Enter Quantity: ");
        int quantity = sc.nextInt();
        System.out.print("Enter Price: ");
        double price = sc.nextDouble();
        return new Product(id, name, category, quantity, price);
    }

    public String getProductId(String action) {
        sc.nextLine(); // clear buffer
        System.out.print("Enter Product ID to " + action + ": ");
        return sc.nextLine();
    }

    public void displayProduct(Product p) {
        System.out.println("ID: " + p.getId() + ", Name: " + p.getName() +
                ", Category: " + p.getCategory() +
                ", Quantity: " + p.getQuantity() +
                ", Price: " + p.getPrice());
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}
