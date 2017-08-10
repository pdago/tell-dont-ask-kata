package it.gabrieletondi.telldontaskkata.useCase;

import it.gabrieletondi.telldontaskkata.domain.Order;

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

    public void processOrder(Order order) {
        if (approved)
            order.approve();
        else
            order.reject();
    }

    public int getOrderId() {
        return orderId;
    }
}
