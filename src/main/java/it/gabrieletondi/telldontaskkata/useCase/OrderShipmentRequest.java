package it.gabrieletondi.telldontaskkata.useCase;

import it.gabrieletondi.telldontaskkata.domain.Order;
import it.gabrieletondi.telldontaskkata.repository.OrderRepository;
import it.gabrieletondi.telldontaskkata.service.ShipmentService;

public class OrderShipmentRequest {
    private int orderId;

    public OrderShipmentRequest() {
        orderId = 1;
    }

    public void process(OrderRepository orderRepository, ShipmentService shipmentService) {
        Order order = orderRepository.getById(orderId);
		order.ship();

		orderRepository.save(order);
		shipmentService.ship(order);
	}

}
