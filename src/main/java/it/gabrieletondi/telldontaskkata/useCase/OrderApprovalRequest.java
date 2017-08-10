package it.gabrieletondi.telldontaskkata.useCase;

public class OrderApprovalRequest {
    private int orderId;
    private boolean approved;

    public OrderApprovalRequest() {
        orderId = 1;
        approved = false;
    }

    public void approve() {
        approved = true;
    }

    public void reject() {
        approved = false;
    }
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public boolean isApproved() {
        return approved;
    }
}
