package main;

import controller.InventoryController;
import model.Product;
import view.ProductView;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProductView view = new ProductView();
        InventoryController controller = new InventoryController();

        while (true) {
            int choice = view.showMenu();

            try {
                switch (choice) {
                    case 1:
                        Product newProduct = view.getProductDetails();
                        controller.addProduct(newProduct);
                        view.displayMessage("Product added successfully!");
                        break;

                    case 2:
                        List<Product> products = controller.getAllProducts();
                        if (products.isEmpty()) {
                            view.displayMessage("No products found.");
                        } else {
                            for (Product p : products) {
                                view.displayProduct(p);
                            }
                        }
                        break;

                    case 3:
                        String updateId = view.getProductId("update");
                        Product updatedProduct = view.getProductDetails();
                        controller.updateProduct(updateId, updatedProduct);
                        view.displayMessage("Product updated successfully!");
                        break;

                    case 4:
                        String deleteId = view.getProductId("delete");
                        controller.deleteProduct(deleteId);
                        view.displayMessage("Product deleted successfully!");
                        break;

                    case 5:
                        view.displayMessage("Exiting... Thank you!");
                        return;

                    default:
                        view.displayMessage("Invalid option. Please try again.");
                }
            } catch (IOException e) {
                view.displayMessage("Error: " + e.getMessage());
            }
        }
    }
}
