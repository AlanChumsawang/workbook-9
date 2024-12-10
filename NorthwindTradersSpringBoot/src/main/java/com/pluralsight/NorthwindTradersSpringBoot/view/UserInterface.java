package com.pluralsight.NorthwindTradersSpringBoot.view;

import com.pluralsight.NorthwindTradersSpringBoot.dao.ProductDao;
import com.pluralsight.NorthwindTradersSpringBoot.dao.SimpleProductDao;
import com.pluralsight.NorthwindTradersSpringBoot.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class UserInterface {
    protected static Scanner scanner = new Scanner(System.in);

    @Autowired
    ProductDao simpleProduct;



    public void display(){
        while (true) {
            System.out.println("""
					\n
     
     
					1.List Products
					2.Add Product
					Choose an option: """);

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    listProducts();
                    break;
                case 2:
                    addProduct();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addProduct() {
        System.out.println("Enter product ID:");
        int productId = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.println("Enter product name:");
        String name = scanner.nextLine();

        System.out.println("Enter product category:");
        String category = scanner.nextLine();

        System.out.println("Enter product price:");
        double price = scanner.nextDouble();
        scanner.nextLine(); // consume newline

        Product product = new Product(productId, name, category, price);
        simpleProduct.add(product);
        System.out.println("Product added: " + product.getName());
    }

    private void listProducts() {
        List<Product> products = simpleProduct.getAll();
        for (Product product : products) {
            System.out.printf("ID: %d, Name: %s, Category: %s, Price: %.2f%n",
                    product.getProductId(), product.getName(), product.getCategory(), product.getPrice());
        }
    }
}

