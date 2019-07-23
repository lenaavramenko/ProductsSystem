package com.javaguru.products.domain;

import java.math.BigDecimal;

import static java.math.RoundingMode.CEILING;

public class Product {

    private Long id;
    private String name;
    private BigDecimal price;
    private String description;
    private Category category;
    private BigDecimal discount;
    private BigDecimal discountPrice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
        setDiscountPrice();
    }

    void setDiscountPrice(){
        BigDecimal hundred = new BigDecimal("100");
        discountPrice = price.subtract((price.multiply(discount).divide(hundred, 2, CEILING)));
    }

    @Override
    public String toString() {

        return "ID: " + id
                + " | Name: " + name
                + " | Price = " + price + " \u20AC/kg"
                + " | Discount = " + discount + " %"
                + " | Description: " + description
                + " | Category: " + category
                + " | Discount price = " + discountPrice + " \u20AC/kg";
    }
}
