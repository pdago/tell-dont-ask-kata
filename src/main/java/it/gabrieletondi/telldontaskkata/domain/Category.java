package it.gabrieletondi.telldontaskkata.domain;

import java.math.BigDecimal;

import static java.math.BigDecimal.valueOf;
import static java.math.RoundingMode.HALF_UP;

public class Category {
    private String name;
    private BigDecimal taxPercentage;

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getTaxPercentage() {
        return taxPercentage;
    }

    public void setTaxPercentage(BigDecimal taxPercentage) {
        this.taxPercentage = taxPercentage;
    }

    public BigDecimal computeTax(BigDecimal price) {
        return price.divide(valueOf(100)).multiply(taxPercentage).setScale(2, HALF_UP);
    }
}
