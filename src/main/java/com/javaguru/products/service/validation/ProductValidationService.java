package com.javaguru.products.service.validation;

import com.javaguru.products.domain.Product;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class ProductValidationService {

    private final Set<ProductValidationRule> validationRules;

    public ProductValidationService(Set<ProductValidationRule> validationRules) {
        this.validationRules = validationRules;
    }

    public void validate(Product product) {
        validationRules.forEach(s -> s.validate(product));
    }

}
