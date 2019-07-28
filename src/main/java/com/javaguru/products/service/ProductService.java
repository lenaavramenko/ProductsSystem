package com.javaguru.products.service;

import com.javaguru.products.domain.Product;
import com.javaguru.products.repository.InMemoryRepository;
import com.javaguru.products.service.validation.ProductValidationService;

public class ProductService {
    private final InMemoryRepository repository;
    private final ProductValidationService validationService;

    public ProductService(InMemoryRepository repository, ProductValidationService validationService) {
        this.repository = repository;
        this.validationService = validationService;
    }

    public Long createProduct(Product product) {
        validationService.validate(product);
        Product createdProduct = repository.add(product);
        return createdProduct.getId();
    }

    public Product findProductById(Long id) {
        return repository.getProductById(id);
    }

    public Product deleteProductById(Long id) {
        return repository.removeProductById(id);
    }

    public void removeAllProducts() {
        repository.removeAllProducts();
    }

    public void printAll() {
        repository.printAll();
    }
}
