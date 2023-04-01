package poly.edu.rest.controller;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import poly.edu.domain.Order;
import poly.edu.domain.Product;
import poly.edu.service.OrderService;
import poly.edu.service.ProductService;

import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/orders")
public class OrderRestController {
  @Autowired
    OrderService orderService;

  @PostMapping()
    public Order create(@RequestBody JsonNode orderData){
        return orderService.create(orderData);
  }
}
