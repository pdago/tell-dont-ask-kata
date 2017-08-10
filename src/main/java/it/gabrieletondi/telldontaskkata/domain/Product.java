package it.gabrieletondi.telldontaskkata.domain;

import java.math.BigDecimal;

public class Product {
    private String name;
    private BigDecimal price;
    private Category category;

    public Product(String name, Category category, BigDecimal price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }
}