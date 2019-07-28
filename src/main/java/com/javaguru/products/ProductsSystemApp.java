package com.javaguru.products;

import com.javaguru.products.console.ConsoleUI;
import com.javaguru.products.repository.InMemoryRepository;
import com.javaguru.products.service.ProductService;
import com.javaguru.products.service.validation.*;

import java.util.HashSet;
import java.util.Set;

class ProductsSystemApp {
    public static void main(String[] args) {

        InMemoryRepository repository = new InMemoryRepository();
        ProductValidationRule productNameValidationRule = new ProductNameValidationRule();
        ProductValidationRule productPriceValidationRule = new ProductPriceValidationRule();
        ProductValidationRule productDiscountValidationRule = new ProductDiscountValidationRule();

        Set<ProductValidationRule> rules = new HashSet<>();
        rules.add(productNameValidationRule);
        rules.add(productPriceValidationRule);
        rules.add(productDiscountValidationRule);

        ProductValidationService validationService = new ProductValidationService(rules);
        ProductService productService = new ProductService(repository, validationService);

        ConsoleUI consoleUI = new ConsoleUI(productService);
        consoleUI.execute();
    }
}