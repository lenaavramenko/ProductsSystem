package com.javaguru.products.service.validation;

import com.javaguru.products.domain.Product;

import java.math.BigDecimal;

public class Validator {

    void validateProduct(Product product) {
        validateName(product.getName());
        validateDiscount(product.getDiscount());
        validatePrice(product.getPrice());
    }

    void validateName(String name) {
        if (name.length() < 3 || name.length() > 30) {
            throw new ProductValidationException("Name length should be more than 3 symbols and less than 30");
        }
    }

    void validateDiscount(BigDecimal discount) {
        BigDecimal maxDiscount = new BigDecimal(80);
        if (discount.compareTo(BigDecimal.ZERO) < 0 || discount.compareTo(maxDiscount) > 0) {
            throw new ProductValidationException("Discount must be more than 0% and less than 80%");
        }
    }

    void validatePrice(BigDecimal price) {
        if (price.compareTo(BigDecimal.ZERO) <= 0) {
            throw new ProductValidationException("Price must be more than 0");
        }
    }
}
