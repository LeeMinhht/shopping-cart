package poly.edu.service;

import poly.edu.domain.OrderDetail;

import java.util.List;

public interface OrderDetailService {
    List<OrderDetail> findAll();



    List<OrderDetail> findByOrderId(Long id);
}
