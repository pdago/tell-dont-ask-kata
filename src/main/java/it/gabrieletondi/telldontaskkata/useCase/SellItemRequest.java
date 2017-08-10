package it.gabrieletondi.telldontaskkata.useCase;

public class SellItemRequest {
    private int quantity;
    private String productName;

    public SellItemRequest(String productName, int quantity) {
        this.productName = productName;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getProductName() {
        return productName;
    }
}
