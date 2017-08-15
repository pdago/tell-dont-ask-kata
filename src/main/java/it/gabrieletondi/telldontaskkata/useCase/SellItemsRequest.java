package it.gabrieletondi.telldontaskkata.useCase;

import it.gabrieletondi.telldontaskkata.domain.Order;
import it.gabrieletondi.telldontaskkata.domain.OrderItem;
import it.gabrieletondi.telldontaskkata.domain.OrderStatus;
import it.gabrieletondi.telldontaskkata.domain.Product;
import it.gabrieletondi.telldontaskkata.repository.ProductCatalog;

import java.util.ArrayList;
import java.util.List;

public class SellItemsRequest {
	private List<SellItemRequest> requests = new ArrayList<>() ;

	public void add(SellItemRequest itemRequest) {
		requests.add(itemRequest);
	}

	public Order generateOrder(ProductCatalog productCatalog) {
		Order order = new Order(1, OrderStatus.CREATED);
		for (SellItemRequest itemRequest : requests) {

			Product product = productCatalog.getByName(itemRequest.getProductName());

			if (product == null) {
				throw new UnknownProductException();
			}
			else {
				final OrderItem orderItem = new OrderItem(product, itemRequest.getQuantity());
				order.addItem(orderItem);
			}
		}
		return order;
	}
}
