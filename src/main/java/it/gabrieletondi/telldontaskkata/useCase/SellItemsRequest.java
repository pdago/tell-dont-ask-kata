package it.gabrieletondi.telldontaskkata.useCase;

import java.util.ArrayList;
import java.util.List;

public class SellItemsRequest {
    private List<SellItemRequest> requests = new ArrayList<>() ;

    public void add(SellItemRequest itemRequest) {
        requests.add(itemRequest);
    }

    public List<SellItemRequest> getRequests() {
        return requests;
    }
}
