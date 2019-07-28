package com.javaguru.products.service.validation;

import com.javaguru.products.domain.Product;

import java.math.BigDecimal;

public class ProductDiscountValidationRule implements ProductValidationRule{

    @Override
    public void validate(Product product) {
        checkNotNull(product);
        BigDecimal maxDiscount = new BigDecimal(80);
        if (product.getDiscount().compareTo(BigDecimal.ZERO) < 0 || product.getDiscount().compareTo(maxDiscount) > 0) {
            throw new ProductValidationException("Discount must be more than 0% and less than 80%");
        }
    }
}
