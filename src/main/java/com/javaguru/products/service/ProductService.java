package com.javaguru.products.service;

import com.javaguru.products.domain.Product;
import com.javaguru.products.repository.InMemoryRepository;
import com.javaguru.products.service.validation.ProductValidationService;

public class ProductService {
    private InMemoryRepository repository = new InMemoryRepository();
    private ProductValidationService validationService = new ProductValidationService();

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

}
