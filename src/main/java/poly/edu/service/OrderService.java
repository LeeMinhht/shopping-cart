package poly.edu.service;

import com.fasterxml.jackson.databind.JsonNode;
import poly.edu.domain.Order;

import java.util.List;

public interface OrderService {
    List<Order> findAll();

    Order create(JsonNode orderData);

    Order findById(Long id);

    List<Order> findByUsername(String username);
}
