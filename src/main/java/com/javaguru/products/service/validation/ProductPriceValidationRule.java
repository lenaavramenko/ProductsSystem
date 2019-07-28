package com.javaguru.products.service.validation;

import com.javaguru.products.domain.Product;

import java.math.BigDecimal;

public class ProductPriceValidationRule implements ProductValidationRule{

    @Override
    public void validate(Product product) {
        checkNotNull(product);
        if (product.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
            throw new ProductValidationException("Price must be more than 0");
        }
    }
}
