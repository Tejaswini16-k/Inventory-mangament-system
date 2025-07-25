package controller;

import model.Product;

import java.io.*;
import java.util.*;

public class InventoryController {
    private static final String FILE_NAME = "inventory.txt";

    public void addProduct(Product product) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(product.toString());
            writer.newLine();
        }
    }

    public List<Product> getAllProducts() throws IOException {
        List<Product> products = new ArrayList<>();
        File file = new File(FILE_NAME);
        if (!file.exists()) return products;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                products.add(Product.fromString(line));
            }
        }
        return products;
    }

    public void updateProduct(String id, Product newProduct) throws IOException {
        List<Product> products = getAllProducts();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Product p : products) {
                if (p.getId().equals(id)) {
                    writer.write(newProduct.toString());
                } else {
                    writer.write(p.toString());
                }
                writer.newLine();
            }
        }
    }

    public void deleteProduct(String id) throws IOException {
        List<Product> products = getAllProducts();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Product p : products) {
                if (!p.getId().equals(id)) {
                    writer.write(p.toString());
                    writer.newLine();
                }
            }
        }
    }
}
