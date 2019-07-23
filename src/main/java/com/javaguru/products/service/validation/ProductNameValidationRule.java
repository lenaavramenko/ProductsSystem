package com.javaguru.products.service.validation;

import com.javaguru.products.domain.Product;

public class ProductNameValidationRule implements ProductValidationRule{

    @Override
    public void validate(Product product) {
        checkNotNull(product);
        if (product.getName().length() < 3 || product.getName().length() > 30) {
            throw new ProductValidationException("Name length should be more than 3 symbols and less than 30");
        }
    }
}
