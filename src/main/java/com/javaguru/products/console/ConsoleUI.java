package com.javaguru.products.console;

import com.javaguru.products.domain.Category;
import com.javaguru.products.domain.Product;
import com.javaguru.products.service.ProductService;

import java.math.BigDecimal;

import java.util.Scanner;

public class ConsoleUI {
    private ProductService productService = new ProductService();

    public void execute() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.println("1. Create product");
                System.out.println("2. Find product by id");
                System.out.println("3. Delete product");
                System.out.println("4. Edit Product");
                System.out.println("5. Exit");
                Integer userInput = Integer.valueOf(scanner.nextLine());
                switch (userInput) {
                    case 1:
                        createProduct();
                        break;
                    case 2:
                        findProduct();
                        break;
                    case 3:
                        deleteProduct();
                        break;
                    case 4:
                        editProduct();
                        break;
                    case 5:
                        return;
                }
            } catch (
                    Exception e) {
                e.printStackTrace();
                System.out.println("Error! Please try again.");
            }
        }
    }

    private void createProduct() {
        Product product = new Product();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product name: ");
        String name = scanner.nextLine();

        System.out.println("Enter product price: ");
        BigDecimal price = new BigDecimal(scanner.nextLine());

        System.out.println("Enter product discount: ");
        BigDecimal discount = new BigDecimal(scanner.nextLine());

        System.out.println("Enter product description: ");
        String description = scanner.nextLine();

        System.out.println("Enter product category: ");

        System.out.println("1. " + Category.ALCOHOL);
        System.out.println("2. " + Category.FISH);
        System.out.println("3. " + Category.FRUIT);
        System.out.println("4. " + Category.MEAT);
        System.out.println("5. " + Category.MILK);
        System.out.println("6. " + Category.VEGETABLE);

        try {
            Integer userInputCategory = Integer.valueOf(scanner.nextLine());
            switch (userInputCategory) {
                case 1:
                    product.setCategory(Category.ALCOHOL);
                    break;
                case 2:
                    product.setCategory(Category.FISH);
                    break;
                case 3:
                    product.setCategory(Category.FRUIT);
                    break;
                case 4:
                    product.setCategory(Category.MEAT);
                    break;
                case 5:
                    product.setCategory(Category.MILK);
                    break;
                case 6:
                    product.setCategory(Category.VEGETABLE);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error, try again");
        }

        product.setName(name);
        product.setPrice(price);
        product.setDiscount(discount);
        product.setDescription(description);

        productService.createProduct(product);
        System.out.println(product.toString());
    }

    private void findProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product id: ");
        long id = scanner.nextLong();
        Product product = productService.findProductById(id);
        System.out.println(product);
    }

    private void deleteProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product id to DELETE: ");
        long id = scanner.nextLong();
        Product product = productService.deleteProductById(id);
        System.out.println("Product " + product.getName() + " is deleted!");
    }

    private void editProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product id to edit: ");
        long id = scanner.nextLong();

        System.out.println("Please, choose what do you want to change:");
        System.out.println();
        System.out.println("1. Change name");
        System.out.println("2. Change price");
        System.out.println("3. Set Discount");
        System.out.println("4. Change description");
        System.out.println();
        int pickedAction = scanner.nextInt();

        switch (pickedAction) {
            case 1:
                System.out.println("Enter new name: ");
                String newName = scanner.nextLine();
                productService.findProductById(id).setName(newName);
                break;
            case 2:
                System.out.println("Enter new price: ");
                BigDecimal newPrice = BigDecimal.valueOf(scanner.nextDouble());
                productService.findProductById(id).setPrice(newPrice);
                break;
            case 3:
                System.out.println("Enter new discount: ");
                BigDecimal newDiscount = BigDecimal.valueOf(scanner.nextDouble());
                productService.findProductById(id).setDiscount(newDiscount);
                break;
            case 4:
                System.out.println("Enter new description: ");
                String newDescription = scanner.nextLine();
                productService.findProductById(id).setDescription(newDescription);
                break;
        }
        System.out.println("Information is updated");
    }
}
