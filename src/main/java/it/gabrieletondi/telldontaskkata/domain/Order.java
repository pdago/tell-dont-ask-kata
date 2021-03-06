package it.gabrieletondi.telldontaskkata.domain;

import it.gabrieletondi.telldontaskkata.useCase.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static it.gabrieletondi.telldontaskkata.domain.OrderStatus.CREATED;
import static it.gabrieletondi.telldontaskkata.domain.OrderStatus.REJECTED;
import static it.gabrieletondi.telldontaskkata.domain.OrderStatus.SHIPPED;
import static java.math.RoundingMode.HALF_UP;

public class Order {
    private String currency;
    private List<OrderItem> items;
    private OrderStatus status = OrderStatus.CREATED;
    private int id;

    public Order(int id, OrderStatus status) {
        this.status = status;
        this.id = id;
        items = new ArrayList<>();
        currency = "EUR";
    }

    public void addItem(OrderItem item) {
    	items.add(item);
	}
    public void approve() {
        if (this.status.equals(OrderStatus.SHIPPED)) {
            throw new ShippedOrdersCannotBeChangedException();
        }

        if (this.status.equals(OrderStatus.REJECTED)) {
            throw new RejectedOrderCannotBeApprovedException();
        }

        status = OrderStatus.APPROVED;
    }

    public void reject() {
        if (this.status.equals(OrderStatus.SHIPPED)) {
            throw new ShippedOrdersCannotBeChangedException();
        }

        if (this.status.equals(OrderStatus.APPROVED)) {
            throw new ApprovedOrderCannotBeRejectedException();
        }

        status = OrderStatus.REJECTED;
    }

    public void ship() {
		if (status.equals(CREATED) || status.equals(REJECTED)) {
			throw new OrderCannotBeShippedException();
		}

		if (status.equals(SHIPPED)) {
			throw new OrderCannotBeShippedTwiceException();
		}

        status = OrderStatus.SHIPPED;
    }

    public BigDecimal computeTotal() {
		BigDecimal total = new BigDecimal(0.0);
		for (OrderItem item : items) {
			total = total.add(item.computeTaxedAmount()).setScale(2, HALF_UP);
		}

		return total;
    }

    public String getCurrency() {
        return currency;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public BigDecimal computeTax() {
		BigDecimal tax = new BigDecimal(0);
		for (OrderItem item : items) {
			tax = tax.add(item.computeTax());
		}

		return tax;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
